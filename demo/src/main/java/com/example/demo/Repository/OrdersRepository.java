package com.example.demo.Repository;

import com.example.demo.Entity.Orders;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrdersRepository extends JpaRepository<Orders,Integer>{

    @Transactional
    @Query("SELECT o FROM Orders o WHERE o.userID = :userID")
    List<Orders> findByUserID(int userID);

    @Query("SELECT o FROM Orders o WHERE o.merchantID = :merchantID")
    List<Orders> findByMerchantID(int merchantID);

    List<Orders> findAll();

    @Query("SELECT o FROM Orders o WHERE o.orderID = :orderID")
    Orders findByOrderID(int orderID);

    @Query("SELECT o FROM Orders o WHERE o.merchantID = :merchantID and o.status = 'processing'")
    List<Orders> getOrderUncomByMerchantID(int merchantID);

    @Modifying
    @Query("UPDATE Orders o SET o.status = 'complete' WHERE o.orderID = :orderID")
    void  completeByOrderID(int orderID);
}
