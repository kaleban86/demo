package com.example.demo.models;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class OrderId {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;


    private String name;

    @CreationTimestamp
    @CreatedDate
    private Date date;
    private String address;
    private String client;

    public OrderId() {
    }



    public OrderId(String client, String address, String name) {


        this.id=id;
        this.client = client;
        this.address= address;
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
