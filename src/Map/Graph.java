package Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

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
public class Graph {

  private static final File FILE = new File("assets/map.txt");

  private Intersection[] intersection;

  private RoadSegment[][] road;

  private int sizeX;

  private int sizeY;

  Integer numRoads;

  Integer numInter;

  public RoadSegment[] possibleTurns(int end) {
    int j = 0;
    RoadSegment[] t = new RoadSegment[3];
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
   * Loads and stores the adjacency matrix used for the graph.
   * 
   */
  public void loadMap() {
    try {
      File map = FILE;
      Scanner myReader = new Scanner(map);
      sizeX = myReader.nextInt();
      sizeY = myReader.nextInt();
      this.road = new RoadSegment[sizeX][sizeY];
      this.intersection = new Intersection[sizeX];
      for (int i = 0; i < sizeX; i++) {
        Intersection section = new Intersection(4, 1);
        this.intersection[i] = section;
      }
      for (int i = 0; i < sizeX; i++) {
        for (int j = 0; j < sizeY; j++) {
          int value = myReader.nextInt();
          if (value > 0) {
            RoadSegment roadSeg = new RoadSegment(value * 2, value, j);
            roadSeg.createIntersection(this.intersection[i], this.intersection[j]);
            this.road[i][j] = roadSeg;
          }
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Couldnt Load File.");
      e.printStackTrace();
    }
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
    for (int i = 0; i < this.sizeX; i++) {
      for (int j = 0; j < this.sizeY; j++) {
        if (null != this.road[i][j]) {
          if (this.road[i][j].start == start && this.road[i][j].end == end) {
            theRoad = this.road[i][j];
          }
        }
      }
    }
    try {
      return theRoad;
    } catch (Exception e) {
      return null;
    }
  }

  public void changeRoad(Player p, RoadSegment road) {

  }

}