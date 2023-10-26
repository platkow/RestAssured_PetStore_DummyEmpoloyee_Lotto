package api.swagger.client;

import api.BaseRequests;
import api.swagger.model.pet.Pet;
import api.swagger.model.pet.PetStatus;
import io.restassured.response.ValidatableResponse;

public class PetClient extends BaseRequests {
    private final String url = "https://petstore.swagger.io/v2/";
    private final String endpointPet = "pet/";
    private final String endpointUpladImg = "uploadImage";
    private final String paramPetId = "{petId}/";
    private final String paramStatus = "findByStatus?status=";

    private String simpleUrl = url + endpointPet;
    private String uploadPetImageUrl = url + endpointPet + paramPetId + endpointUpladImg;
    private String getPetByStatusUrl = url + endpointPet + paramStatus;


    public ValidatableResponse uploadPetImg(int petId, Object body) {
        return updateWithParamsPost("petId", petId, uploadPetImageUrl, body);
    }

    public ValidatableResponse addNewPet(Pet pet) {
        return create(simpleUrl, pet.toString());
    }

    public ValidatableResponse updatePet(Pet pet) {
        return updateWithParamsPost(simpleUrl, pet);
    }

    public ValidatableResponse findPetByStatus(PetStatus petStatus) {
        return get(getPetByStatusUrl + petStatus.getStatus());
    }

    public ValidatableResponse getPetById(int petId) {
        return get(simpleUrl + petId);
    }

    public ValidatableResponse updatePetById(int petId, Object body) {
        return create(simpleUrl + petId, body);
    }

    public ValidatableResponse deletePetById(int petId) {
        return delete(simpleUrl + petId);
    }
}
