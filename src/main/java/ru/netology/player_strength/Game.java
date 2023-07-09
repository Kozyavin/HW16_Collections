package ru.netology.player_strength;
import java.util.ArrayList;
import java.util.List;


public class Game {
    List<Player> players = new ArrayList<>();

    public void register(Player player) {                   /////метод регистрации в списке игроков
        players.add(player);

    }

    public int round(String playerName1, String playerName2) {

        Player player1 = null;
        Player player2 = null;

        for (Player name : players) {
            if (name.getName().equals(playerName1)) {
                player1 = name;
            }
            if (name.getName().equals(playerName2)) {
                player2 = name;
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName1 + " не зарегестрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName2 + " не зарегестрирован");
        }


        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }

}












/*

     public int round(String playerName1, String playerName2, Comparator<Player> comparator) {
        for (Player name : players) {
            if ((playerName1 != name.getName()) && (playerName2 != name.getName())){
                throw new NotRegisteredException("Игрок с именем " + playerName1 + " не зарегестрирован");
            }
        }
        Collections.sort(players, comparator);
        return comparator;
    }
    */