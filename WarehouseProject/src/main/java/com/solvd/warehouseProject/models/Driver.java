package com.solvd.warehouseProject.models;

import java.util.Date;
import java.util.List;

public class Driver {
    private Long id;
    private String name;
    private Integer age;
    private Date birthday;
    private List<Phone> phones;

    public Driver() {
    }

    public Driver(String name, Integer age, Date birthday, List<Phone> phones) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.phones = phones;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
