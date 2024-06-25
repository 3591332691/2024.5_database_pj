package com.example.demo.Controller;


import com.example.demo.Entity.Favored_goods;
import com.example.demo.Entity.Good;
import com.example.demo.Repository.Favored_goodsRepository;
import com.example.demo.Repository.GoodRepository;
import com.example.demo.Service.Favored_goodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Favored_goodsController {
    private final Favored_goodsService favored_goodsService;
    private final Favored_goodsRepository favored_goodsRepository;
    private final GoodRepository goodRepository;

    @Autowired
    public Favored_goodsController(Favored_goodsService favored_goodsService, Favored_goodsRepository favored_goodsRepository, GoodRepository goodRepository) {
        this.favored_goodsService = favored_goodsService;
        this.favored_goodsRepository =  favored_goodsRepository;
        this.goodRepository = goodRepository;
    }

    @GetMapping("/favored_goods/userID/{userID}")
    public List<Good> getGoodsByUserID(@PathVariable int userID) {
        List<Favored_goods>temp =  favored_goodsService.getFavoredGoodByUserID(userID);
        List<Good> goods = new ArrayList<Good>();
        if(temp.size()>0){
            for(Favored_goods favored_goods : temp){
                int goodID = favored_goods.getGoodID();
                Good good = goodRepository.findById2(goodID);
                goods.add(good);
            }
            return goods;
        }
        else{
            return goods;
        }
    }

    /**
     * 得到这个产品的收藏量
     * @param GoodID
     * @return
     */
    @GetMapping("/favored_goods/GoodID/{GoodID}")
    public List<Favored_goods> getGoodsByGoodID(@PathVariable int GoodID) {
        return favored_goodsRepository.findByGoodID(GoodID);
    }

    // 收藏商品
    @PostMapping("/favored_goods/add/{userID}/{GoodID}")
    public void add_favored_goods_for_user(@PathVariable Integer userID, @PathVariable Integer GoodID) {
        favored_goodsService.add_favored_goods_for_user(userID, GoodID);
    }

/*    // 取消收藏商品
    @PostMapping("/favored_goods/remove")
    public ResponseEntity<String> removeFavoredGood(@RequestBody FavoredGoodRequest request) {
        favoredGoodsService.removeFavoredGood(request.getUserId(), request.getGoodId());
        return ResponseEntity.ok("商品取消收藏成功");
    }*/




}
