package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    private int merchantID;
    private int userID;
    private LocalDateTime time;
    private String good_id_list;
    private String good_price_list;
    private float total_cost;
    private String status;

}