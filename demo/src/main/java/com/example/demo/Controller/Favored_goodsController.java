package com.example.demo.Controller;


import com.example.demo.Entity.Favored_goods;
import com.example.demo.Service.Favored_goodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Favored_goodsController {
    private final Favored_goodsService favored_goodsService;

    @Autowired
    public Favored_goodsController(Favored_goodsService favored_goodsService) {
        this.favored_goodsService = favored_goodsService;
    }

    @GetMapping("/favored_goods/userID/{userID}")
    public List<Favored_goods> getGoodsByUserID(@PathVariable int userID) {
        return favored_goodsService.getFavoredGoodByUserID(userID);
    }




}
