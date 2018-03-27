package dis.will.be.epic.sauce;

public enum Rule {
    HIGHEST_CARD_WINS,
    MOST_OF_ONE_NUMBER_WINS,
    MOST_OF_ONE_COLOR_WINS,
    MOST_EVEN_CARDS_WINS,
    MOST_DIFFERENT_COLORS_WINS,
    MOST_CARDS_IN_A_ROW_WINS,
    MOST_CARDS_BELOW_4_WINS;

    Player getWinningPlayer() {
        return null;
    }
}
