package com.example.demo.Service;

import com.example.demo.Entity.Good;
import com.example.demo.Entity.Merchant;
import com.example.demo.Repository.GoodRepository;
import com.example.demo.Repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodService {
    private final GoodRepository goodRepository;
    private final MerchantRepository merchantRepository;

    @Autowired
    public GoodService(GoodRepository goodRepository,MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
        this.goodRepository = goodRepository;
    }

    public List<Good> getGoodsByMerchantID(int merchantID) {
        return goodRepository.findByMerchantID(merchantID);
    }

    public List<Good> getGoodsInMainByMerchantID(int merchantID) {
        List<Good>temp =  goodRepository.findByMerchantID(merchantID);
        temp.removeIf(good -> good.isIf_in_main_dish() == false);
        return temp;
    }

    public List<Good> getGoodsByMerchant_name(String merchantName) {
        Merchant merchant = merchantRepository.findBymerchant_name(merchantName);
        List<Good> result= new ArrayList<>();
        if (merchant == null) {
            return result;
        }
        else{
            var id =merchant.getMerchantID();
            result = getGoodsByMerchantID(id);
            return result;
        }
    }

    public void GoodsAdd(String goodName, float price, String category, String description, String image, boolean ifInMainDish, int merchantID) {
        Good good = new Good();
        good.setGood_name(goodName);
        good.setPrice(price);
        good.setCategory(category);
        good.setDescription(description);
        good.setImage(image);
        good.setIf_in_main_dish(ifInMainDish);
        good.setMerchantID(merchantID);
        goodRepository.save(good);
    }
}