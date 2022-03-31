package Game;

import Vehicle.*;
import Players.*;
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

  private Graph graph;

  private Player player;

  private Gamble challenge;

  /**
   * This method simply updates the time for the game and
   * can be used as the main game loop.
   */
  public void updateTime() {
    try {
      graph.updateTimeSegments();
    } catch (Exception e) {
      System.out.println("Please add a player first!");
    }
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
  public void initializeGame(Graph graph, Player player) {
    challenge = new Gamble();
    this.car = player.getVehicle();
    this.player = player;
    this.graph = graph;
    time = 0;
  }

  /**
   * This method will add the vehicle object to the map.
   * 
   * @param player The vehicle to be added to the road segement.
   * @param start  The starting number of intersection to add vehicle.
   * @param end    The ending number of intersection to add vehicle.
   * @param num    The lane number to be added starts at 0.
   */
  public void addPlayer(Player player, int start, int end, int num) {
    Intersection[] arrIntsec = graph.getIntersections();
    graph.getRoad(arrIntsec[start], arrIntsec[end]).addPlayer(player, num);
    player.updateRoad(graph.getRoad(arrIntsec[start], arrIntsec[end]));
  }

}