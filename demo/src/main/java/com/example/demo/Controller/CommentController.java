package com.example.demo.Controller;

import com.example.demo.Entity.Comment;
import com.example.demo.Entity.User;
import com.example.demo.Repository.CommentRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * 正常情况下会返回一个List<Comment>
     * @param orderID
     * @return 没有的话会返回一个null
     */
    @GetMapping("/comment/orderID/{orderID}")
    public  List<Comment> getCommentByOrderId(@PathVariable int orderID) {
        List<Comment> comment = commentRepository.findByOrderID(orderID);
        if (comment != null && !comment.isEmpty()) {
            return comment;
        }
        else{
            return Collections.emptyList(); // 返回空列表表示没有评论
        }
    }

    @GetMapping("/comment/addComment/{content}/{rating}/{goodID}/{orderID}")
    public void addCommentByOrderId(@PathVariable String content,@PathVariable float rating,@PathVariable int goodID,@PathVariable int orderID) {
        //goodID==0代表是对这个店铺的评论和评价
        //goodID不为0代表是对某一个餐品的评论和评价
        Comment commentForGood = new Comment();
        commentForGood.setContent(content);
        commentForGood.setRating(rating);
        commentForGood.setGoodID(goodID);
        commentForGood.setOrderID(orderID);
        commentRepository.save(commentForGood);
    }


}