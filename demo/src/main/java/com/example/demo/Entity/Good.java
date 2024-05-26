package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "good")
public class Good implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goodID;

    private String good_name;

    private float price;

    private String category;

    private String description;

    private String image;

    private boolean if_in_main_dish;

    private int merchantID;
}