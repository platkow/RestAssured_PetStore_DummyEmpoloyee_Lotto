package lotto;

import api.lotto.client.DummyLottoClient;
import api.lotto.model.APIResponse;
import api.lotto.model.GameType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoTest {
    private DummyLottoClient dummyLottoClient;
    @BeforeEach
    public void setup(){
       dummyLottoClient = new DummyLottoClient();
    }

    @Test //403 error code was displayed, both for this and mentor's test. Practice will be covered by other available API.
    public void shouldGetLastResultsPerGame(){
        ValidatableResponse response = dummyLottoClient.getLastResultsPerGame(GameType.EURO_JACKPOT);
        APIResponse apiResponse = response.extract().body().as(APIResponse.class);
        Assertions.assertEquals(apiResponse.getGameType(), GameType.EURO_JACKPOT);
    }
}
