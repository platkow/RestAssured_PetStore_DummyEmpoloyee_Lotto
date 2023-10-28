package api.swagger.client;

import api.BaseRequests;
import api.swagger.model.store.Order;
import io.restassured.response.ValidatableResponse;

public class StoreClient extends BaseRequests {
    private final String URL = "https://petstore.swagger.io/v2/";
    private final String ENDPOINT_STORE = "store/";
    private final String ENDPOINT_ORDER = "order/";
    private final String ENDPOINT_INVENTORY = "inventory";

    private String SIMPLE_ORDER_URL = URL + ENDPOINT_STORE + ENDPOINT_ORDER;
    private String SIMPLE_INVENTORY_URL = URL + ENDPOINT_STORE + ENDPOINT_INVENTORY;

    public ValidatableResponse orderPet(Order order) {
        return create(SIMPLE_ORDER_URL, order);
    }

    public ValidatableResponse getOrderById(int id) {
        return get(SIMPLE_ORDER_URL + id);
    }

    public ValidatableResponse deleteOrderById(int orderId) {
        return delete(SIMPLE_ORDER_URL + orderId);
    }

    public ValidatableResponse getPetInventories() {
        return get(SIMPLE_INVENTORY_URL);
    }
}
