package com.pets.repository;


import com.pets.model.dao.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pets, String> {
    //boolean saveAllPets(List<Pets> pets);
}