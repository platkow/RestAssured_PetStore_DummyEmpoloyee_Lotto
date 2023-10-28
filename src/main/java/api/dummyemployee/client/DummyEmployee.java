package api.dummyemployee.client;

import api.BaseRequests;
import api.dummyemployee.models.Employee;
import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DummyEmployee extends BaseRequests {
    private final String URL = "https://dummy.restapiexample.com/api/v1/";
    private final String ENDPOINT_EMPLOYEES = "employees";
    private final String ENDPOINT_EMPLOYEE = "employee/";
    private final String ENDPOINT_CREATE = "create";
    private final String ENDPOINT_UPDATE = "update";
    private final String ENDPOINT_DELETE = "delete";
    private final String PARAMETER_ID = "{id}";

    private final String GET_ALL_EMPLOYEES_URL = URL + ENDPOINT_EMPLOYEES;
    private final String GET_SINGLE_EMPLOYEE_URL = URL + ENDPOINT_EMPLOYEE + PARAMETER_ID;
    private final String CREATE_NEW_EMPLOYEE_URL = URL + ENDPOINT_CREATE;
    private final String UPDATE_EMPLOYEE = URL + ENDPOINT_UPDATE + PARAMETER_ID;
    private final String DELETE_EMPLOYEE = URL + ENDPOINT_DELETE + PARAMETER_ID;

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
