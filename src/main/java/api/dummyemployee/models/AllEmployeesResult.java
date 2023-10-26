package api.dummyemployee.models;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AllEmployeesResult {
    private final List<Employee> data;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
