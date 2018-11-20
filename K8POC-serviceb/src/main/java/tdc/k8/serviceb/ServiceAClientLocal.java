package tdc.k8.serviceb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "test", url = "http://localhost:8010")
@Profile("local")
public interface ServiceAClientLocal extends ServiceAClient {

}
