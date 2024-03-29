package Vehicle;

import java.util.function.Consumer;

import Map.RoadSegment;

/**
 * An abstract class that provides implementations for the
 * vehicle class. This contains many getter and setter methods
 * to be used when vehicle information needs to be requested.
 * Vehicles are given a reputation. It grows as right, conservatives
 * decisions are made. It decreases as the player looses Challenges or
 * when it gambles.
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * @version 2 Feb 2022
 * @see Main
 * @see Game
 */
public abstract class Vehicle {

  private Double speed;

  private Double acceleration;

  private Integer reputation;

  private Integer health;

  private String image;

  private Integer size = 1;

  private final Integer MAXREP = 100;

  private final Integer MINREP = 1;

  private RoadSegment road;

  private int lane;

  /**
   * This method moves a vechicle by a unit
   * respective to speed and acceleration.
   * 
   * @param speed        Current speed of vehicle.
   * @param acceleration Current acceleration of vehicle.
   */
  public void move(RoadSegment road) {
    this.speed = this.speed * this.acceleration;
    // road.move(this);
    // move up to next road spot.
  }

  /**
   * Calculates the damage output.
   * 
   * @param speed the current speed of the vehicle.
   * @return The respective damage calculation carried out
   *         resptective to health and speed.
   */
  public Integer damage() {
    this.health = (int) (this.speed * (1 / this.size));
    return this.health;
  }

  /**
   * This method sets the reputation for the vehicle.
   * 
   * @param reputation the reputation to be set.
   */
  public void setReputation(Integer reputation) {
    this.reputation = reputation;
  }

  /**
   * This method gets the image location of a vehicle.
   * 
   * @return the string path of the image location.
   */
  public String getImage() {
    return image;
  }

  /**
   * This method gets the current health of the vehicle.
   * 
   * @return the most current health of the vehicle.
   */
  public Integer getHealth() {
    return health;
  }

  /**
   * This method sets the current health of the vehicle.
   * 
   */
  public void setHealth(int health) {
    this.health = health;
  }

  /**
   * This method simply gets the reputation for the
   * current vehicle.
   * 
   * @return the current reputation from the vehicle.
   */
  public Integer getReputation() {
    return reputation;
  }

  /**
   * This method gets the current speed of the vehicle.
   * 
   * @return a double of the current speed the vehicle
   *         is going.
   */
  public Double getSpeed() {
    return speed;
  }

  /**
   * This methods gets the current acceleration of the
   * vehicle.
   * 
   * @return the acceleration of the vehicle.
   */
  public Double getAcceleration() {
    return acceleration;
  }

  /**
   * Gets the road that the current vehicle is on.
   * 
   * @return The road segment the vehicle is on.
   */
  public RoadSegment getRoad() {
    return this.road;
  }

  /**
   * Updates the vehicle location on a road segment.
   * 
   * @param road The road segment to update.
   */
  public void updateRoad(RoadSegment road) {
    this.road = road;
  }

  /**
   * Updates the vehicle lane in the road segment
   * 
   * @param lane lane segment to update to.
   */
  public void updateLane(int lane) {
    this.lane = lane;
  }

  /**
   * Gets the lane the vehicle is in.
   * 
   * @param lane lane the vehcile is in.
   */
  public int getLane() {
    return this.lane;
  }

  /**
   * Sets the size of a vehicle.
   * 
   * @param size The size to set.
   */
  public void setSize(int size) {
    this.size = size;
  }

  /**
   * Gets the size of the vehicle.
   * 
   * @return an integer of the size of the vehicle.
   */
  public int getSize() {
    return size;
  }

}