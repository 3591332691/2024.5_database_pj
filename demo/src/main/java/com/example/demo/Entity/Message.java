package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "message")
public class Message implements BaseEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageID;
    private int orderID;
    private int userID;
    private String content;
}
