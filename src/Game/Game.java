package Game;

import Vehicle.Vehicle;
import Players.Player;
import Map.Map;

/**
 * This game class creates a Game object containing a Map, Vehicle, and Players
 * and is the main
 * intersection for the logic in the game. This class will initialize the game
 * and is given
 * abilities to add vehicle and add a player to a vehicle.
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * @version 2 Feb 2022
 * @see Main
 * @see Players
 * @see Map
 * @see Vehicle
 */
public class Game {

  private Integer time;

  private Map map;

  private Player player;

  private Gamble challenge;

  /**
   * This method simply updates the time for the game and
   * can be used as the main game loop.
   */
  public void updateTime() {
  }

  /**
   * This method initializes the game and intiates the variables for use and
   * can be used in the main game loop.
   * 
   * @param map    the map the initalized.
   * @param car    the car(s) to be initalized.
   * @param player the player(s) to be intialized.
   */
  public void initializeGame(Map map, Vehicle car, Player player) {
  }

  /**
   * This method will add the vehicle object to the map.
   * 
   * @param vehicle The vehicle to be added to the map.
   * @param map     The map the vehicle is being added to.
   */
  public void addVehicle(Vehicle vehicle, Map map) {
  }

  /**
   * This method adds the player to the vehicle.
   * 
   * @param player  The player to be added to the vehicle.
   * @param vehicle The vehicle the player is being added to.
   */
  public void addPlayerToVehicle(Player player, Vehicle vehicle) {
  }

}