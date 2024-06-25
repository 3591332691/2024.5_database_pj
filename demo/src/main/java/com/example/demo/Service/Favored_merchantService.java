package com.example.demo.Service;

import com.example.demo.Entity.Favored_goods;
import com.example.demo.Entity.Favored_merchant;
import com.example.demo.Entity.Good;
import com.example.demo.Entity.Merchant;
import com.example.demo.Repository.Favored_merchantRepository;
import com.example.demo.Repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Favored_merchantService {
    private final Favored_merchantRepository favored_merchantRepository;
    private final MerchantRepository merchantRepository;

    @Autowired
    public Favored_merchantService(Favored_merchantRepository favored_merchantRepository, MerchantRepository merchantRepository) {
        this.favored_merchantRepository = favored_merchantRepository;
        this.merchantRepository = merchantRepository;
    }

    public List<Favored_merchant> getFavoredGoodByMerchantID(int merchantID) {
        return favored_merchantRepository.findByMerchantID(merchantID);
    }

    public List<Merchant> getFavoredGoodByUserID(int userID) {
        //得到这个user所有的收藏的商户
        List<Favored_merchant> temp = favored_merchantRepository.findByUserID(userID);
        List<Merchant> output = new ArrayList<Merchant>();
        if (!temp.isEmpty()) {
            for (Favored_merchant favored_merchant : temp) {
                Merchant merchant = merchantRepository.findByID(favored_merchant.getMerchantID());
                output.add(merchant);
            }
        }
        return output;
    }

    public void add_favored_merchant_for_user(Integer userID, Integer merchantID) {
        Optional<Favored_merchant> existingFavoredMerchant = favored_merchantRepository.findByUserIDAndMerchantID(userID, merchantID);
        if (existingFavoredMerchant.isPresent()) {
            // 如果已存在相同记录，则不进行插入
            return;
        }
        //进行插入
        Favored_merchant favored_merchant = new Favored_merchant();
        favored_merchant.setMerchantID(merchantID);
        favored_merchant.setUserID(userID);
        favored_merchantRepository.save(favored_merchant);
    }


}
