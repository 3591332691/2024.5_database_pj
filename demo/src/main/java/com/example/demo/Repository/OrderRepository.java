package com.example.demo.Repository;

import com.example.demo.Entity.Favored_goods;
import com.example.demo.Entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order,Integer>{

    @Transactional
    @Query("SELECT o FROM Order o WHERE o.userID = :userID")
    List<Order> findByUserID(int userID);

    @Transactional
    @Query("SELECT o FROM Order o WHERE o.merchantID = :merchantID")
    List<Order> findByMerchantID(int merchantID);

    List<Order> findAll();
}
