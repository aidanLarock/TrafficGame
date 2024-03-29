package Map;

import java.util.ArrayList;
import java.util.LinkedList;

import Players.*;

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

  private Integer numLanes;

  private int capacities[];

  String type;

  public RoadSegment(int length, int numLanes, int endIntersection) {
    this.length = length;
    this.numLanes = numLanes;
    this.endIntersection = endIntersection;
    capacities = new int[numLanes];
    playerLanes = new ArrayList<>();

    for (int i = 0; i < numLanes; i++) {
      playerLanes.add(new LinkedList<Player>());
      capacities[i] = length;
    }
  }

  /**
   * Returns the list of player lanes at this road segment.
   * 
   * @return the list of player lanes.
   */
  public ArrayList<LinkedList<Player>> getPlayerLanes() {
    return playerLanes;
  }

  /**
   * Returns capacities for each lane.
   * 
   * @return a 1d array of capacities for each lane.
   */
  public int[] getCapacities() {
    return capacities;
  }

  /**
   * Updates the capacities at a lane.
   * 
   * @param l    the lane in question.
   * @param size positive or negative of size update.
   */
  private void updateCapacities(int l, int size) {
    capacities[l] = capacities[l] + size;
  }

  /**
   * This method retrieves the list of players on the lane.
   * 
   * @param num the lane number in question.
   * @return a linkedlist of players to add.
   */
  public LinkedList<Player> getLane(int num) {
    return playerLanes.get(num);
  }

  /**
   * This method changes the lane of a given player based on
   * the inputted direction.
   * 
   * @param e The player in question.
   * @param d The direction to switch.
   */
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
      updateCapacities(y, temp.getVehicle().getSize());
      updateCapacities(y + d, -temp.getVehicle().getSize());
      e.setLaneNum(y + d);
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

  /**
   * Gets the ending intersection of a road segement.
   * 
   * @return the ending intersection for the road.
   */
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
        updateCapacities(num, -e.getVehicle().getSize());
        e.setLaneNum(num);
        // System.out.println("Player added: " + e.getName() + ", Great Success!");
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
   * This method creates a road segment from a start and end location
   * from two given intersections.
   * 
   * @param start type intersection to start from.
   * @param end   type intersection end at.
   */
  public void createIntersection(Intersection start, Intersection end) {
    this.start = start;
    this.end = end;
  }

  /**
   * Sets the type of map object as a string.
   * 
   * @param s string
   */
  @Override
  public void setType(String s) {
    this.type = s;
  }

  /**
   * Returns the type of map object as a string.
   * 
   * @return the name of the type.
   */
  @Override
  public String getType() {
    return type;
  }

}