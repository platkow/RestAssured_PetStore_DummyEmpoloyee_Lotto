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

    public static final class Builder {
        private long id;
        private Category category;
        private String name;
        private List<String> photoUrls;
        private List<Tag> tags;
        private String status;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder category(Category category){
            this.category = category;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder photoUrls(List<String> photoUrls){
            this.photoUrls = photoUrls;
            return this;
        }

        public Builder tags(List<Tag> tags){
            this.tags = tags;
            return this;
        }

        public Builder status(String status){
            this.status = status;
            return this;
        }

        public Pet build(){
            return new Pet(id, category, name, photoUrls, tags, status);
        }
    }
}
