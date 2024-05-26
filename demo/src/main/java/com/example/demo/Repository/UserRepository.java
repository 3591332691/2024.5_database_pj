package com.example.demo.Repository;

import com.example.demo.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
    // You can add custom query methods here if needed
    User findByUserID(int userID);

    // 设置用户的性别
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.gender = :gender WHERE u.userID = :userID")
    void setUserGender(@Param("userID") int userID, @Param("gender") String gender);
}
