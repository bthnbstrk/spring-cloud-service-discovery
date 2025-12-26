package com.example.producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class ProducerController {

    @GetMapping("/message")
    public String getMessage(){
        return "Kiplem Üreteci";
    }
}
