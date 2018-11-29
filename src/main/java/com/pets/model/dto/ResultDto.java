package com.pets.model.dto;

import com.pets.model.dao.Food;

public class ResultDto {
    private ResultPet resultPet;
    private Food food;

    public ResultDto(){}

    public ResultDto(ResultPet resultPet, Food food) {
        this.resultPet = resultPet;
        this.food = food;
    }

    public ResultPet getResultPet() {
        return resultPet;
    }

    public void setResultPet(ResultPet resultPet) {
        this.resultPet = resultPet;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
