package com.plc.springjpa.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by 003914[panlc] on 2017-08-04.
 */
@Entity
public class AuthUser {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String userFirstName;

    @Column(nullable = false)
    private Integer age;

    private Date createdDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "id=" + id +
                ", userFirstName='" + userFirstName + '\'' +
                ", age=" + age +
                ", createdDt=" + createdDt +
                '}';
    }
}
