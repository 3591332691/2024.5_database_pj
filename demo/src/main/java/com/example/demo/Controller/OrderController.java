package com.example.demo.Controller;


import com.example.demo.Entity.Good;
import com.example.demo.Entity.Orders;
import com.example.demo.Repository.GoodRepository;
import com.example.demo.Repository.OrdersRepository;
import com.example.demo.Service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;
    private final GoodRepository goodRepository;
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrderController(OrderService ordersService, GoodRepository goodRepository, OrdersRepository ordersRepository) {
        this.orderService = ordersService;
        this.goodRepository = goodRepository;
        this.ordersRepository = ordersRepository;
    }

    @GetMapping("/order/userID/{userID}")
    public List<Orders> getOrderByUserID(@PathVariable int userID) {
        return orderService.getOrderByUserID(userID);
    }

    //获得某一个商品的销量
    @GetMapping("/order/GoodID/{goodID}")
    public List<Orders> getOrderByGoodID(@PathVariable int goodID) {
        return orderService.getOrderByGoodID(goodID);
    }

    //获得某一个店铺的所有的未处理订单
    @GetMapping("/orderUncom/MerchantID/{MerchantID}")
    public List<Orders> getOrderUncomByMerchantID(@PathVariable int MerchantID) {
        return ordersRepository.getOrderUncomByMerchantID(MerchantID);
    }

    //获得某一个订单详情
    @GetMapping("/order/OrderID/{orderID}")
    public Orders getOrderByOrderID(@PathVariable int orderID) {
        return ordersRepository.findByOrderID(orderID);
    }

    //出餐的api
    @Transactional
    @GetMapping("/order/completeByOrderID/{orderID}")
    public void completeByOrderID(@PathVariable int orderID) {
        ordersRepository.completeByOrderID(orderID);
    }

    //下单的api
    @GetMapping("/order/add/{goodID}/{userID}")
    public Orders AddOrderByGoodIDAndUserID(@PathVariable int goodID, @PathVariable int userID) {
        Orders output = new Orders();
        Good temp = goodRepository.findById2(goodID);
        int merchant = temp.getMerchantID();
        float cost = temp.getPrice();
        Orders order = new Orders();
        //设置好userID,goodid列表，初始状态为processing,和费用
        order.setUserID(userID);
        order.setMerchantID(merchant);
        order.setGood_id_list(String.valueOf(goodID));
        order.setGood_price_list(String.valueOf(cost));
        order.setStatus("processing");
        order.setTotal_cost(cost);
        //尝试插入
        try {
            Orders savedOrder = ordersRepository.save(order);
            if (savedOrder != null) {
                output = savedOrder;
            } else {
                output = null;
            }
        } catch (Exception e) {
            e.printStackTrace(); // 可以输出异常信息到控制台或日志
        }
        return output;
    }


}
