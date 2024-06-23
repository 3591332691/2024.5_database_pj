package com.example.demo.Repository;

import com.example.demo.Entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface GoodRepository extends JpaRepository<Good,Integer> {


    @Transactional
    @Query("SELECT g FROM Good g WHERE g.merchantID = :merchantID")
    List<Good> findByMerchantID(int merchantID);

    /**
     * 根据goodID找实体
     *
     * @param goodID
     * @return 没找到的话返回一个空的 Optional 对象
     */
    @Transactional(readOnly = true)
    Optional<Good> findByGoodID(int goodID);


}
