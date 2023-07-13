package com.robin.GoSoftChallengeProjectAPI.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "status")
    private  String status;

    @Column(name = "create_at")
    private Timestamp create_at;

    @Column(name = "update_at")
    private  Timestamp update_at;
}
