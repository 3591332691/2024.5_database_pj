package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comment_for_shop")
public class Comment_for_shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comment_for_shopID;

    private String content;

    private float rating;

    private int merchantID;

    private int orderID;
}
