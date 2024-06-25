package com.example.demo.Service;

import com.example.demo.Entity.Merchant;
import com.example.demo.Repository.MerchantRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantService {
    private final MerchantRepository merchantRepository;

    @Autowired
    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public Merchant getMerchantInfoByMerchantID(int merchantID) {
        return merchantRepository.findById(merchantID)
                .orElseThrow(() -> new RuntimeException("Merchant not found with id: " + merchantID));
    }

    public Merchant getMerchantInfoByName(String name) {
        return merchantRepository.findBymerchant_name(name);
    }

    public List<Merchant> SearchMerchantByName(String merchantName) {
        List<Merchant> merchants = merchantRepository.findBymerchant_nameContaining(merchantName);
        List<Merchant> merchantNames = new ArrayList<>();
        if (merchants.isEmpty()) {
            return merchantNames;
        }
        else{
            return merchants;
        }
    }
}