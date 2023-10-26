package api.swagger.model.store;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    PLACED("placed"), APPROVED("approved"), DELIVERED("delivered");
    private final String status;
}
