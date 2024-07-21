package com.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer ccNumber;
    private Date expires;

    @Enumerated(EnumType.STRING)
    private CCType ccType;

    private Integer userId;

    // Getter and Setter for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for ccNumber
    public Integer getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(Integer ccNumber) {
        this.ccNumber = ccNumber;
    }

    // Getter and Setter for expires
    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    // Getter and Setter for ccType
    public CCType getCcType() {
        return ccType;
    }

    public void setCcType(CCType ccType) {
        this.ccType = ccType;
    }

    // Getter and Setter for userId
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
