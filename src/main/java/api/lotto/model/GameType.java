package api.lotto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameType {
    EURO_JACKPOT("EuroJackpot");

    private final String gameType;
}
