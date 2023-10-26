package api.swagger.client;

import api.BaseRequests;
import api.swagger.model.store.Order;
import io.restassured.response.ValidatableResponse;

public class StoreClient extends BaseRequests {
    private final String url = "https://petstore.swagger.io/v2/";
    private final String endpointStore = "store/";
    private final String endpointOrder = "order/";
    private final String endpointInventory = "inventory";
    private final String paramOrderId = "/{orderId}";

    private String simpleOrderUrl = url + endpointStore + endpointOrder;
    private String simpleInventoryUrl = url + endpointStore + endpointInventory;
    private String orderIdParamUrl = url + endpointStore + paramOrderId;

    public ValidatableResponse orderPet(Order order) {
        return create(simpleOrderUrl, order);
    }

    public ValidatableResponse getOrderById(int id) {
        return get(simpleOrderUrl + id);
    }

    public ValidatableResponse deleteOrderById(int orderId) {
        return delete(simpleOrderUrl + orderId);
    }

    public ValidatableResponse getPetInventories() {
        return get(simpleInventoryUrl);
    }
}
