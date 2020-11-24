package com.njesoft.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;


@Entity
public class Address extends AbstractPersistable<Integer> {

    private String city;
    private String state;
    private String country;
    private transient Integer userId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
