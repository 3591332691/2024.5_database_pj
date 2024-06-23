package com.example.demo.Controller;


import com.example.demo.Entity.Favored_goods;
import com.example.demo.Entity.Order;
import com.example.demo.Service.Favored_goodsService;
import com.example.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService ordersService) {
        this.orderService = ordersService;
    }

    @GetMapping("/order/userID/{userID}")
    public List<Order> getOrderByUserID(@PathVariable int userID) {
        return orderService.getOrderByUserID(userID);
    }




}
