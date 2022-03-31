package Map;

/**
 * The class Map creates a composite using road segement
 * and graph, this simple yet effective interface keeps
 * track of the type as a string whether it is a road
 * segment of graph, this can be used to uniquely idenfity
 * the type when a future consideration of building a GUI
 * is considered.
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * 
 * @see TrafficMain
 * @see Graph
 * @see RoadSegment
 */
public interface Map {

  public String type = null;

  public void setType(String s);

  public String getType();

}