package Game;

import java.util.Random;

import Vehicle.Vehicle;

/**
 * This class Gamble it allows the player to take chances. It gives risky
 * opportunities to the player. Thus, by rolling dices, it infers if the
 * player was lucky or not. It will use the psuedo randomizer 1 - 6 from a seed.
 * It will then output a the vehicle that won the dice roll.
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * @version 2 Feb 2022
 * @see Game
 * @see Main
 */
class Gamble {

  private Vehicle vehicle;

  private final Integer SEED = 12345;

  private Random generator = new Random(SEED);

  /**
   * This method simply generates a vehicle that won the dice roll
   * from the list of vehicle(s) given.
   * 
   * @param vehicle a vehicle to be tested.
   * @return The vehicle that won the dice roll.
   */
  Vehicle rolldice(Vehicle a, Vehicle b) {
    int aRep = a.getReputation();
    int bRep = b.getReputation();
    int max = 6;
    int num = (int) (generator.nextInt(max));
    return null;
  }

}