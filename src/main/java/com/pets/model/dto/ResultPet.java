package com.pets.model.dto;

import com.pets.model.dao.Breed;

public class ResultPet {
    private String id;
    private String name;
    private Breed breed;

    public ResultPet(){}

    public ResultPet(String id, String name, Breed breed) {
        this.id = id;
        this.name = name;
        this.breed = breed;
    }

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

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }
}
