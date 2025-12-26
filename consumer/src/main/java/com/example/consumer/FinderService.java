package com.example.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "godoromodule")
public interface FinderService {
    @GetMapping("/produce/process/{name}/{value}")
    String getResult(@PathVariable("name") String name, @PathVariable("value")int value);
}