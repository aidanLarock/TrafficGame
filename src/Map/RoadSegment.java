package Map;

import java.util.ArrayList;

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

  ArrayList<Vehicle> listVehicles;

  Intersection start;

  Intersection end;

  private Integer length;

  private Integer density;

  private Integer numLanes;

  public RoadSegment(int length, int density, int numLanes) {
    this.length = length;
    this.density = density;
    this.numLanes = numLanes;
    listVehicles = null;
  }

  public ArrayList<?> getList() {
    return listVehicles;
  }

  /**
   * 
   * @param e
   */
  public void addVehicle(Vehicle e) {
    this.listVehicles.add(e);
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
   * This method gets the number of cars that are on the road segment
   * 
   * @return vehicle density
   */
  Integer getDensity() {
    return this.density;
  }

  void setDensity(int density) {
    this.density = density;
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
  public void move(Integer lane, Vehicle who) {
  }

}