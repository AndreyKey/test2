package com.pets.repository;


import com.pets.model.dao.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedRepository extends JpaRepository<Breed, String> {
    Breed getOneByPetsId(String petsId);
}