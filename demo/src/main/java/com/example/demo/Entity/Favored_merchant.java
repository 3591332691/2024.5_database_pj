package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "favored_merchant")
public class Favored_merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favored_merchantID;
    private int merchantID;
    private int userID;
    private LocalDateTime set_time;

}
