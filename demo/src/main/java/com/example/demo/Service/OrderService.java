package com.example.demo.Service;

import com.example.demo.Entity.Good;
import com.example.demo.Entity.Order;
import com.example.demo.Repository.GoodRepository;
import com.example.demo.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private static OrderRepository orderRepository;
    private static GoodRepository goodRepository;

    @Autowired
    public OrderService(OrderRepository OrderRepository) {
        OrderService.orderRepository = OrderRepository;
    }

    public List<Order> getOrderByMerchantID(int merchantID) {
        return orderRepository.findByMerchantID(merchantID);
    }

    public List<Order> getOrderByUserID(int userID) {
        return orderRepository.findByUserID(userID);
    }

    public List<Order> getOrderByGoodID(int goodID) {
        Optional<Good> good = goodRepository.findByGoodID(goodID);
        List<Order> output = new ArrayList<>();
        if(good.isPresent()) {
            int merchantID = good.get().getMerchantID();
            List<Order>  candidateOrder = orderRepository.findByMerchantID(merchantID);
            //TODO:遍历candidateOrder,如果good_id_list里有，就加到output里

            return output;
        }
        else{
            return output;
        }
    }


}
