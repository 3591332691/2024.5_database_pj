package com.example.demo.Controller;

import com.example.demo.Entity.Comment_for_shop;
import com.example.demo.Repository.Comment_for_shopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class Comment_for_shopController {

    @Autowired
    private Comment_for_shopRepository commentForshopRepository;
    /**
     * 正常情况下会返回一个List<Comment>
     * @param orderID
     * @return 没有的话会返回一个null
     */
    @GetMapping("/commentForShop/orderID/{orderID}")
    public  List<Comment_for_shop> getCommentForShopByOrderId(@PathVariable int orderID) {
        List<Comment_for_shop> comment = commentForshopRepository.findbyOrderID(orderID);
        if (comment != null && !comment.isEmpty()) {
            return comment;
        }
        else{
            return Collections.emptyList(); // 返回空列表表示没有评论
        }
    }

    @GetMapping("/commentForShop/addComment/{content}/{rating}/{merchantID}/{orderID}")
    public void addCommentByOrderId(@PathVariable String content,@PathVariable float rating,@PathVariable int merchantID,@PathVariable int orderID) {
        //goodID==0代表是对这个店铺的评论和评价
        //goodID不为0代表是对某一个餐品的评论和评价
        Comment_for_shop commentForshop = new Comment_for_shop();
        commentForshop.setContent(content);
        commentForshop.setRating(rating);
        commentForshop.setMerchantID(merchantID);
        commentForshop.setOrderID(orderID);
        commentForshopRepository.save(commentForshop);
    }


}