package ru.netology.player_strength;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameTest {

    Player player1 = new Player(1, "Pemus", 5);
    Player player2 = new Player(2, "Anton", 3);
    Player player3 = new Player(3, "Xasem", 5);

    @Test
    public void DrawStrengthTest() {

        Game game = new Game();

        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Pemus", "Xasem");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Strength1MoreStrength2Test() {

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Pemus", "Anton");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Strength2MoreStrength1Test() {

        Game game = new Game();

        game.register(player2);
        game.register(player3);

        int expected = 2;
        int actual = game.round("Anton", "Xasem");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NotNamePlayer1Test() {

        Game game = new Game();

        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Sasha", "Sasha"));
    }

    @Test
    public void NotNamePlayer2Test() {

        Game game = new Game();

        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Anton", "Sasha"));
    }

    @Test
    public void NotNameBothPlayerTest() {

        Game game = new Game();

        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Sasha", "Dasha"));
    }

}




