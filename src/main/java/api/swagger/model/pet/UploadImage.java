package api.swagger.model.pet;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;

@Data
@AllArgsConstructor
public class UploadImage {
    private String additionalMetadata;
    private File file;
}
