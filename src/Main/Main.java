package Main;

import GUI.Display;
import Game.Game;
import Map.Graph;
import Map.Map;
import Players.Player;
import Vehicle.SportsCar;

/**
 * This is the Main class of the game. This class will combine
 * the game mechanics with the GUI. It will provide update
 * functions for GUI with the the according vehicle posistions
 * and corresponding images.
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * @version 2 Feb 2022
 * @see Main
 * @see Game
 * @see Map
 * @see GUI
 */
public class Main {

  private Game game;

  private Display gui;

  private Game vehicle;

  private Map map;

  Main() {

  }

  /**
   * Main driver function that runs the game and applies
   * the updates the GUI.
   * 
   * @param game The game object to be used in the GUI.
   */
  private void run(Game game) {
  }

  /**
   * Prepares the GUI for the run function.
   * 
   * @param gui The GUI to be used.
   */
  private void initializeGui(Display gui) {
  }

  /**
   * Updates the map with current vehicles, posistions
   * and etc.
   * 
   * @param map The Map to be updated.
   */
  private void updateMap(Map map) {
  }

  /**
   * Updates the vehicle to the GUI.
   * 
   * @param vehicle The game vehicle at question.
   */
  private void updateVehicleGui(Game vehicle) {
  }

  /**
   * This method is the player to game input
   * 
   * @param game The input
   */
  private void input(Game game) {
  }

  public static void main(String[] args) {
    Game game = new Game();
    SportsCar sc = new SportsCar();
    Graph graph = new Graph();

    Player madungus = new Player("Adam", sc);

    game.initializeGame(graph, sc, madungus);
    System.out.println("Add player");
    game.addPlayer(madungus, 0, 1, 0);
    // madungus.changeLane();
    // System.out.println("Changing intersection");
    // madungus.moveIntersection(graph);
    graph.updateTimeSegments();

    System.out.println("");
  }

}