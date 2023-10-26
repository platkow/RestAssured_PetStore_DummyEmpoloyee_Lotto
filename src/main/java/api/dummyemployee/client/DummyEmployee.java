package api.dummyemployee.client;

import api.BaseRequests;
import api.dummyemployee.models.Employee;
import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DummyEmployee extends BaseRequests {

    private final String GET_ALL_EMPLOYEES_URL = "https://dummy.restapiexample.com/api/v1/employees";
    private final String GET_SINGLE_EMPLOYEE_URL = "https://dummy.restapiexample.com/api/v1/employee/{id}";
    private final String CREATE_NEW_EMPLOYEE_URL = "https://dummy.restapiexample.com/api/v1/create";
    private final String UPDATE_EMPLOYEE = "https://dummy.restapiexample.com/api/v1/update/{id}";
    private final String DELETE_EMPLOYEE = "https://dummy.restapiexample.com/api/v1/delete/{id}";

    public ValidatableResponse getAllEmployees() {
        return get(GET_ALL_EMPLOYEES_URL);
    }

    public ValidatableResponse getSingleEmployee(int id) {
        return getWithParam("id", id, GET_SINGLE_EMPLOYEE_URL);
    }

    public ValidatableResponse createNewEmployee(Employee employee) {
        return create(CREATE_NEW_EMPLOYEE_URL, employee.toString());
    }

    public ValidatableResponse updateEmployee(int id) {
        return updateWithParams("id", id, UPDATE_EMPLOYEE);
    }

    public ValidatableResponse deleteEmployee(int id) {
        return deleteWithParams("id", id, DELETE_EMPLOYEE);
    }
}
