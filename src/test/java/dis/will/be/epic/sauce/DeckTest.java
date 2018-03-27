package dis.will.be.epic.sauce;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {

    @Test
    public void deckHas49Cards() {
        List<Card> cards = new Deck().getCards();

        assertThat(cards).hasSize(49);
    }

    @Test
    public void deckHas7Colors() {
        List<Card> cards = new Deck().getCards();
        assertThat(cards).extracting(Card::getCardColor).contains(CardColor.values());
    }

    @Test
    public void deckHas7Values() {
        List<Card> cards = new Deck().getCards();
        assertThat(cards).extracting(Card::getValue).contains(1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    public void pullCardsReturnsCorrectAmountAndRemovesFromDeck() {
        Deck deck = new Deck();

        Card pulledCard = deck.pullCard();

        SoftAssertions softAssertions = new SoftAssertions();
        assertThat(deck.getCards()).hasSize(48);
        assertThat(deck.getCards()).doesNotContain(pulledCard);
        softAssertions.assertAll();
    }

    @Test
    public void allCardsShouldBeUnique() {
        List<Card> cards = new Deck().getCards();

        assertThat(new HashSet<>(cards)).hasSize(49);
    }

    @Test
    public void pullCardsReturnsFirstCardOfDeck() {
        Deck deck = new Deck();
        Card firstCardOfDeck = deck.getCards().get(0);

        assertThat(deck.pullCard()).isEqualTo(firstCardOfDeck);
    }
}