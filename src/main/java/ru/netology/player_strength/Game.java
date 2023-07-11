package ru.netology.player_strength;

import java.util.HashMap;


public class Game {
    HashMap<String, Player> players = new HashMap<>();      ///создаём словарь.ключём будет - имя каждого игрока, значение - игроки с их полями

    public void register(Player player) {                   /////метод регистрации в справочнике игроков
        players.put(player.name, player);         ///ключём  - имя каждого игрока, берётся у объекта класса Player - игроков

    }

    public int round(String playerName1, String playerName2) { //метод сравнения силы

        Player player1 = null;
        Player player2 = null;

        for (String key : players.keySet()) {   //пробегаемся по ключам, соответствующие именам игроков
            if (key.equals(playerName1)) {      //если есть совпадение вводимого имени с ключами строк в словаре, то
                player1 = players.get(key);
            }
            if (key.equals(playerName2)) {
                player2 = players.get(key);
            }
        }
        //обработка ошибок при отсутствии/не зарегестрирован в справочнике
        if (player1 == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName1 + " не зарегестрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName2 + " не зарегестрирован");
        }

        //сравнение силы 2-х игроков
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }


}

