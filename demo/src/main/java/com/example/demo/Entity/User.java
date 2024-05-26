package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements BaseEntity {

    /**
     * user id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    /**
     * username.
     */
    private String user_name;

    /**
     * gender.
     */
    private String gender;

    /**
     * gender.
     */
    private String student_number;

    /**
     * age.
     */
    private int age;


}