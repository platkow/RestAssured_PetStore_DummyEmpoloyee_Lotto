package swagger;

import api.swagger.client.UserClient;
import api.swagger.model.APIResponse;
import api.swagger.model.user.User;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class UserTest {
    private UserClient storeClient;
    private User user1;
    private User user2;
    private String messageOne = "ok";
    private String messageTwo = "logged in user session";
    private String messageThree = "9223372036854754965";
    private String username = "strings";
    private String password = "strings";
    private int userStatus = 0;
    private int code = 200;

    @BeforeEach
    public void setup() {
        storeClient = new UserClient();
        user1 = new User.Builder().id(1)
                .username("tford")
                .firstName("Tom")
                .lastName("Ford")
                .email("tf@gmail.com")
                .password("pass")
                .phone("675467365")
                .userStatus(5)
                .build();
        user2 = new User.Builder().id(2)
                .username("mjackobs")
                .firstName("Mark")
                .lastName("Jackobs")
                .email("mjackobs@gmail.com")
                .password("pass123")
                .phone("890784567")
                .userStatus(3)
                .build();
    }

    @Test
    public void shouldCreateArrayOfUsers() {
        User[] users = {user1, user2};

        ValidatableResponse response = storeClient.createArrayOfUsers(users);
        APIResponse apiResponse = response.extract().body().as(APIResponse.class);
        Assertions.assertEquals(apiResponse.getMessage(), messageOne);
    }

    @Test
    public void shouldCreateListOfUsers() {
        List<User> users = Arrays.asList(user1, user2);

        ValidatableResponse response = storeClient.createListOfUsers(users);
        APIResponse apiResponse = response.extract().body().as(APIResponse.class);
        Assertions.assertEquals(apiResponse.getMessage(), messageOne);
    }

    @Test
    public void shouldGetUserByName() {
        ValidatableResponse response = storeClient.getUserByName(username);
        User userResponse = response.extract().body().as(User.class);
        Assertions.assertEquals(userResponse.getUserStatus(), userStatus);
    }

    @Test
    public void shouldUpdateUserByName() {
        ValidatableResponse response = storeClient.updateUserByName(username, user1);
        APIResponse apiResponse = response.extract().body().as(APIResponse.class);
        Assertions.assertEquals(apiResponse.getMessage(), String.valueOf(user1.getId()));
    }

    @Test
    public void shouldDeleteUserByName() {
        ValidatableResponse response = storeClient.deleteUserByName(username);
        APIResponse apiResponse = response.extract().body().as(APIResponse.class);
        Assertions.assertEquals(apiResponse.getMessage(), username);
    }

    @Test
    public void shouldLoginUser() {
        ValidatableResponse response = storeClient.loginUser(username, password);
        APIResponse apiResponse = response.extract().body().as(APIResponse.class);
        Assertions.assertTrue(apiResponse.getMessage().contains(messageTwo));
    }

    @Test
    public void shouldLogoutUser() {
        ValidatableResponse response = storeClient.logoutUser();
        APIResponse apiResponse = response.extract().body().as(APIResponse.class);
        Assertions.assertEquals(apiResponse.getMessage(), messageOne);
    }

    @Test
    public void shouldCreateUser() {
        ValidatableResponse response1 = storeClient.createUser(user1);
        APIResponse apiResponse = response1.extract().body().as(APIResponse.class);
        Assertions.assertEquals(apiResponse.getMessage(), String.valueOf(user1.getId()));
    }
}
