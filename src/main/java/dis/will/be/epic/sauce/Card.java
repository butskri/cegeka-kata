package dis.will.be.epic.sauce;

import com.google.common.base.Preconditions;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Card {

    private final CardColor cardColor;
    private final int value;

    public Card(CardColor cardColor, int value) {
        Preconditions.checkArgument(assertValue(value), "Card value should be between 1 and 7");
        this.cardColor = cardColor;
        this.value = value;
    }

    private boolean assertValue(int value) {
        return value >= 1 && value <= 7;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return new EqualsBuilder()
                .append(value, card.value)
                .append(cardColor, card.cardColor)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(cardColor)
                .append(value)
                .toHashCode();
    }
}