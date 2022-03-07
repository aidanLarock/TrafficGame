package Main;

import java.util.Scanner;

import GUI.Display;
import Game.Game;
import Map.Graph;
import Map.Map;
import Map.Turns;
import Players.Player;
import Vehicle.SportsCar;
import Vehicle.Vehicle;

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

  private int menu(MenuText mt) {
    Scanner in = new Scanner(System.in);
    mt.displayText("0: Quit");
    mt.displayText("1: Add player");
    mt.displayText("2: Continue game");
    return in.nextInt();
  }

  /**
   * Main driver function that runs the game and applies
   * the updates the GUI.
   * 
   * @param game The game object to be used in the GUI.
   */
  private void run(Game game) {
    MenuText mt = (message) -> System.out.println(message);
    int choice = menu(mt);

    while (choice != 0) {
      switch (choice) {
        case 1:
          Scanner str = new Scanner(System.in);
          mt.displayText("Adding player...");
          mt.displayText("Name of player to add: ");

          String temp = str.nextLine();
          SportsCar sc = new SportsCar();
          player = new Player(temp, sc);

          mt.displayText("Player added: " + temp);
          game.initializeGame(graph, sc, player);
          game.addPlayer(player, 0, 1, 1);
          choice = 3;
          break;

        case 2:
          mt.displayText("Continuing game...");
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
              mt.displayText("Sike!, we actually can't do that");
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
      choice = menu(mt);
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
   * Interface for MenuText Lambda Expression
   * Prints text to the console
   */
  interface MenuText {
    void displayText(String message);
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
    new Main();
  }

}