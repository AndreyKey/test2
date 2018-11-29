package com.pets.service.abstracts;

import com.pets.model.dao.Breed;
import com.pets.model.dao.Food;
import com.pets.model.dao.Pets;
import com.pets.model.dto.PetsArray;
import com.pets.model.dto.ResultDto;
import com.pets.model.dto.ResultPet;
import com.pets.repository.BreedRepository;
import com.pets.repository.FoodRepository;
import com.pets.repository.PetRepository;
import com.pets.service.impl.PetsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetsService {
    private final PetRepository petRepository;
    private final FoodRepository foodRepository;
    private final BreedRepository breedRepository;

    public PetServiceImpl(PetRepository petRepository, FoodRepository foodRepository, BreedRepository breedRepository) {
        this.petRepository = petRepository;
        this.foodRepository = foodRepository;
        this.breedRepository = breedRepository;
    }

    @Override
    public boolean addPets(List<PetsArray> body) {
        try {
            for (int i = 0; i < body.size(); i++) {
                Pets pet = new Pets(body.get(i).getId(), body.get(i).getName());
                Food food = new Food(body.get(i).getFood(), pet);
                Breed breed = new Breed(body.get(i).getBreed(), pet);
                petRepository.save(pet);
                foodRepository.save(food);
                breedRepository.save(breed);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Pets getById(String id) {
        return petRepository.findById(id).get();
    }

    @Override
    public ResultDto getResultDto(String guid) {
        Pets pet = petRepository.findById(guid).get();
        Breed breed = breedRepository.getOneByPetsId(guid);
        Food food = foodRepository.getOneByPetsId(guid);
        ResultPet resultPet = new ResultPet(pet.getId(), pet.getName(), breed);
        ResultDto resultDto = new ResultDto(resultPet, food);
        return resultDto;
    }
}
