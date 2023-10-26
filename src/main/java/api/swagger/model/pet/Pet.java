package api.swagger.model.pet;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    public Pet(long id, String name, String status){
        this.id = id;
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
