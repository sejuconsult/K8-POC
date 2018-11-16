package tdc.k8.serviceb;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "servicea-service")
@Profile("!local")
public interface ServiceAClientK8 extends ServiceAClient {

}
