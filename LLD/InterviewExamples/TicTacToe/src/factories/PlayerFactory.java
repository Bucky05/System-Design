package factories;

import models.Player;

public class PlayerFactory {

    public static Player create(int id, String name, char symbol) {
        return new Player(id,name,symbol);
    }
}
