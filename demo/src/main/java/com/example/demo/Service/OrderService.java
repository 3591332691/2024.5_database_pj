package com.example.demo.Service;

import com.example.demo.Entity.Good;
import com.example.demo.Entity.Orders;
import com.example.demo.Repository.GoodRepository;
import com.example.demo.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private static OrdersRepository ordersRepository;
    private static GoodRepository goodRepository;

    @Autowired
    public OrderService(OrdersRepository OrdersRepository, GoodRepository goodRepository) {
        OrderService.ordersRepository = OrdersRepository;
        OrderService.goodRepository = goodRepository;
    }

    public List<Orders> getOrderByMerchantID(int merchantID) {
        return ordersRepository.findByMerchantID(merchantID);
    }

    public List<Orders> getOrderByUserID(int userID) {
        return ordersRepository.findByUserID(userID);
    }

    /**
     * 得到某个商品的所有order
     * @param goodID
     * @return
     */
    public List<Orders> getOrderByGoodID(int goodID) {
        Good good = goodRepository.findById2(goodID);
        List<Orders> output = new ArrayList<>();
        if(good!=null) {
            int merchantID = good.getMerchantID();
            List<Orders>  candidateOrder = ordersRepository.findByMerchantID(merchantID);
            for(Orders order : candidateOrder) {
                String list  = order.getGood_id_list();
                String[] goodIds = list.split(",");
                for (String goodIdItem : goodIds) {
                    if(Integer.parseInt(goodIdItem)==goodID){
                        output.add(order);
                        break;
                    }
                }
            }
            return output;
        }
        else{
            return output;
        }
    }


}
