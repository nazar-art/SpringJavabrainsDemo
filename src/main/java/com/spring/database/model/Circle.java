package com.spring.database.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Circle {

    @Id
    private int id;

    private String name;

    public Circle() {
    }

    public Circle(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
