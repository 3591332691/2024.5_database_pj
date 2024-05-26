package com.example.demo.Controller;


import com.example.demo.Entity.Good;
import com.example.demo.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodController {

    private final GoodService goodService;

    @Autowired
    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

    @GetMapping("/goods/merchantID/{merchantID}")
    public List<Good> getGoodsByMerchantID(@PathVariable int merchantID) {
        return goodService.getGoodsByMerchantID(merchantID);
    }
}