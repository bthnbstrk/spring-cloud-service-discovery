package com.example.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finder")
public class FinderClient {

    private FinderService finderService;

    public FinderClient(FinderService finderService) {
        this.finderService = finderService;
    }

    @GetMapping("/process")
    public String getResult(){
        String result = finderService.getResult("Finder Kullanıldı  ----", 606060);
        return "Çıktı: " + result;
    }
}
