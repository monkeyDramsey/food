package com.food.guide.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Entry /*implements Serializable*/ {
    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String location;
    private String house;
    private String dish;
    private String drink;

//    @CreationTimestamp
//    private Date createdAt;
//    @CreationTimestamp
//    private Date updatedAt;

    @JsonIgnore
    @Fetch(FetchMode.JOIN)
    @ManyToOne(cascade = { CascadeType.PERSIST,
            CascadeType.MERGE }, fetch = FetchType.EAGER, optional = false)
    private Blogger blogger;

    public Entry() {
    }

    public Entry(String location, String house, String dish, String drink){
        this.location = location;
        this.house = house;
        this.dish = dish;
        this.drink = drink;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Date getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(Date updatedAt) {
//        this.updatedAt = updatedAt;
//    }

    public Blogger getBlogger() {
        return blogger;
    }

    public void setBlogger(Blogger blogger) {
        this.blogger = blogger;
    }

    public void detachBlogger(){
        if(this.blogger != null)
            this.blogger.getEntries().remove(this);
        this.blogger = null;
    }
}
