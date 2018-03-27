package dis.will.be.epic.sauce;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void cardsAreEqualWhenBothColorAndNumberAreEqual() {
        Card card1 = new Card(CardColor.GREEN, 1);
        Card card2 = new Card(CardColor.GREEN, 1);

        assertThat(card1.equals(card2)).isTrue();
        assertThat(card2.equals(card1)).isTrue();
    }

    @Test
    public void cardsAreNotEqualWhenColorDifferent() {
        Card card1 = new Card(CardColor.GREEN, 1);
        Card card2 = new Card(CardColor.RED, 1);

        assertThat(card1.equals(card2)).isFalse();
        assertThat(card2.equals(card1)).isFalse();
    }

    @Test
    public void cardsAreNotEqualWhenValueDifferent() {
        Card card1 = new Card(CardColor.GREEN, 1);
        Card card2 = new Card(CardColor.GREEN, 2);

        assertThat(card1.equals(card2)).isFalse();
        assertThat(card2.equals(card1)).isFalse();
    }

    @Test
    public void cardsAreEqualToThemselves() {
        Card card1 = new Card(CardColor.GREEN, 1);
        assertThat(card1.equals(card1)).isTrue();
    }

    @Test
    public void cardsAreNotEqualWhenValueAndColorDifferent() {
        Card card1 = new Card(CardColor.GREEN, 1);
        Card card2 = new Card(CardColor.RED, 2);

        assertThat(card1.equals(card2)).isFalse();
        assertThat(card2.equals(card1)).isFalse();
    }

    @Test
    public void card_ShouldHaveAColor() {
        Card card = new Card(CardColor.BLUE, 5);
        Assertions.assertThat(card.getCardColor()).isEqualTo(CardColor.BLUE);
    }

    @Test
    public void card_ShouldHaveAValue() {
        Card card = new Card(CardColor.BLUE, 5);
        Assertions.assertThat(card.getValue()).isEqualTo(5);
    }

    @Test
    public void card_GivenValueLowerThan1_ThenThrowException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Card value should be between 1 and 7");

        new Card(CardColor.BLUE, 0);
    }

    @Test
    public void card_GivenValueHigherThan7_ThenThrowException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Card value should be between 1 and 7");

        new Card(CardColor.BLUE, 8);
    }

}