package tdc.k8.servicea;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api/v1/servicea")
public class ServiceAController {

    @Value("${testServiceAEnv}")
    private String testServiceAEnv;

    @Value("${ossimanager}")
    private String ossiManagerName;

    @GetMapping("/")
    public TestDTO getTestData() {

        return new TestDTO(testServiceAEnv + "  hostname : " + System.getenv("HOSTNAME"));
    }


    @GetMapping("/ossimanager")
    public TestDTO getOssiManager() {

        return new TestDTO(ossiManagerName + "  hostname : " + System.getenv("HOSTNAME"));
    }

}
