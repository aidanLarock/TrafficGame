package Main;

import java.util.Scanner;

import GUI.Display;
import Game.Game;
import Map.Graph;
import Map.Map;
import Players.*;
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

  private Graph graph;

  private Player player;

  Main() {

    game = new Game();
    graph = new Graph();

    run(game);
    System.out.println("");
  }

  private int menu() {
    Scanner in = new Scanner(System.in);
    System.out.println("0: Quit");
    System.out.println("1: Add player");
    System.out.println("2: Continue game");
    return in.nextInt();
  }

  /**
   * Main driver function that runs the game and applies
   * the updates the GUI.
   * 
   * @param game The game object to be used in the GUI.
   */
  private void run(Game game) {
    int choice = menu();

    while (choice != 0) {
      switch (choice) {
        case 1:
          Scanner str = new Scanner(System.in);
          System.out.println("Adding player...");
          System.out.println("Name of player to add: ");

          String temp = str.nextLine();
          SportsCar sc = new SportsCar();
          player = new Player(temp, sc);

          System.out.println("Player added: " + temp);
          game.initializeGame(graph, sc, player);
          game.addPlayer(player, 0, 1, 1);
          choice = 3;
          // str.close();
          break;

        case 2:
          System.out.println("Continuing game...");
          game.updateTime();
          System.out.println("Open lanes: " + player.getLaneNumber());
          System.out.println("Change lanes?");
          player.changeLane();

          if (graph.isPlayerHead(player)) {
            try {
              System.out.println("...At intersection...");
              player.moveIntersection(graph);
              System.out.println("Changed Intersections...");
            } catch (Exception e) {
              System.out.println("Sike!, we actually can't do that");
            }
          }
          choice = 3;
          break;
        default:
          break;
      }
      System.out.println("");
      System.out.println("");
      System.out.println("");
      System.out.println("");
      choice = menu();
    }
    System.out.println("Succesfully quit!");

  }

  /**
   * Prepares the GUI for the run function.
   * 
   * @param gui The GUI to be used.
   * @apiNote Used for future versions.
   */
  private void initializeGui(Display gui) {
  }

  /**
   * Updates the vehicle to the GUI.
   * 
   * @param vehicle The game vehicle at question.
   * @apiNote Used for future versions.
   */
  private void updateVehicleGui(Game vehicle) {
  }

  public static void main(String[] args) {
    Main m = new Main();
  }

}