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

  Double speed;

  Double acceleration;

  Integer reputation;

  Integer health;

  Integer size;

  final Integer MAXREP = 100;

  final Integer MINREP = 1;

  /**
   * This method moves a vechicle by a unit
   * respective to speed and acceleration. 
   * @param speed Current speed of vehicle.
   * @param acceleration Current acceleration of vehicle. 
   */
  public void move(Double speed, Double acceleration) {
  }

  /**
   * Calculates the damage 
   * @param health
   * @param speed
   * @return
   */
  public Integer damage(Integer health, Integer speed) {
    return null;
  }

  public Integer setReputation(Integer reputation) {
    return null;
  }

  public String getImage() {
    return null;
  }

  public Integer getHealth() {
    return null;
  }

  public Integer getReputation() {
    return null;
  }

  public Double getSpeed() {
    return null;
  }

  public Double getAcceleration() {
    return null;
  }

}