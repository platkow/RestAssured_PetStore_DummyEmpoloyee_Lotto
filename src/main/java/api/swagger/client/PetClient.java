package api.swagger.client;

import api.BaseRequests;
import api.swagger.model.pet.Pet;
import api.swagger.model.pet.PetStatus;
import io.restassured.response.ValidatableResponse;

public class PetClient extends BaseRequests {
    private final String URL = "https://petstore.swagger.io/v2/";
    private final String ENDPOINT_PET = "pet/";
    private final String ENDPOINT_UPLOAD_IMG = "uploadImage";
    private final String PARAM_PET_ID = "{petId}/";
    private final String PARAM_STATUS = "findByStatus?status=";

    private String SIMPLE_URL = URL + ENDPOINT_PET;
    private String UPLOAD_PET_IMG_URL = URL + ENDPOINT_PET + PARAM_PET_ID + ENDPOINT_UPLOAD_IMG;
    private String GET_PET_BY_STATUS_URL = URL + ENDPOINT_PET + PARAM_STATUS;


    public ValidatableResponse uploadPetImg(int petId, Object body) {
        return updateWithParamsPost("petId", petId, UPLOAD_PET_IMG_URL, body);
    }

    public ValidatableResponse addNewPet(Pet pet) {
        return create(SIMPLE_URL, pet.toString());
    }

    public ValidatableResponse updatePet(Pet pet) {
        return updateWithParamsPost(SIMPLE_URL, pet);
    }

    public ValidatableResponse findPetByStatus(PetStatus petStatus) {
        return get(GET_PET_BY_STATUS_URL + petStatus.getStatus());
    }

    public ValidatableResponse getPetById(int petId) {
        return get(SIMPLE_URL + petId);
    }

    public ValidatableResponse updatePetById(int petId, Object body) {
        return create(SIMPLE_URL + petId, body);
    }

    public ValidatableResponse deletePetById(int petId) {
        return delete(SIMPLE_URL + petId);
    }
}
