package com.example.demo.Controller;

import com.example.demo.Entity.Good;
import com.example.demo.Entity.Merchant;
import com.example.demo.Service.GoodService;
import com.example.demo.Service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MerchantController {

    private final MerchantService merchantService;
    private final GoodService goodService;

    @Autowired
    public MerchantController(MerchantService merchantService,GoodService goodService) {
        this.merchantService = merchantService;
        this.goodService = goodService;
    }

    @GetMapping("/merchant/id/{merchantID}")
    public Merchant getMerchantInfo(@PathVariable int merchantID) {
        return merchantService.getMerchantInfoByMerchantID(merchantID);
    }
    @GetMapping("/merchant/name/{merchant_name}")
    public Merchant getMerchantInfoByName(@PathVariable String merchant_name) {
        return merchantService.getMerchantInfoByName(merchant_name);
    }

    /**
     * 这个会模糊匹配来返回一个list
     * @param merchant_name
     * @return
     */
    @GetMapping("/merchant/searchByName/{merchant_name}")
    public List<String> SearchMerchantInfoByName(@PathVariable String merchant_name) {
        List<Merchant> merchants = merchantService.SearchMerchantByName(merchant_name);
        List<String>result=new ArrayList<>();
        if(!merchants.isEmpty()) {
            for(Merchant merchant : merchants) {
                int merchantID = merchant.getMerchantID();
                List<Good> goods  = this.goodService.getGoodsInMainByMerchantID(merchantID);
                if (!goods.isEmpty()) {
                    // 假设只取第一个主打菜品作为示例
                    Good mainGood = goods.get(0);
                    String info = merchant.getMerchant_name() + " - " + mainGood.getGood_name();
                    result.add(info);
                }
            }
        }

        return result;
    }
}