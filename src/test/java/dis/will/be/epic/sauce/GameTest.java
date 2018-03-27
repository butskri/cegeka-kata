package dis.will.be.epic.sauce;

import org.junit.Test;

import java.util.List;

import static dis.will.be.epic.sauce.Rule.HIGHEST_CARD_WINS;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void gameHas4Players() {
        Game game = Game.setup();
        assertThat(game.getPlayers()).hasSize(4);
    }

    @Test
    public void allPlayersHave7HandCards() {
        Game game = Game.setup();
        assertThat(game.getPlayers()).extracting(Player::getHandCards).extracting(List::size).containsOnly(7);
    }

    @Test
    public void allPlayersShouldHaveAllUniqueCards() {
        Game game = Game.setup();
        long actualCount = game.getPlayers().stream()
                .flatMap(player -> player.getHandCards().stream())
                .distinct()
                .count();
        assertThat(actualCount).isEqualTo(4 * 7);
    }

    @Test
    public void allPlayersShouldHaveUniqueTableauCard() {
        Game game = Game.setup();
        long actualCount = game.getPlayers().stream()
                .flatMap(player -> player.getTableauCards().stream())
                .distinct()
                .count();
        assertThat(actualCount).isEqualTo(4);
    }

    @Test
    public void activeRuleIsInitiallyHighestCardWins() {
        Game game = Game.setup();

        Rule rule = game.getActiveRule();

        assertThat(rule).isEqualTo(HIGHEST_CARD_WINS);
    }
}