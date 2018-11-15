package tdc.k8.serviceb;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "servicea-service")
public interface ServiceAClient {

    @GetMapping("/api/v1/servicea/")
    ResponseEntity<TestDTO> getServiceEnvironment();
}
