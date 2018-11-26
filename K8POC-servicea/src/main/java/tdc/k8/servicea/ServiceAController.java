package tdc.k8.servicea;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RefreshScope
@RestController
@RequestMapping("/api/v1/servicea")
public class ServiceAController {

    @Value("${testServiceAEnv}")
    private String testServiceAEnv;

    @Value("${ossimanager}")
    private String ossiManagerName;

    @Value("${PORTFROMAPP}")
    private String port;

    @Value("${eureka.instance.hostname.fromapp}")
    private String eurekainstanceH;

    @GetMapping("/")
    public TestDTO getTestData() {
        System.out.println(System.getenv("HOSTNAME"));
        System.out.println(" kalder /"+ new Date());
        return new TestDTO(testServiceAEnv + "  hostname : " + System.getenv("HOSTNAME"));
    }


    @GetMapping("/ossimanager")
    public TestDTO getOssiManager() {
        System.out.println(System.getenv("HOSTNAME"));
        System.out.println(" kalder ossimanager kl:"+ new Date());
        return new TestDTO(ossiManagerName + "  hostname : " + System.getenv("HOSTNAME"));
    }

    @GetMapping("/deployenv")
    public TestDTO getdeployEnv() {
        return new TestDTO(port +" "+eurekainstanceH);
    }


}
