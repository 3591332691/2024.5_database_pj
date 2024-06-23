package com.example.demo.Repository;

import com.example.demo.Entity.Favored_merchant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface Favored_merchantRepository extends JpaRepository<Favored_merchant,Integer>{
    @Modifying
    @Transactional
    @Query("SELECT g FROM Favored_merchant g WHERE g.userID = :userID")
    List<Favored_merchant> findByUserID(int userID);


    @Modifying
    @Transactional
    @Query("SELECT g FROM Favored_merchant g WHERE g.merchantID = :merchantID")
    List<Favored_merchant> findByMerchantID(int merchantID);
}
