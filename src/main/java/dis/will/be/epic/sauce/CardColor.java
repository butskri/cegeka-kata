package dis.will.be.epic.sauce;

import static dis.will.be.epic.sauce.Rule.*;

public enum CardColor {
    RED(HIGHEST_CARD_WINS),
    ORANGE(MOST_OF_ONE_NUMBER_WINS),
    YELLOW(MOST_OF_ONE_COLOR_WINS),
    GREEN(MOST_EVEN_CARDS_WINS),
    BLUE(MOST_DIFFERENT_COLORS_WINS),
    INDIGO(MOST_CARDS_IN_A_ROW_WINS),
    VIOLET(MOST_CARDS_BELOW_4_WINS);

    private Rule rule;

    CardColor(Rule rule) {
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
    }
}
