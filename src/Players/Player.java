package Players;

import java.util.Scanner;

import Vehicle.Vehicle;
import Map.*;

/**
 * This class player is a type of vehicle object which allows for
 * a user to interact with and move a vehicle object.
 * 
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * @version 2 Feb 2022
 * @see Game
 * @see Vehicle
 */
public class Player {

  private Graph g;
  private Vehicle type;
  private String name;
  static Scanner scan;

  /**
   * A getter method to get the name of the player as a string.
   * 
   * @return The string that owns this player.
   */
  public String getName() {
    return name;
  }

  /**
   * Initilizer to player.
   * 
   * @param name The string name that owns this player.
   * @param type The Vehicle this player owns.
   */
  public Player(String name, Vehicle type) {
    this.name = name;
    this.type = type;
  }

  /**
   * Gets the vehicle object owned by the player.
   * 
   * @return The vehicle owned by the player.
   */
  public Vehicle getVehicle() {
    return type;
  }

  /**
   * Moves intersections and throws an exception if not possible.
   * 
   * @param g The map of the game.
   * @return The turns possible at a intersection
   * @throws Exception
   */
  public Turns moveIntersection(Graph g) throws Exception {
    Turns turn = null;
    RoadSegment newRoad = null;
    RoadSegment road = type.getRoad();
    road.pollPlayer(this, 1);
    int laneTurn = confirm();
    int end = road.getEndIntersection();
    RoadSegment[] r = g.possibleTurns(end);
    try {
      switch (laneTurn) {
        case -1:
          newRoad = r[0];
          turn = Turns.LEFT;
          break;
        case 0:
          newRoad = r[1];
          turn = Turns.STRAIGHT;
          break;
        case 1:
          newRoad = r[2];
          turn = Turns.RIGHT;
          break;
        default:

      }
    } catch (Exception e) {
      throw new Exception("Pick a valid number");
    }
    newRoad.addPlayer(this, 0);
    this.type.updateRoad(newRoad);
    return turn;
  }

  /**
   * The current lane number that the vehicle is on.
   * 
   * @return The lane that the vehicle is on.
   */
  public int getLaneNumber() {
    RoadSegment road = type.getRoad();
    return road.lanesAvalible();
  }

  /**
   * Moves the car into a new lane
   * 
   */
  public void changeLane() {
    int turn = confirm();
    RoadSegment road = type.getRoad();
    try {
      road.changeLane(this, turn);
    } catch (Exception e) {
      System.out.println("Invalid lane");
    }

  }

  /**
   * Asks the player to confirm the players movemment.
   */
  public int confirm() {
    System.out.println("Enter a movement command: ");
    System.out.println("-1 left, 0 straight, 1 right");

    try {
      scan = new Scanner(System.in);
      int move = scan.nextInt();
      scan.nextLine();
      return move;
    } catch (Exception e) {
      System.out.println("You fool a number!");
    }
    return 0;
  }

  public void updateRoad(RoadSegment road) {
    type.updateRoad(road);
  }

}