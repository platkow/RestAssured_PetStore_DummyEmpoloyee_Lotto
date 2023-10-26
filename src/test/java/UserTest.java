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
    private String msg = "ok";
    private String message = "logged in user session";
    private String username = "string";
    private String usernameName = "username";
    private String password = "string";
    private String passwordName = "password";
    private int userStatus = 0;
    private int code = 200;

    @BeforeEach
    public void setup() {
        storeClient = new UserClient();
        user1 = new User(1, "tford", "Tom", "Ford", "tf@gmail.com", "pass", "675467365", 5);
        user2 = new User(2, "mjackobs", "Mark", "Jackobs", "mjackobs", "pass", "890784567", 3);
    }

    @Test
    public void shouldCreateArrayOfUsers() {
        User[] users = {user1, user2};

        ValidatableResponse response = storeClient.createArrayOfUsers(users);
        APIResponse apiResponse = response.extract().body().as(APIResponse.class);
        Assertions.assertEquals(apiResponse.getMessage(), msg);
    }

    @Test
    public void shouldCreateListOfUsers() {
        List<User> users = Arrays.asList(user1, user2);

        ValidatableResponse response = storeClient.createListOfUsers(users);
        APIResponse apiResponse = response.extract().body().as(APIResponse.class);
        Assertions.assertEquals(apiResponse.getMessage(), msg);
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
        Assertions.assertEquals(apiResponse.getCode(), code);
        Assertions.assertEquals(apiResponse.getMessage(), String.valueOf(user1.getId()));
    }

    @Test
    public void shouldDeleteUserByName() {
        ValidatableResponse response = storeClient.deleteUserByName(username);
        APIResponse apiResponse = response.extract().body().as(APIResponse.class);
        Assertions.assertEquals(apiResponse.getCode(), code);
        Assertions.assertEquals(apiResponse.getMessage(), username);
    }

    @Test
    public void shouldLoginUser() {//fix
        ValidatableResponse response = storeClient.loginUser(usernameName, username, passwordName, password);
        APIResponse apiResponse = response.extract().body().as(APIResponse.class);
        System.out.println(apiResponse.getMessage());
        Assertions.assertTrue(apiResponse.getMessage().contains(message));
    }

    @Test
    public void shouldLogoutUser() {//fix
//        String username = "string";
//        String password = "string";
//        int code = 200;
//
//        UserClient storeClient = new UserClient();
//        ValidatableResponse response = storeClient.logoutUser(username, password);
//        APIResponse apiResponse = response.extract().body().as(APIResponse.class);
//        Assertions.assertEquals(apiResponse.getCode(), code);
    }

    @Test
    public void shouldCreateUser() {//fix
        //Only for logged user
//        String username = "string";
//        String password = "string";
//        int code = 200;
//
//        User user = new User(0, "string", "string", "string", "string", "string", "string", 0);
//
//        UserClient storeClient = new UserClient();
//        ValidatableResponse response1 = storeClient.loginUser(username, password);
//        APIResponse apiResponse1 = response1.extract().body().as(APIResponse.class);
//        //log.info(String.valueOf(apiResponse1.getCode()));
//
//        //System.out.println(apiResponse1.getCode());
//        int apiResponseCode = apiResponse1.getCode();
//        if (apiResponseCode == code) {
//            ValidatableResponse response2 = storeClient.createUser(user);
//            APIResponse apiResponse2 = response2.extract().body().as(APIResponse.class);
//            Assertions.assertEquals(apiResponse2.getCode(), code);
//        } else {
//            Assertions.assertFalse(false);
//        }
    }
}
