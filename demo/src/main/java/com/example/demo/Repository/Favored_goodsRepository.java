package com.example.demo.Repository;

import com.example.demo.Entity.Favored_goods;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface Favored_goodsRepository extends JpaRepository<Favored_goods,Integer>{

    @Query("SELECT g FROM Favored_goods g WHERE g.userID = :userID")
    List<Favored_goods> findByUserID(int userID);

    @Query("SELECT g FROM Favored_goods g WHERE g.goodID = :goodID")
    List<Favored_goods> findByGoodID(int goodID);

    @Query("SELECT g FROM Favored_goods g WHERE g.merchantID = :merchantID")
    List<Favored_goods> findByMerchantID(int merchantID);


    @Query("SELECT g FROM Favored_goods g WHERE g.userID = :userID and g.goodID = :goodID")
    Optional<Favored_goods> findByUserIDAndGoodID(Integer userID, Integer goodID);
}
