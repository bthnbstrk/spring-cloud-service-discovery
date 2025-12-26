package com.example.producer;

import jakarta.ws.rs.Path;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class PretentionController {

    @GetMapping("/process/{name}/{value}")
    public String getResult(@PathVariable("name") String name, @PathVariable("value")int value){
        return name.toUpperCase() +"---"+value;
    }

}
