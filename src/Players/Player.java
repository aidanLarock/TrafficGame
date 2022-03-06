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

  public String getName() {
    return name;
  }

  public Player(String name, Vehicle type) {
    this.name = name;
    this.type = type;
  }

  public Vehicle getVehicle() {
    return type;
  }

  /**
   * Allows the player to move a vehicle.
   */
  public void moving() {
    RoadSegment road = type.getRoad();
    this.type.move(road);

    // lanes avalible = number of lanes we have
    // need to get current lane
    // move car to that lane
  }

  /**
   * Moves the car through the intersection to a new road segment
   * 
   */
  public void moveIntersection(Graph g) {
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
          break;
        case 0:
          newRoad = r[1];
          break;
        case 1:
          newRoad = r[2];
          break;
      }
    } catch (Exception e) {
      System.out.println("Not a Valid Road");
    }
    newRoad.addPlayer(this, 0);
    this.type.updateRoad(newRoad);
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