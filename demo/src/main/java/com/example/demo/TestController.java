package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

   // @Value("${eureka.instance.hostname}")
    private String eurekainstanceH;

    @GetMapping("/")
    public TestDTO getTest() {
        System.out.println("eurekainstanceH = " + eurekainstanceH);
        return new TestDTO("Test:"+ System.getenv("HOSTNAME"));
    }
}
