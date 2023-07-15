package com.alibou.security.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "detail")
    private String detail;

    @Column(name = "price")
    private Float price;

    @Column(name = "images", columnDefinition = "TEXT")
    private  String images;
    @Column(name = "status")
    private  boolean status;

    @Column(name = "create_at")
    private  Timestamp create_at;

    @Column(name = "update_at")
    private Timestamp update_at;

    public  Product(){

    }
    public Product(String name, String detail, Float price, boolean status, String images) {
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.status = status;
        this.images = images;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.create_at = timestamp;
        this.update_at = timestamp;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }
}
