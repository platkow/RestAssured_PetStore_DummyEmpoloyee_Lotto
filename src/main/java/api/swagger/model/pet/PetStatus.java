package api.swagger.model.pet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PetStatus {
    AVAILABLE("available"), PENDING("pending"), SOLD("sold");
    private final String status;
}
