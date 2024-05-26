package com.example.demo.Repository;

import com.example.demo.Entity.Good;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface GoodRepository extends JpaRepository<Good,Integer> {


    @Modifying
    @Transactional
    @Query("SELECT g FROM Good g WHERE g.merchantID = :merchantID")
    List<Good> findByMerchantID(int merchantID);


}
