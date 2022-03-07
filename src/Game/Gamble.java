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

  /**
   * This method simply generates a vehicle that won the dice roll
   * from the list of vehicle(s) given.
   * 
   * @param vehicle a vehicle to be tested.
   * @return The vehicle that won the dice roll.
   */
  Vehicle crash(Vehicle a, Vehicle b) {
    Vehicle v = rollDice(a, b);
    return v;
  }

  private Vehicle rollDice(Vehicle a, Vehicle b) {
    final Integer SEED = 12345;
    Random generator = new Random(SEED);
    rollDice rD = (Vehicle x, Vehicle y) -> {
      Vehicle v;
      int xRep = x.getReputation();
      int yRep = y.getReputation();
      int xDMG = x.damage();
      int yDMG = y.damage();
      int numx = (int) (generator.nextInt(xRep));
      int numy = (int) (generator.nextInt(yRep));
      x.setHealth(x.getHealth() - xDMG - yDMG);
      y.setHealth(y.getHealth() - xDMG - yDMG);
      v = (numx > numy) ? x : y;
      v.setReputation(v.getReputation() + 30);
      return v;
    };
    return rD.calc(a, b);
  }

  interface rollDice {
    Vehicle calc(Vehicle a, Vehicle b);
  }

}