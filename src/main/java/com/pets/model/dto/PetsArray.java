package com.pets.model.dto;

public class PetsArray {
    private String id;
    private String name;
    private String breed;
    private String food;

    public PetsArray(){}

    public PetsArray(String id, String name, String breed, String food) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.food = food;
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
