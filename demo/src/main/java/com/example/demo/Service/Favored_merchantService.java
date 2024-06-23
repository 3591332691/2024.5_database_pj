package com.example.demo.Service;

import com.example.demo.Entity.Favored_merchant;
import com.example.demo.Repository.Favored_merchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Favored_merchantService {
    private final Favored_merchantRepository favored_merchantRepository;

    @Autowired
    public Favored_merchantService(Favored_merchantRepository favored_merchantRepository) {
        this.favored_merchantRepository = favored_merchantRepository;
    }

    public List<Favored_merchant> getFavoredGoodByMerchantID(int merchantID) {
        return favored_merchantRepository.findByMerchantID(merchantID);
    }

    public List<Favored_merchant> getFavoredGoodByUserID(int userID) {
        return favored_merchantRepository.findByUserID(userID);
    }

}
