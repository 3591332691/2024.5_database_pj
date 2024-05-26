package com.example.demo.Service;

import com.example.demo.Entity.Good;
import com.example.demo.Repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
    private final GoodRepository goodRepository;

    @Autowired
    public GoodService(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    public List<Good> getGoodsByMerchantID(int merchantID) {
        return goodRepository.findByMerchantID(merchantID);
    }

}