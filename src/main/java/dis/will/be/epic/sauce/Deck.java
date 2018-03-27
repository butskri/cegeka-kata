package dis.will.be.epic.sauce;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class Deck {

    private List<Card> cards;

    public Deck() {
        this.cards = stream(CardColor.values()).flatMap(this::addCardsForColor).collect(toList());
    }

    public List<Card> getCards() {
        return cards;
    }

    private Stream<Card> addCardsForColor(CardColor cardColor) {
        return rangeClosed(1,7).mapToObj(value -> new Card(cardColor, value));
    }

    public Card pullCard() {
        return cards.remove(0);
    }
}
