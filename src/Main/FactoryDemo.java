package Main;

import Players.Player;
import Players.PlayerFactory;

/**
 * FactoryDemo demos and tests the PlayerFactory
 * and VehicleFactory classes.
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * 
 * @see PlayerFactory
 * @see Player
 */
public class FactoryDemo {
    /**
     * Creates a playerFactory, creates a player using the factory
     * prints the player and Vehcile to console
     * 
     * @param args
     */
    public static void main(String[] args) {
        PlayerFactory pFactory = new PlayerFactory();
        Player one = pFactory.getPlayer("player", "adam", "sports");
        System.out.println("Player: " + one + "Name: " + one.getName() + "Vehicle: " + one.getVehicle());
    }
}
