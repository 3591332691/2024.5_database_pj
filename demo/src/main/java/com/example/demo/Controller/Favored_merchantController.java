package com.example.demo.Controller;


import com.example.demo.Entity.Favored_merchant;
import com.example.demo.Service.Favored_merchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Favored_merchantController {
    private final Favored_merchantService favored_merchantService;

    @Autowired
    public Favored_merchantController(Favored_merchantService favored_merchantService) {
        this.favored_merchantService = favored_merchantService;
    }

    /**
     * 找到userID相关的所有收藏的商户
     * @param userID
     * @return
     */
    @GetMapping("/favored_merchant/userID/{userID}")
    public List<Favored_merchant> getFavored_merchantByUserID(@PathVariable int userID) {
        return favored_merchantService.getFavoredGoodByUserID(userID);
    }


}
