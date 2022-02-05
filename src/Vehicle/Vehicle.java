package Vehicle;

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

  private Integer size;

  private final Integer MAXREP = 100;

  private final Integer MINREP = 1;

  /**
   * This method moves a vechicle by a unit
   * respective to speed and acceleration.
   * 
   * @param speed        Current speed of vehicle.
   * @param acceleration Current acceleration of vehicle.
   */
  public void move(Double speed, Double acceleration) {
  }

  /**
   * Calculates the damage
   * 
   * @param health the current health of the vehicle.
   * @param speed  the current speed of the vehicle.
   * @return The respective damage calculation carried out
   *         resptective to health and speed.
   */
  public Integer damage(Integer health, Integer speed) {
    return null;
  }

  /**
   * This method sets the reputation for the vehicle.
   * 
   * @param reputation the reputation to be set.
   */
  public void setReputation(Integer reputation) {
  }

  /**
   * This method gets the image location of a vehicle.
   * 
   * @return the string path of the image location.
   */
  public String getImage() {
    return null;
  }

  /**
   * This method gets the current health of the vehicle.
   * 
   * @return the most current health of the vehicle.
   */
  public Integer getHealth() {
    return null;
  }

  /**
   * This method simply gets the reputation for the
   * current vehicle.
   * 
   * @return the current reputation from the vehicle.
   */
  public Integer getReputation() {
    return null;
  }

  /**
   * This method gets the current speed of the vehicle.
   * 
   * @return a double of the current speed the vehicle
   *         is going.
   */
  public Double getSpeed() {
    return null;
  }

  /**
   * This methods gets the current acceleration of the
   * vehicle.
   * 
   * @return the acceleration of the vehicle.
   */
  public Double getAcceleration() {
    return null;
  }

}