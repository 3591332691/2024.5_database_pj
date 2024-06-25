package com.example.demo.Service;

import com.example.demo.Entity.Favored_goods;
import com.example.demo.Entity.Good;
import com.example.demo.Repository.Favored_goodsRepository;
import com.example.demo.Repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Favored_goodsService {
    private final Favored_goodsRepository favored_goodsRepository;
    private final GoodRepository goodRepository;

    @Autowired
    public Favored_goodsService(Favored_goodsRepository favored_goodsRepository,GoodRepository goodRepository) {
        this.favored_goodsRepository = favored_goodsRepository;
        this.goodRepository = goodRepository;
    }

    public List<Favored_goods> getFavoredGoodByMerchantID(int merchantID) {
        return favored_goodsRepository.findByMerchantID(merchantID);
    }

    public List<Favored_goods> getFavoredGoodByUserID(int userID) {
        return favored_goodsRepository.findByUserID(userID);
    }


    public void add_favored_goods_for_user(Integer userID, Integer goodID) {
        Optional<Good> good  = goodRepository.findByGoodID(goodID);
        // 先检查是否已经存在相同的记录
        Optional<Favored_goods> existingFavoredGoods = favored_goodsRepository.findByUserIDAndGoodID(userID, goodID);
        if (existingFavoredGoods.isPresent()) {
            // 如果已存在相同记录，则不进行插入
            return;
        }
        //如果没有记录，进行插入
        if (good.isPresent()){
            int merchantID = good.get().getMerchantID();
            Favored_goods favoredGoods = new Favored_goods();
            favoredGoods.setUserID(userID);
            favoredGoods.setGoodID(goodID);
            favoredGoods.setMerchantID(merchantID);
            favored_goodsRepository.save(favoredGoods);
        }
    }
}
