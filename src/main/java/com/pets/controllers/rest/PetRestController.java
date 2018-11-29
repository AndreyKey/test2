package com.pets.controllers.rest;

import com.pets.model.dto.PetsArray;
import com.pets.model.dto.ResultDto;
import com.pets.service.impl.PetsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest")
public class PetRestController {
    private final PetsService petsService;

    public PetRestController(PetsService petsService) {
        this.petsService = petsService;
    }

    @PostMapping(path = "/add-pets")
    public ResponseEntity<String> addPets(@RequestBody List<PetsArray> body) {
        boolean res = petsService.addPets(body);
        if (res) {
            return ResponseEntity.ok("");
        }
        return ResponseEntity.badRequest().body("Errors occurred while adding to database");
    }

    @GetMapping(path = "/get-pet/{GUID}")
    public ResponseEntity<ResultDto> getOnePet(@PathVariable("GUID") String guid) {
        ResultDto resultDto = petsService.getResultDto(guid);
        return ResponseEntity.status(200).body(resultDto);
    }
}
