package dis.will.be.epic.sauce;

import org.junit.Test;

import static dis.will.be.epic.sauce.CardColor.*;
import static dis.will.be.epic.sauce.Rule.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CardColorTest {

    @Test
    public void redHasHighestWinsRule() {
        assertThat(RED.getRule()).isEqualTo(HIGHEST_CARD_WINS);
    }

    @Test
    public void orangeHasMostOfOneNumberWinsRule() {
        assertThat(ORANGE.getRule()).isEqualTo(MOST_OF_ONE_NUMBER_WINS);
    }

    @Test
    public void yellowHasMostOfOneColorWinsRule() {
        assertThat(YELLOW.getRule()).isEqualTo(MOST_OF_ONE_COLOR_WINS);
    }

    @Test
    public void greenHasMostEvenCardsWinsRule() {
        assertThat(GREEN.getRule()).isEqualTo(MOST_EVEN_CARDS_WINS);
    }

    @Test
    public void blueHasMostDifferentColorsWinsRule() {
        assertThat(BLUE.getRule()).isEqualTo(MOST_DIFFERENT_COLORS_WINS);
    }

    @Test
    public void indigoHasMostCardsInARowWinsRule() {
        assertThat(INDIGO.getRule()).isEqualTo(MOST_CARDS_IN_A_ROW_WINS);
    }

    @Test
    public void violetHasMostCardsBelow4WinsRule() {
        assertThat(VIOLET.getRule()).isEqualTo(MOST_CARDS_BELOW_4_WINS);
    }
}