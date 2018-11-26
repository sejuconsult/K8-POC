package tdc.k8.zuulgateway;

import io.fabric8.kubernetes.client.KubernetesClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableScheduling
public class ZuulgatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulgatewayApplication.class, args);
    }

    @Bean
    public K8POCKubernetesCatalogWatch k8POCKubernetesCatalogWatch(KubernetesClient client) {
        return new K8POCKubernetesCatalogWatch(client);
    }
}
