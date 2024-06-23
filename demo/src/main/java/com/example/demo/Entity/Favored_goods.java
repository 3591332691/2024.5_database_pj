package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "favored_goods")
public class Favored_goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favored_goodsID;

    private int merchantID;
    private int goodID;
    private int userID;
    private LocalDateTime set_time;

}


