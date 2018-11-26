package tdc.k8.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProxyController {

    @GetMapping
    public TestDTO getTestData() {

        return new TestDTO("swaggerstuff");
    }
}
