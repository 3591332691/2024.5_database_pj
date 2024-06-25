package com.example.demo.Repository;

import com.example.demo.Entity.Favored_merchant;
import com.example.demo.Entity.Message;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message,Integer>{


    @Query("SELECT m FROM Message m WHERE m.userID = :userID")
    List<Message> getMessageByUserID(int userID);
}
