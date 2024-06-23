package com.example.demo.Service;

import com.example.demo.Entity.Favored_goods;
import com.example.demo.Entity.Good;
import com.example.demo.Repository.Favored_goodsRepository;
import com.example.demo.Repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Favored_goodsService {
    private final Favored_goodsRepository favored_goodsRepository;

    @Autowired
    public Favored_goodsService(Favored_goodsRepository favored_goodsRepository) {
        this.favored_goodsRepository = favored_goodsRepository;
    }

    public List<Favored_goods> getFavoredGoodByMerchantID(int merchantID) {
        return favored_goodsRepository.findByMerchantID(merchantID);
    }

    public List<Favored_goods> getFavoredGoodByUserID(int userID) {
        return favored_goodsRepository.findByUserID(userID);
    }

    public List<Favored_goods> getFavoredGoodByGoodID(int goodID) {
        return favored_goodsRepository.findByGoodID(goodID);
    }
}
