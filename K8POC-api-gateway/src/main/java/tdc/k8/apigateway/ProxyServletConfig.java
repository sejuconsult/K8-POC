package tdc.k8.apigateway;


import io.swagger.models.Contact;
import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProxyServletConfig  {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new K8POCProxyServlet(), "/");
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("targetUri","foo");
        initParameters.put(ProxyServlet.P_LOG, "true");
        servletRegistrationBean.setInitParameters(initParameters);
        //servletRegistrationBean.addInitParameter(ProxyServlet.P_TARGET_URI, propertyResolver.getProperty("target_url"));
       // servletRegistrationBean.addInitParameter(ProxyServlet.P_LOG, propertyResolver.getProperty("logging_enabled", "false"));
        return servletRegistrationBean;
    }


}