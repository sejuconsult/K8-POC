package tdc.k8.serviceb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ServicebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicebApplication.class, args);
    }
}
