package tdc.k8.serviceb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api/v1/serviceb")
public class ServiceBController {

    @Value("${testServiceBEnv}")
    private String testServiceBEnv;

    @Autowired
    ServiceAClient serviceAClient;

    @Value("${ossimanager}")
    private String ossiManagerName;


    @GetMapping("/")
    public TestDTO getTestData() {

        ResponseEntity<TestDTO> serviceEnvironment = serviceAClient.getServiceEnvironment();
        HttpStatus statusCode = serviceEnvironment.getStatusCode();
        if (statusCode.isError()) {
            return new TestDTO(testServiceBEnv + " # statuscode from service a: " + statusCode.getReasonPhrase() + " # " + statusCode.value() + " # " + statusCode.toString());
        } else {
            return new TestDTO(testServiceBEnv + " # statuscode from service a:" + statusCode.getReasonPhrase() + " # " + serviceEnvironment.getBody().getTestEnv());
        }
    }

    @GetMapping("/ossimanager")
    public TestDTO getOssiManager() {

        return new TestDTO(ossiManagerName + "  hostname : " + System.getenv("HOSTNAME"));
    }


}
