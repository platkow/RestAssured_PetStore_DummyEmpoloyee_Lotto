package api.swagger.model.store;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private long id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
