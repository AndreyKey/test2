package com.pets.controllers.rest;

import com.pets.model.dao.Breed;
import com.pets.model.dao.Food;
import com.pets.model.dao.Pets;
import com.pets.model.dto.PetsArray;
import com.pets.repository.BreedRepository;
import com.pets.repository.FoodRepository;
import com.pets.repository.PetRepository;
import com.pets.service.impl.PetsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PetRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PetsService petsService;
    @Autowired
    private BreedRepository breedRepository;
    @Autowired
    private FoodRepository foodRepository;
    private final String petId1 = "6F9619FF-8B86-D011-B42D-00CF4FC964FC";

    @Test
    public void addPetsTest() throws Exception {
        String petId2 = "6F9619FF-8B86-D012-B42D-00CF4FC964FF";
        String petId3 = "6F9619FF-8B86-D013-B42D-00CF4FC964F4";

        String array = "[\n" +
                "\n" +
                "  {\n" +
                "\n" +
                "    \"id\": \"6F9619FF-8B86-D011-B42D-00CF4FC964FC\",\n" +
                "\n" +
                "    \"name\": \"кошка 1\",\n" +
                "\n" +
                "    \"breed\": \"порода 1\",\n" +
                "\n" +
                "    \"food\": \"корм 1\"\n" +
                "\n" +
                "  },\n" +
                "\n" +
                "  {\n" +
                "\n" +
                "    \"id\": \"6F9619FF-8B86-D012-B42D-00CF4FC964FF\",\n" +
                "\n" +
                "    \"name\": \"кошка 2\",\n" +
                "\n" +
                "    \"breed\": \"порода 2\",\n" +
                "\n" +
                "    \"food\": \"корм 2\"\n" +
                "\n" +
                "  },\n" +
                "\n" +
                "  {\n" +
                "\n" +
                "    \"id\": \"6F9619FF-8B86-D013-B42D-00CF4FC964F4\",\n" +
                "\n" +
                "    \"name\": \"кошка 3\",\n" +
                "\n" +
                "    \"breed\": \"порода 3\",\n" +
                "\n" +
                "    \"food\": \"корм 3\"\n" +
                "\n" +
                "  }\n" +
                "\n" +
                "]";

        mockMvc.perform(post("/rest/add-pets")
                .contentType(MediaType.APPLICATION_JSON)
                .content(array))
                .andExpect(status().isOk());


        Pets pet1 = petRepository.findById(petId1).get();
        Pets pet2 = petRepository.findById(petId2).get();
        Pets pet3 = petRepository.findById(petId3).get();

        assertThat(pet1.getId(), is(petId1));
        assertThat(pet2.getId(), is(petId2));
        assertThat(pet3.getId(), is(petId3));
    }

    @Test
    public void getPetAndFood() throws Exception {
        PetsArray pet = new PetsArray(petId1, "кошка 1", "корм 1", "порода 1");
        List<PetsArray> petList = new ArrayList<>();
        petList.add(pet);
        petsService.addPets(petList);
        Food food = foodRepository.getOneByPetsId(petId1);
        Breed breed = breedRepository.getOneByPetsId(petId1);

        String response = String.format("{\"resultPet\":{\"id\":\"6F9619FF-8B86-D011-B42D-00CF4FC964FC\",\"name\":\"кошка 1\",\"breed\":{\"id\":\"%s\",\"name\":\"корм 1\"}},\"food\":{\"id\":\"%s\",\"name\":\"порода 1\"}}", breed.getId(), food.getId());

        mockMvc.perform(get("/rest/get-pet/" + petId1))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
    }
}
