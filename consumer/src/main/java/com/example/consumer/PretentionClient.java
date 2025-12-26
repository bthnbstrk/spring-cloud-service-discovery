package com.example.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class PretentionClient {

    private PretentionService pretentionService;

    public PretentionClient(PretentionService pretentionService) {
        this.pretentionService = pretentionService;
    }

    @GetMapping("/process")
    public String getResult(){
        String result = pretentionService.getResult("Ürünler", 123123);
        return "Çıktı: " + result;
    }
}
