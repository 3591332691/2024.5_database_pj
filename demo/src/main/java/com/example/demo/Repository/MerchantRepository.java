package com.example.demo.Repository;

import com.example.demo.Entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface MerchantRepository extends JpaRepository<Merchant,Integer> {

}
