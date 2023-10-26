package api;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class BaseRequests {
    //GET - READ
    protected ValidatableResponse get(String path) {
        return RestAssured
                .when().get(path)
                .then().statusCode(200).extract().response()
                .then();
    }

    protected ValidatableResponse getWithParam(String paramName, int paramValue, String path) {
        return RestAssured
                .given().pathParam(paramName, paramValue).log().all()
                .when().get(path)
                .then().statusCode(200).extract().response()
                .then();
    }

    protected ValidatableResponse getWithParam(String paramName, String paramValue, String path) {
        return RestAssured
                .given().pathParam(paramName, paramValue).log().all()
                .when().get(path)
                .then().statusCode(200).extract().response()
                .then();
    }

    protected ValidatableResponse getAuth(String paramOneName, String paramOneValue, String paramTwoName, String paramTwoValue,String path) {
        return RestAssured
                .given().auth().preemptive().basic(paramOneName, paramTwoName)
                .given().pathParam(paramOneName, paramOneValue)
                .given().pathParam(paramTwoName, paramTwoValue)
                .when().get(path)
                .then().statusCode(200).extract().response()
                .then();
    }

    protected ValidatableResponse getAuthentication(String paramOneName, String paramOneValue, String paramTwoName, String paramTwoValue,String path) {
        return RestAssured
                .given().auth().preemptive().basic(paramOneName, paramTwoName)
                .given().pathParam(paramOneName, paramOneValue)
                .given().pathParam(paramTwoName, paramTwoValue)
                .when().get(path)
                .then().extract().response()
                .then();
    }

    //POST - CREATE
    protected ValidatableResponse create(String path, Object body) {
        return RestAssured
                .given().body(body).log().all().contentType("application/json").accept("application/json")
                .when().post(path)
                .then().statusCode(200).extract().response()
                .then();
    }

    //PUT - UPDATE
    protected ValidatableResponse update(String path, Object body) {
        return RestAssured
                .given().body(body).log().all().contentType("application/json").accept("application/json")
                .when().put(path)
                .then().statusCode(200).extract().response()
                .then();
    }

    protected ValidatableResponse updateWithParams(String paramName, int paramValue, String path) {
        return RestAssured
                .given().pathParam(paramName, paramValue)
                .when().put(path)
                .then().statusCode(200).extract().response()
                .then();
    }

    protected ValidatableResponse updateWithParams(String paramName, String paramValue, String path) {
        return RestAssured
                .given().pathParam(paramName, paramValue)
                .when().put(path)
                .then().statusCode(200).extract().response()
                .then();
    }

    //UPDATE with POST not correct but possible
    protected ValidatableResponse updateWithParamsPost(String paramName, int paramValue, String path, Object body) {
        return RestAssured
                .given().contentType("application/json")
                .body(body).log().all().contentType("application/json").accept("application/json").pathParam(paramName, paramValue)
                .when().post(path)
                .then().statusCode(200).extract().response()
                .then();
    }

    protected ValidatableResponse updateWithParamsPost(String path, Object body) {
        return RestAssured
                .given().contentType("application/json")
                .body(body).log().all().contentType("application/json").accept("application/json")
                .when().post(path)
                .then().statusCode(200).extract().response()
                .then();
    }

    //DELETE
    protected ValidatableResponse delete(String path) {
        return RestAssured
                .when().delete(path)
                .then().statusCode(200).extract().response()
                .then();
    }

    protected ValidatableResponse deleteWithParams(String paramName, int paramValue, String path) {
        return RestAssured
                .given().pathParam(paramName, paramValue)
                .when().delete(path)
                .then().statusCode(200).extract().response()
                .then();
    }

    protected ValidatableResponse deleteWithParams(String paramName, String paramValue, String path) {
        return RestAssured
                .given().pathParam(paramName, paramValue)
                .when().delete(path)
                .then().statusCode(200).extract().response()
                .then();
    }
}
