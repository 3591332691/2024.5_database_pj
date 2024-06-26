package com.example.demo.Repository;


import com.example.demo.Entity.Comment_for_shop;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface Comment_for_shopRepository extends JpaRepository<Comment_for_shop,Integer> {

    @Query("SELECT cfs FROM Comment_for_shop cfs WHERE cfs.orderID = :orderID")
    List<Comment_for_shop> findByOrderID(int orderID);

    @Transactional
    @Query("SELECT cfs FROM Comment_for_shop cfs WHERE cfs.orderID = :orderID")
    List<Comment_for_shop> findbyOrderID(int orderID);
}
