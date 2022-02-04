package Map;

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
public class Graph {

  private Intersection[][] intersection;

  private RoadSegment road;

  Integer numRoads;

  Integer numInter;

  /**
   * Loads and stores the adjacency matrix used for the graph. 
   * @param inter The adjacency matrix of type Integer. 
   */
  public void loadMap(Intersection[][] intersection) {
    
  }

  /**
   * Gets the map that is stored in memory which is comprised of intersections and road segments.
   * @return the graph in an adjacency matrix
   */
  public Intersection[][] getMap(){
    return null;
  }

  /**
   * Adds a road (edges) between intersections (graph nodes)
   * @param start from intersection
   * @param end to intersection
   * @param road RoadSegment to add
   */
  private void addRoad(Intersection start, Intersection end, RoadSegment road){
    
  }
 
  /**
   * A getter function designed to get the road segment(s) from the 
   * starting intersection and ending intersection. 
   * @param start the starting intersection
   * @param end the ending intersection 
   * @return the road segment from start to end. 
   */
  public RoadSegment getRoad(Intersection start, Intersection end) {
    return null;
  }

}