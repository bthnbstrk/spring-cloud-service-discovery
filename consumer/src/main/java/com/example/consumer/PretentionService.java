package com.example.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "anyname",url="http://localhost:8081")
public interface PretentionService {

    @GetMapping("/produce/process/{name}/{value}")
    String getResult(@PathVariable("name") String name, @PathVariable("value")int value);
}
