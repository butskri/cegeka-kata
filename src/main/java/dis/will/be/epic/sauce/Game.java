package dis.will.be.epic.sauce;

import java.util.List;
import java.util.stream.IntStream;

import static com.google.common.collect.Lists.newArrayList;
import static dis.will.be.epic.sauce.Rule.HIGHEST_CARD_WINS;
import static java.util.stream.Collectors.toList;

public class Game {

    private List<Player> players;

    private Game() {
        players = newArrayList();
    }

    public static Game setup() {
        Game game = new Game();
        Deck deck = new Deck();
        game.players.add(setUpPlayer(sevenCardsFrom(deck), deck.pullCard()));
        game.players.add(setUpPlayer(sevenCardsFrom(deck), deck.pullCard()));
        game.players.add(setUpPlayer(sevenCardsFrom(deck), deck.pullCard()));
        game.players.add(setUpPlayer(sevenCardsFrom(deck), deck.pullCard()));
        return game;
    }

    private static List<Card> sevenCardsFrom(Deck deck) {
        return IntStream.rangeClosed(1, 7).mapToObj(value -> deck.pullCard()).collect(toList());
    }

    private static Player setUpPlayer(List<Card> sevenCards, Card tableauCard) {
        return new Player(sevenCards, tableauCard);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Rule getActiveRule() {
        return HIGHEST_CARD_WINS;
    }
}
