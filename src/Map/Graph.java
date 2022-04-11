package Map;

import java.io.File;
import java.util.LinkedList;

import Players.Player;

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
public class Graph implements Map {

  // private static final File FILE = new File("/assets/map.txt");

  private Intersection[] intersection;

  private RoadSegment[][] road;

  private int size;
  private Parser read;

  Integer numRoads;

  Integer numInter;

  String type;

  /**
   * Constructor which loads and stores the map data.
   */
  public Graph() {
    read = new Parser();
    size = read.getLength();
    LinkedList<Integer> array = read.getTableList();

    this.road = new RoadSegment[size][size];
    this.intersection = new Intersection[size];

    for (int i = 0; i < size; i++) {
      Intersection section = new Intersection(4, 1);
      this.intersection[i] = section;
    }

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        int value = array.removeFirst();
        if (value > 0) {
          RoadSegment roadSeg = new RoadSegment(value * 2, value, j);
          roadSeg.createIntersection(this.intersection[i], this.intersection[j]);
          this.road[i][j] = roadSeg;
        }
      }
    }
  }

  /**
   * Checks if the player is at the head of a road segment.
   * 
   * @param p The player to check for.
   * @return A boolean if the player is at the head.
   */
  public boolean isPlayerHead(Player p) {
    for (int i = 0; i < road.length; i++) {
      for (int j = 0; j < road[i].length; j++) {
        if (road[i][j] != null) {
          for (int j2 = 0; j2 < road[i][j].getPlayerLanes().size(); j2++) {
            Player temp = road[i][j].getLane(j2).peek();
            if (temp != null) {
              if (temp.equals(p)) {
                System.out.println("Player is head");
                return true;
              }
            } else {
              road[i][j].getLane(j2).poll();
            }
          }
        }
      }
    }
    return false;
  }

  /**
   * Updates the player lane with nullo objects to "move forward" in the
   * player lane.
   */
  public void updateTimeSegments() {
    for (int i = 0; i < road.length; i++) {
      for (int j = 0; j < road[i].length; j++) {
        if (road[i][j] != null) {
          for (int j2 = 0; j2 < road[i][j].getPlayerLanes().size(); j2++) {
            road[i][j].addPlayer(null, j2);
          }
        }
      }
    }
  }

  /**
   * Returns the possible turns a car can make at the end of an intersection.
   * 
   * @param end The ending road segement the car is on.
   * @return a
   */
  public RoadSegment[] possibleTurns(int end) {
    int j = 0;
    RoadSegment[] t = new RoadSegment[this.road[end].length];
    for (int i = 0; i < this.road[end].length; i++) {
      RoadSegment temp = this.road[end][i];
      if (temp != null) {
        t[j] = temp;
        j++;
      }
    }
    return t;
  }

  /**
   * Gets the map that is stored in memory which is comprised of intersections and
   * road segments.
   * 
   * @return the graph in an adjacency matrix
   */
  public RoadSegment[][] getMap() {
    return this.road;
  }

  /**
   * Gets the intersections that are stored in memory
   * 
   * @return the array of intersection objects
   */
  public Intersection[] getIntersections() {
    return this.intersection;
  }

  /**
   * A getter function designed to get the road segment(s) from the
   * starting intersection and ending intersection.
   * 
   * @param start the starting intersection
   * @param end   the ending intersection
   * @return the road segment from start to end.
   */
  public RoadSegment getRoad(Intersection start, Intersection end) {
    RoadSegment theRoad = null;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (null != this.road[i][j]) {
          if (this.road[i][j].start == start && this.road[i][j].end == end) {
            theRoad = this.road[i][j];
          }
        }
      }
    }
    return theRoad;
  }

  /**
   * Sets the type of map object as a string.
   * 
   * @param s string
   */
  @Override
  public void setType(String s) {
    this.type = s;
  }

  /**
   * Returns the type of Graph as a string.
   * 
   * @return the name of type.
   */
  @Override
  public String getType() {
    return type;
  }
}