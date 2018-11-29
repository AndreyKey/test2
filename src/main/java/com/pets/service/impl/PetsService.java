package com.pets.service.impl;

import com.pets.model.dao.Pets;
import com.pets.model.dto.PetsArray;
import com.pets.model.dto.ResultDto;

import java.util.List;

public interface PetsService {
    boolean addPets(List<PetsArray> body);

    Pets getById(String id);

    ResultDto getResultDto(String guid);
}
