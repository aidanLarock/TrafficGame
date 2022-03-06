package Map;

import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import Players.Player;

/**
 * The class RoadSegment stores the information of a road (edge between
 * intersections).
 * The class holds information about roads such as length of a road, density of
 * a road, and the number of lanes
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * @version 2 Feb 2022
 * @see Map
 */
public class RoadSegment implements Map {

  private ArrayList<LinkedList<Player>> playerLanes;

  Intersection start;

  Intersection end;

  private Integer endIntersection;

  private Integer length;

  private Integer density;

  private Integer numLanes;

  public RoadSegment(int length, int numLanes, int endIntersection) {
    this.length = length;
    this.numLanes = numLanes;
    this.endIntersection = endIntersection;

    playerLanes = new ArrayList<>();

    for (int i = 0; i < numLanes; i++) {
      playerLanes.add(new LinkedList<Player>());
    }
  }

  public ArrayList<?> getPlayerLanes() {
    return playerLanes;
  }

  /**
   * 
   * @param num
   * @return
   */
  public LinkedList<Player> getLane(int num) {
    return playerLanes.get(num);
  }

  // changes vehicles lane into lane
  // input player, int
  public void changeLane(Player e, int d) {
    int x = 0;
    int y = 0;
    for (int i = 0; i < playerLanes.size(); i++) {
      LinkedList<Player> pq = playerLanes.get(i);
      x = pq.indexOf(e);
      y = i;
      if (x != -1) {
        break;
      }
    }
    if (d != 0) {
      Player temp = playerLanes.get(y).get(x);
      playerLanes.get(y).remove(x);
      playerLanes.get(y + d).add(x, temp);
    }
  }

  /**
   * Get the head player from a lane
   * 
   * @param e The player to poll
   * @param l The lane num to check
   * @return The polled player.
   */
  public Player pollPlayer(Player e, int l) {
    return playerLanes.get(l).poll();
  }

  public int getEndIntersection() {
    return this.endIntersection;
  }

  /**
   * Add the player to the road segement at a specific lane.
   * 
   * @param e   the player to be added.
   * @param num the lane number to be added.
   */
  public void addPlayer(Player e, int num) {
    if (e != null) {
      if (playerLanes.get(num).add(e)) {
        System.out.println("Great Success!");
      } else
        System.out.println("At capacity!");
    } else {
      playerLanes.get(num).add(e);
    }

  }

  /**
   * This method gets the length of a road segment
   * 
   * @return road segment length
   */
  Integer getLength() {
    return this.length;
  }

  /**
   * sends an integer value of the number of lanes that are avalible in a road or
   * intersection
   * 
   * @return integer number of lanes avalible
   */
  public Integer lanesAvalible() {
    return this.numLanes;
  }

  /**
   * finds the player withing
   * 
   * @return spot of vehicle in array
   */
  public Integer findPlayer() {
    return this.numLanes;
  }

  /**
   * 
   * @param numLanes
   */
  void lanesAvalible(int numLanes) {
    this.numLanes = numLanes;
  }

  /**
   * This method creates a road segment from a start and end location
   * from two given intersections.
   * 
   * @param start type intersection to start from.
   * @param end   type intersection end at.
   */
  void createIntersection(Intersection start, Intersection end) {
    this.start = start;
    this.end = end;
  }

  /**
   * moves a vehicle into a specified lane
   * 
   * @param lane lane to move vehicle into
   * @param who  vehcile to move
   */
  public void moveLane(Vehicle who) {
    // who.get
  }

}