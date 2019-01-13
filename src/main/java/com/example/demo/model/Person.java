package com.example.demo.model;

import com.google.common.base.MoreObjects;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.Objects;

import javax.persistence.Column;

public class Person {
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private int sex;
    @Column(name = "birth_day")
    private Date birthDay;
    @Column(name = "created_at")
    private ZonedDateTime createdAt;
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("sex", sex)
                .add("birthDay", birthDay)
                .add("createdAt", createdAt)
                .add("updatedAt", updatedAt)
                .toString();
    }
}
