package com.example.demo.Service;

import com.example.demo.Entity.Merchant;
import com.example.demo.Repository.MerchantRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}