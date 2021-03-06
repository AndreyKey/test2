package com.pets.repository;


import com.pets.model.dao.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, String> {
    Food getOneByPetsId(String petsId);
}