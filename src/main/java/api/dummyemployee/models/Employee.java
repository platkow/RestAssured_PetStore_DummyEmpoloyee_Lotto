package api.dummyemployee.models;

import com.google.gson.Gson;
import lombok.Data;

@Data

public class Employee {

    private int id;
    private String employee_name;
    private int employee_salary;
    private int employee_age;

    public Employee(int id, String employee_name, int employee_salary, int employee_age) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
