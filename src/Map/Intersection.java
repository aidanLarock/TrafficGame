package Map;

import Vehicle.Vehicle;

/**
 * The class Intersection stores the information on a specific intersection
 * which is a node for the map class. An intersection allows for turning and
 * contains methods for allowing a vehicle object to turn
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * @version 2 Feb 2022
 * @see Main
 * @see Map
 */
public class Intersection implements Map {

  int turns;
  int lanesAvalible;

  public Intersection(int turns, int lanesAvalible) {
    this.turns = turns;
    this.lanesAvalible = lanesAvalible;
  }

  /**
   * This method finds roads which are connected to the current
   * intersection
   * This allows for the engine to know what roads are directly connected
   */
  private void findNextRoads() {

  }

  /**
   * This method gets a specfic node from the map
   * 
   * @return Intersection
   */
  public Intersection getNode() {
    return null;
  }

  /**
   * This method gets the possible turns that can be made
   * (some intersections dont allow all moves). Intersections allow a
   * maximum of 3 moves (left, right, straight), and all have a combination
   * of each.
   * 
   * @return the avalible moves an intersection has (Right, Left, Straight)
   */
  public int getRoadTurns() {
    return this.turns;
  }

  /**
   * Sends an integer value of the number of lanes that are avalible in a road or
   * intersection
   * 
   * @return integer number of lanes avalible
   */
  public Integer lanesAvalible() {
    return null;
  }

  /**
   * Moves a vehicle into a specified lane
   * 
   * @param lane lane to move vehicle into
   * @param who  vehcile to move
   */
  public void move(Integer lane, Vehicle who) {
  }
}