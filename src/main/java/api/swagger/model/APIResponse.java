package api.swagger.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class APIResponse {

    private int code;
    private String type;
    private String message;
}
