package Players;

import Vehicle.*;

/**
 * PlayerFactory creates new player objects
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * 
 * @see Player
 */
public class PlayerFactory {
    VehicleFactory vFactory = new VehicleFactory();

    /**
     * Creates and retruns a new player object
     * 
     * @param playerType type of player (AI / User controlled)
     * @param name       name of the player to make
     * @param vehicle    type of vehicle to create in VehicleFactory and attach to
     *                   player
     * @return player object
     */
    public Player getPlayer(String playerType, String name, String vehicle) {
        if (playerType.toLowerCase().equals("player")) {
            return new Player(name, vFactory.getVehicle(vehicle));
        } else if (playerType.toLowerCase().equals("ai")) {
            return new Player(name, vFactory.getVehicle(vehicle)).makeAIPlayer(name, vFactory.getVehicle(vehicle));
        } else {
            System.out.println("Player Provided type is not available.");
            return null;
        }
    }
}
