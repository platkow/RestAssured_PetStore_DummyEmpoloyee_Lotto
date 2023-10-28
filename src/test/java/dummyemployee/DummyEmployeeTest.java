package dummyemployee;

import api.dummyemployee.client.DummyEmployee;
import api.dummyemployee.models.AllEmployeesResult;
import api.dummyemployee.models.Employee;
import api.dummyemployee.models.ResultStatus;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DummyEmployeeTest {
    private DummyEmployee dummyEmployee;
    private String msg = "success";

    @BeforeEach
    public void createDummyEmployee() {
        dummyEmployee = new DummyEmployee();
    }

    @Test
    public void shouldGetAllEmployees() {
        ValidatableResponse getResponse = dummyEmployee.getAllEmployees();
        AllEmployeesResult allEmployeesResult = getResponse.extract().response().body().as(AllEmployeesResult.class);
        Assertions.assertEquals(allEmployeesResult.getData().size(), 24);
    }

    @Test
    public void shouldGetSingleEmployee() {
        ValidatableResponse response = dummyEmployee.getSingleEmployee(1); //server error when id = 0
        Employee singleEmployeeResults = response.extract().response().body().as(Employee.class);
        Assertions.assertEquals(singleEmployeeResults.getId(), 0);
    }

    @Test
    public void shouldCreateNewEmployee() {
        Employee employee = new Employee(
                30,
                "Johny Deep",
                30_000,
                52
        );

        ValidatableResponse response = dummyEmployee.createNewEmployee(employee);
        ResultStatus createEmployeeResult = response.extract().response().body().as(ResultStatus.class);
        Assertions.assertEquals(createEmployeeResult.getStatus(), msg);
    }

    @Test
    public void shouldUpdateEmployee() {
        int id = 0;

        ValidatableResponse updateResponse = dummyEmployee.updateEmployee(id);
        ResultStatus updatedEmployee = updateResponse.extract().response().body().as(ResultStatus.class);
        Assertions.assertEquals(updatedEmployee.getStatus(), msg);
    }

    @Test
    public void shouldDeleteEmployee() {
        int id = 1;

        ValidatableResponse deleteResponse = dummyEmployee.deleteEmployee(id);
        ResultStatus deletedEmployee = deleteResponse.extract().body().as(ResultStatus.class);
        Assertions.assertEquals(deletedEmployee.getStatus(), msg);
    }
}
