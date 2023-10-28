package api.lotto.client;

import api.BaseRequests;
import api.lotto.model.GameType;
import io.restassured.response.ValidatableResponse;

public class DummyLottoClient extends BaseRequests {
    private final String LAST_RESULTS_PER_GAME = "https://www.lotto.pl/api/lotteries/draw-results/last-results-per-game?gameType=";

    public ValidatableResponse getLastResultsPerGame(GameType gameType){
        return get(LAST_RESULTS_PER_GAME + gameType.toString());
    }

}
