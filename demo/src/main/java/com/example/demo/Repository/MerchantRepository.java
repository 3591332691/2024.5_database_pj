package com.example.demo.Repository;

import com.example.demo.Entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;


public interface MerchantRepository extends JpaRepository<Merchant,Integer> {

    @Query("SELECT m FROM Merchant m WHERE m.merchant_name = :name")
    Merchant findBymerchant_name(String name);

    @Query("SELECT m FROM Merchant m WHERE m.merchantID = :merchantID")
    Merchant findByID(Integer merchantID);

    @Query("SELECT m FROM Merchant m WHERE m.merchant_name LIKE %:merchantName%")
    List<Merchant> findBymerchant_nameContaining(@Param("merchantName") String merchantName);
}
