package tdc.k8.serviceb;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public interface ServiceAClient {

    @GetMapping("/api/v1/servicea/")
    ResponseEntity<TestDTO> getServiceEnvironment();
}
