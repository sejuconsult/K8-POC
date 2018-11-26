package tdc.k8.zuulgateway;

import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.event.HeartbeatEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class K8POCKubernetesCatalogWatch  implements ApplicationEventPublisherAware{

    private static final Logger logger = LoggerFactory.getLogger(org.springframework.cloud.kubernetes.discovery.KubernetesCatalogWatch.class);

    private final KubernetesClient kubernetesClient;
    private final AtomicReference<List<String>> catalogEndpointsState = new AtomicReference<>();
    private ApplicationEventPublisher publisher;


    public K8POCKubernetesCatalogWatch(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Scheduled(fixedDelayString = "3000")
    public void catalogServicesWatch() {
        try {
            List<String> previousState = catalogEndpointsState.get();
// let try this
            //not all pods participate in the service discovery. only those that have endpoints.
            List<Endpoints> endpoints = kubernetesClient.endpoints().list().getItems();
            List<String> endpointsPodNames =
                    endpoints.stream()
                            .filter(endpoint -> endpoint.getSubsets() != null )
                            .flatMap(endpoint -> endpoint.getSubsets().stream())
                            .filter(subset -> subset.getAddresses() != null )
                            .flatMap(subset -> subset.getAddresses().stream())
                            .filter(endpointAddress -> endpointAddress.getTargetRef() != null  && endpointAddress.getTargetRef().getName() != null)
                            .map(endpointAddress -> endpointAddress.getTargetRef().getName()) // pod name unique in namespace
                            .sorted(String::compareTo).collect(Collectors.toList());

            catalogEndpointsState.set(endpointsPodNames);

            if (!endpointsPodNames.equals(previousState)) {
                logger.trace("Received endpoints update from kubernetesClient: {}", endpointsPodNames);
            }
            publisher.publishEvent(new HeartbeatEvent(this, endpointsPodNames));

        } catch (Exception e) {
            logger.error("Error watching Kubernetes Services", e);
        }
    }


}
