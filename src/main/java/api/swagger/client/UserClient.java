package api.swagger.client;

import api.BaseRequests;
import api.swagger.model.user.User;
import io.restassured.response.ValidatableResponse;

import java.util.List;

public class UserClient extends BaseRequests {
    private final String url = "https://petstore.swagger.io/v2/";
    private final String endpointUser = "user/";
    private final String endpointCreateWithArray = "createWithArray";
    private final String endpointCreateWithList = "createWithList";
    private final String endpointLogin = "login";
    private final String endpointLogout = "logout";
    private final String paramUserName= "{username}";
    private final String paramPassword= "{password}";
    private final String paramStatus = "findByStatus?status=";

    private String simpleUrl = url;
    private String createArrayOfUsersUrl = url + endpointUser + endpointCreateWithArray;
    private String createListOfUsersUrl = url + endpointUser + endpointCreateWithList;
    private String simpleUserNameUrl = url + endpointUser;
    private String getPetByStatus = url + paramStatus;
    private String loginUserUrl = url + endpointUser + endpointLogin + paramUserName + paramPassword;
    private String logoutUserUrl = url + endpointUser + endpointLogout;


    //3
    private String getUserByName = "https://petstore.swagger.io/v2/user/{username}"; //get
    //4
    private String updateUser = "https://petstore.swagger.io/v2/user/{username}"; //put
    //5
    private String deleteUser = "https://petstore.swagger.io/v2/user/{username}"; //del
    //6
    private String loginUser = "https://petstore.swagger.io/v2/user/login"; //get
    //7
    private String logoutUser = "https://petstore.swagger.io/v2/user/logout"; //get
    //8
    private String createUser = "https://petstore.swagger.io/v2/user"; //post

    //1
    public ValidatableResponse createArrayOfUsers(User[] users) {
        return create(createArrayOfUsersUrl, users);
    }

    //2
    public ValidatableResponse createListOfUsers(List<User> users) {
        return create(createListOfUsersUrl, users);
    }

    //3
    public ValidatableResponse getUserByName(String username) {
        return get(simpleUserNameUrl + username);
    }

    //4
    public ValidatableResponse updateUserByName(String username, User user) {
        return update(simpleUserNameUrl + username, user);
    }

    //5
    public ValidatableResponse deleteUserByName(String username) {
        return delete(simpleUserNameUrl + username);
    }

    //6
    public ValidatableResponse loginUser(String userNameValue, String passwordValue) {
        return getAuthentication("username", userNameValue, "password", passwordValue, loginUserUrl);
    }

    //7
    public ValidatableResponse logoutUser() {
        return get(logoutUserUrl);
    }

    //8
    public ValidatableResponse createUser(User user) {
        return create(createUser, user);
    }
}
