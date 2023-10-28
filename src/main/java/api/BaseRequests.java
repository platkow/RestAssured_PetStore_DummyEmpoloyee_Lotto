package api;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class BaseRequests {
    protected ValidatableResponse get(String path) {
        return RestAssured
                .given()
                    .log()
                    .all()
                .when()
                    .get(path)
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                .then();
    }

    protected ValidatableResponse getWithParam(String paramName, int paramValue, String path) {
        return RestAssured
                .given()
                    .log()
                    .all()
                    .pathParam(paramName, paramValue)
                .when()
                    .get(path)
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                .then();
    }

    protected ValidatableResponse getAuthentication(String paramOneName, String paramOneValue, String paramTwoName, String paramTwoValue, String path) {
        return RestAssured
                .given()
                    .log()
                    .all()
                    .auth()
                    .preemptive()
                    .basic(paramOneName, paramTwoName)
                    .pathParam(paramOneName, paramOneValue)
                    .pathParam(paramTwoName, paramTwoValue)
                .when()
                    .get(path)
                .then()
                    .extract()
                    .response()
                .then();
    }

    protected ValidatableResponse create(String path, Object body) {
        return RestAssured
                .given()
                    .body(body)
                    .log()
                    .all()
                    .contentType("application/json")
                    .accept("application/json")
                .when()
                    .post(path)
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                .then();
    }

    protected ValidatableResponse update(String path, Object body) {
        return RestAssured
                .given()
                    .body(body)
                    .log()
                    .all()
                    .contentType("application/json")
                    .accept("application/json")
                .when()
                    .put(path)
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                .then();
    }

    protected ValidatableResponse updateWithParams(String paramName, int paramValue, String path) {
        return RestAssured
                .given()
                    .log()
                    .all()
                    .pathParam(paramName, paramValue)
                .when()
                    .put(path)
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                .then();
    }

    protected ValidatableResponse updateWithParamsPost(String paramName, int paramValue, String path, Object body) {
        return RestAssured
                .given()
                    .body(body)
                    .log()
                    .all()
                    .contentType("application/json")
                    .accept("application/json")
                    .pathParam(paramName, paramValue)
                .when()
                    .post(path)
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                .then();
    }

    protected ValidatableResponse updateWithParamsPost(String path, Object body) {
        return RestAssured
                .given()
                    .body(body)
                    .log()
                    .all()
                    .contentType("application/json")
                    .accept("application/json")
                .when()
                    .post(path)
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                .then();
    }

    protected ValidatableResponse delete(String path) {
        return RestAssured
                .given()
                    .log()
                    .all()
                .when()
                    .delete(path)
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                .then();
    }

    protected ValidatableResponse deleteWithParams(String paramName, int paramValue, String path) {
        return RestAssured
                .given()
                    .log()
                    .all()
                    .pathParam(paramName, paramValue)
                .when()
                    .delete(path)
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                .then();
    }
}
