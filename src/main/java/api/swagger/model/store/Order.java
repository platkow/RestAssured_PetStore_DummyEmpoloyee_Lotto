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

    public static final class Builder {
        private long id;
        private int petId;
        private int quantity;
        private String shipDate;
        private String status;
        private boolean complete;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder petId(int petId){
            this.petId = petId;
            return this;
        }

        public Builder quantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public Builder shipDate(String shipDate){
            this.shipDate = shipDate;
            return this;
        }

        public Builder status(String status){
            this.status = status;
            return this;
        }

        public Builder complete(boolean complete){
            this.complete = complete;
            return this;
        }

        public Order build(){
            return new Order(id,petId, quantity, shipDate, status, complete);
        }
    }
}
