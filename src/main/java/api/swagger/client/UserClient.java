package api.swagger.client;

import api.BaseRequests;
import api.swagger.model.user.User;
import io.restassured.response.ValidatableResponse;

import java.util.List;

public class UserClient extends BaseRequests {
    private final String URL = "https://petstore.swagger.io/v2/";
    private final String ENDPOINT_USER = "user/";
    private final String ENDPOINT_CREATE_WITH_ARRAY = "createWithArray";
    private final String ENDPOINT_CREATE_WITH_LIST = "createWithList";
    private final String ENDPOINT_LOGIN = "login";
    private final String ENDPOINT_LOGOUT = "logout";
    private final String PARAMETER_NAME = "{username}";
    private final String PARAMETER_PASSWORD = "{password}";
    
    private final String CREATE_ARRAY_OF_USERS_URL = URL + ENDPOINT_USER + ENDPOINT_CREATE_WITH_ARRAY;
    private final String CREATE_LIST_OF_USERS_URL = URL + ENDPOINT_USER + ENDPOINT_CREATE_WITH_LIST;
    private final String SIMPLE_USER_NAME_URL= URL + ENDPOINT_USER;
    private final String LOGIN_USER_URL = URL + ENDPOINT_USER + ENDPOINT_LOGIN + PARAMETER_NAME + PARAMETER_PASSWORD;
    private final String LOGOUT_USER_URL = URL + ENDPOINT_USER + ENDPOINT_LOGOUT;
    private final String CREATE_USER_URL = URL + ENDPOINT_USER;

    public ValidatableResponse createArrayOfUsers(User[] users) {
        return create(CREATE_ARRAY_OF_USERS_URL, users);
    }

    public ValidatableResponse createListOfUsers(List<User> users) {
        return create(CREATE_LIST_OF_USERS_URL, users);
    }

    public ValidatableResponse getUserByName(String username) {
        return get(SIMPLE_USER_NAME_URL+ username);
    }

    public ValidatableResponse updateUserByName(String username, User user) {
        return update(SIMPLE_USER_NAME_URL+ username, user);
    }

    public ValidatableResponse deleteUserByName(String username) {
        return delete(SIMPLE_USER_NAME_URL+ username);
    }

    public ValidatableResponse loginUser(String userNameValue, String passwordValue) {
        return getAuthentication("username", userNameValue, "password", passwordValue, LOGIN_USER_URL);
    }

    public ValidatableResponse logoutUser() {
        return get(LOGOUT_USER_URL);
    }

    public ValidatableResponse createUser(User user) {
        return create(CREATE_USER_URL, user);
    }
}
