package com.example.demo.Repository;

import com.example.demo.Entity.Comment;
import com.example.demo.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    // You can add custom query methods here if needed

    List<Comment> findByOrderID(int OrderID);

}
