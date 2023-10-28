package swagger;

import api.swagger.client.StoreClient;
import api.swagger.model.APIResponse;
import api.swagger.model.store.Inventory;
import api.swagger.model.store.Order;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StoreTest {
    private StoreClient storeClient;

    @BeforeEach
    public void setup() {
        storeClient = new StoreClient();
    }

    @Test
    public void shouldOrderPet() {
        Order order = new Order.Builder()
                .id(0)
                .petId(0)
                .quantity(0)
                .shipDate("2023-06-26T12:14:19.504Z")
                .status("placed")
                .complete(true)
                .build();

        ValidatableResponse response = storeClient.orderPet(order);
        Order orderResponse = response.extract().body().as(Order.class);
        Assertions.assertFalse(orderResponse.getId() == order.getId());
    }

    @Test
    public void shouldFindOrderById() {
        int orderId = 8;

        ValidatableResponse response = storeClient.getOrderById(orderId);
        Order apiResponse = response.extract().body().as(Order.class);
        Assertions.assertTrue(apiResponse.isComplete());
    }

    @Test
    public void shouldDeleteOrderById() {
        int orderId = 11;

        ValidatableResponse response = storeClient.deleteOrderById(orderId);
        APIResponse apiResponse = response.extract().body().as(APIResponse.class);
        Assertions.assertEquals(apiResponse.getMessage(), String.valueOf(orderId));
    }

    @Test
    public void shouldGetPetInventories() {
        int sold = 12;
        int pending = 2;

        ValidatableResponse response = storeClient.getPetInventories();
        Inventory inventoryResponse = response.extract().body().as(Inventory.class);
        Assertions.assertEquals(inventoryResponse.getSold(), sold);
        Assertions.assertEquals(inventoryResponse.getPending(), pending);
    }
}
