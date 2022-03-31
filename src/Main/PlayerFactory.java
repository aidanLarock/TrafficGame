package Main;

import Players.Player;

public class PlayerFactory {
    VehicleFactory vFactory = new VehicleFactory();

    public Player getPlayer(String playerType, String name, String vehicle) {
        if (playerType.equalsIgnoreCase("Player")) {
            return new Player(name, vFactory.getVehicle(vehicle));
        } else if (playerType.equalsIgnoreCase("AI")) {
            return new Player(name, vFactory.getVehicle(vehicle)).makeAIPlayer(name, vFactory.getVehicle(vehicle));
        } else {
            return null;
        }
    }
}
