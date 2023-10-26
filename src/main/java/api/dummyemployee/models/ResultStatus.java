package api.dummyemployee.models;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultStatus {
    private String status;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
