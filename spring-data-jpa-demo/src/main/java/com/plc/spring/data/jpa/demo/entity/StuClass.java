package com.plc.spring.data.jpa.demo.entity;

import org.hibernate.validator.constraints.Email;
import org.junit.validator.ValidateWith;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class StuClass implements Serializable {
    private static final long serialVersionUID = 7974918093651297180L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 500)
    @Max(value = 1)
    private String name;
    private String code;
    private String memo;
    @Email
    private String address;
    @Column(length = 500)
    private String test;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<StuStudent> stuStudentList;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<StuStudent> getStuStudentList() {
        return stuStudentList;
    }

    public void setStuStudentList(List<StuStudent> stuStudentList) {
        this.stuStudentList = stuStudentList;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "StuClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", memo='" + memo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
