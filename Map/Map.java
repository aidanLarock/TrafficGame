package Map;

import Vehicle.Vehicle;

/**
 * An interface for the Map class 
 */
public interface Map {

  RoadSegment getRoad(Intersection Start, Intersection End);

  public Integer lanesAvalible();

  public void move(Integer lane, Vehicle who);

}