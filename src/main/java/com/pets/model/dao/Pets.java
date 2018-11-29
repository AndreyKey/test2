package com.pets.model.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pets {
    @Id
    private String id;
    private String name;

    public Pets(){}

    public Pets(String name) {
        this.name = name;
    }

    public Pets(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
