package com.example.demo.Controller;


import com.example.demo.Entity.Good;
import com.example.demo.Repository.GoodRepository;
import com.example.demo.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GoodController {

    private final GoodService goodService;
    private final GoodRepository goodRepository;

    @Autowired
    public GoodController(GoodService goodService, GoodRepository goodRepository) {
        this.goodService = goodService;
        this.goodRepository = goodRepository;
    }

    @GetMapping("/goods/goodID/{goodID}")
    public Optional<Good> getGoodsByID(@PathVariable int goodID) {
        return goodRepository.findByGoodID(goodID);
    }

    /**
     * 用来根据merchantid得到菜单
     * @param merchantID
     * @return
     */
    @GetMapping("/goods/merchantID/{merchantID}")
    public List<Good> getGoodsByMerchantID(@PathVariable int merchantID) {
        return goodService.getGoodsByMerchantID(merchantID);
    }

    @GetMapping("/goods/merchant_name/{merchant_name}")
    public List<Good> getGoodsByMerchant_name(@PathVariable String merchant_name) {
        return goodService.getGoodsByMerchant_name( merchant_name);
    }

    @GetMapping("/goodsInMain/merchantID/{merchantID}")
    public List<Good> getGoodsInMainByMerchantID(@PathVariable int merchantID) {
        return goodService.getGoodsInMainByMerchantID(merchantID);
    }

    @GetMapping("/searchGoodContainInMerchantID")
    public List<Good> searchGoods(@RequestParam(required = true) Integer merchantID,
                                  @RequestParam(required = true) String GoodName) {
        return goodRepository.selectGoodContainInMerchantID(merchantID,GoodName);
    }

    @GetMapping("/goods/add/{good_name}/{price}/{category}/{description}/{image}/{if_in_main_dish}/{merchantID}")
    public void GoodsAdd(@PathVariable String good_name, @PathVariable float price, @PathVariable String category,@PathVariable String description, @PathVariable String image, @PathVariable boolean if_in_main_dish,@PathVariable int merchantID) {
        return goodService.GoodsAdd( good_name,price,category,description,image,if_in_main_dish,merchantID);
    }
}