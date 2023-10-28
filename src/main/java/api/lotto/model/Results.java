package api.lotto.model;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Results {
    private String drawDate;
    private GameType gameType;
    private List<Integer> resultsJson;
    private List<Integer> specialResults;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
