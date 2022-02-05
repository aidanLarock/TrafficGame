package Vehicle;

/**
 * An extended class that provides implementations for the
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
public class Car extends Vehicle {

  private Double speed;

  private Double acceleration;

  private Integer reputation;

  private Integer health;

  private String image;

  private Integer size;

}