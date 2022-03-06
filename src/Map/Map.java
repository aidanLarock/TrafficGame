package Map;

import Vehicle.Vehicle;

/**
 * The class Graph stores and loads the graph of the
 * Map using an adjacency matrix. Can also get a
 * Road Segement with a start and a end location.
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * @version 2 Feb 2022
 * @see Main
 * @see Map
 */
public interface Map {

  /**
   * sends an integer value of the number of lanes that are avalible in a road or
   * intersection
   * 
   * @return integer number of lanes avalible
   */
  public Integer lanesAvalible();

}