package Map;

import Vehicle.Vehicle;

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

  private Integer length;

  private Integer density;

  private Integer numLanes;

  /**
   * This method gets the length of a road segment
   * 
   * @return road segment length
   */
  Integer getLength() {
    return null;
  }

  /**
   * This method gets the number of cars that are on the road segment
   * 
   * @return vehicle density
   */
  Integer getDensity() {
    return null;
  }

  /**
   * This method gets the number of lanes a road segment has
   * 
   * @return number of lanes
   */
  Integer getNumberLanes() {
    return null;
  }

  /**
   * sends an integer value of the number of lanes that are avalible in a road or
   * intersection
   * 
   * @return integer number of lanes avalible
   */
  public Integer lanesAvalible() {
    return null;
  }

  /**
   * moves a vehicle into a specified lane
   * 
   * @param lane lane to move vehicle into
   * @param who  vehcile to move
   */
  public void move(Integer lane, Vehicle who) {
  }

}