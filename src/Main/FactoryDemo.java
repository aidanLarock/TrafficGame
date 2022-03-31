package Main;

import Players.Player;

public class FactoryDemo {
    public static void main(String[] args) {
        PlayerFactory pFactory = new PlayerFactory();

        Player one = pFactory.getPlayer("player", "adam", "sports");
        System.out.println(one + " " + one.getVehicle());
    }
}
