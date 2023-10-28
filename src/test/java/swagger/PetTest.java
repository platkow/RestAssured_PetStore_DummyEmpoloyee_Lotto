package swagger;

import api.swagger.client.PetClient;
import api.swagger.model.APIResponse;
import api.swagger.model.pet.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PetTest {
    private String status = "available";
    private PetClient petClient;
    Category category = new Category(1, "small");
    Tag firstTag = new Tag(1, "Small dog");
    Tag secondTag = new Tag(2, "Medium dog");

    @BeforeEach
    public void cratePetClient() {
        petClient = new PetClient();
    }

    //POST upload image -> error to resolve com.google.gson.JsonIOException: Failed making field 'java.io.File#path' accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.
    @Test
    public void shouldUploadPetImage() {
        int code = 200;
        int petId = 1;
        File file = new File("pet.jpg");
        UploadImage uploadImage = new UploadImage(
                "test", file);

        ValidatableResponse response = petClient.uploadPetImg(petId, uploadImage);
        APIResponse apiResponse = response.extract().response().body().as(APIResponse.class);
        Assertions.assertEquals(code, apiResponse.getCode());
    }

    @Test
    public void shouldAddNewPetToTheStore() {
        Pet pet = new Pet.Builder()
                .id(1)
                .category(category)
                .name("rex")
                .photoUrls(Arrays.asList("firstURL", "secondURL"))
                .tags(Arrays.asList(firstTag, secondTag))
                .status(PetStatus.AVAILABLE.getStatus())
                .build();

        ValidatableResponse response = petClient.addNewPet(pet);
        Pet petStatus = response.extract().response().body().as(Pet.class);
        Assertions.assertEquals(status, petStatus.getStatus());
    }

    @Test
    public void shouldUpdateExistingPet() {
        Pet pet = new Pet.Builder()
                .id(1)
                .category(category)
                .name("snoopy")
                .photoUrls(Arrays.asList("firstURL", "secondURL"))
                .tags(Arrays.asList(firstTag, secondTag))
                .status(PetStatus.AVAILABLE.getStatus())
                .build();

        ValidatableResponse response = petClient.updatePet(pet);
        Pet petResponse = response.extract().body().as(Pet.class);
        Assertions.assertEquals(status, petResponse.getStatus());
    }

    @Test
    public void shouldFindPetByStatus() {
        PetStatus status = PetStatus.AVAILABLE;

        PetClient petClient = new PetClient();
        ValidatableResponse response = petClient.findPetByStatus(status);
        Pet[] petResponse = response.extract().body().as(Pet[].class);
        Assertions.assertTrue(petResponse.length > 0);
        List<Pet> petReposnseAsList = Arrays.stream(petResponse).toList();
        Assertions.assertEquals(petReposnseAsList.get(0).getStatus(),
                status.getStatus());
    }

    @Test
    public void shouldFindPetById() {
        int petId = 1;
        String petName = "doggie";

        ValidatableResponse response = petClient.getPetById(petId);
        Pet petResponse = response.extract().body().as(Pet.class);
        Assertions.assertEquals(petName, petResponse.getName());
    }

    //6 - error in request body, despite sending empty body in body logs id is set to 0
    @Test
    public void shouldUpdatePetById() {
        int id = 1;
        Pet pet = new Pet();

        ValidatableResponse response = petClient.updatePetById(id, pet);
        APIResponse petResponse = response.extract().body().as(APIResponse.class);
        Assertions.assertEquals(petResponse.getMessage(), String.valueOf(id));
    }

    @Test
    public void shouldDeletePetById() {
        int id = 123;

        ValidatableResponse response = petClient.deletePetById(id);
        APIResponse apiResponse = response.extract().body().as(APIResponse.class);
        Assertions.assertEquals(apiResponse.getMessage(), String.valueOf(id));
    }
}
