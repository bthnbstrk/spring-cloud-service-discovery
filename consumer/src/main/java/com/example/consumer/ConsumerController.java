package com.example.consumer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consume")
public class ConsumerController {
    private DiscoveryClient discoveryClient;
    private String producerUrlBase;

    public ConsumerController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
        readUrlBase();
    }

    private void readUrlBase() {
        List<ServiceInstance> instances = discoveryClient.getInstances("godoromodule");
        if(instances!=null && !instances.isEmpty()){
            ServiceInstance serviceInstance = instances.get(0);
            producerUrlBase = serviceInstance.getUri().toString();
            System.out.println(serviceInstance.isSecure() + "----- "+ serviceInstance.getScheme());
        }
    }

    @GetMapping("/message")
    public String getMessage(){
        String uri = producerUrlBase+"/produce/message";
        RestTemplate restTemplate = new RestTemplate();
        String message = restTemplate.getForObject(uri,String.class);
        return "Tüketici ---> " + message;
    }
}
