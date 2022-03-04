package Game;

import Vehicle.*;
import Players.Player;
import Map.*;

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

  Vehicle car;

  private Integer time;

  private RoadSegment roadSeg;

  private Graph graph;

  private Player player;

  private Gamble challenge;

  /**
   * This method simply updates the time for the game and
   * can be used as the main game loop.
   */
  public void updateTime() {
    time++;
  }

  /**
   * This method initializes the game and intiates the variables for use and
   * can be used in the main game loop.
   * 
   * @param graph  the graph the initalized.
   * @param car    the car(s) to be initalized.
   * @param player the player(s) to be intialized.
   */
  public void initializeGame(Graph graph, Vehicle car, Player player) {
    challenge = new Gamble();
    this.car = car;
    this.player = player;
    this.graph = graph;
    time = 0;

    graph.loadMap();

  }

  /**
   * This method will add the vehicle object to the map.
   * 
   * @param vehicle The vehicle to be added to the road segement.
   * @param start   The starting number of intersection to add vehicle
   * @param end     The ending number of intersection to add vehicle
   */
  public void addVehicle(Vehicle vehicle, int start, int end) {
    Intersection[] arrIntsec = graph.getIntersections();
    graph.getRoad(arrIntsec[start], arrIntsec[end]).addVehicle(vehicle);
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