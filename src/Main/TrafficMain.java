package Main;

import java.util.Scanner;

import GUI.Display;
import Game.Game;
import Map.Graph;
import Map.Map;
import Players.*;

/**
 * This is the Main class of the game. This class will combine
 * the game mechanics with the GUI. It will provide update
 * functions for GUI with the the according vehicle posistions
 * and corresponding images.
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * @version 2 Feb 2022
 * @see Game
 * @see Map
 * @see GUI
 */
public class TrafficMain {

  private Game game;

  private Display gui;

  private Graph graph;

  private Player player;

  private static TrafficMain instance = new TrafficMain();

  public static TrafficMain getInstance() {
    return instance;
  }

  public TrafficMain() {
    game = new Game();
    graph = new Graph();
  }

  /**
   * Main menu for the game
   * 
   * @return selection choice of user
   */
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
  public void run() {
    PlayerFactory pFactory = new PlayerFactory();
    int choice = menu();

    while (choice != 0) {
      switch (choice) {
        case 1:
          Scanner str = new Scanner(System.in);
          System.out.println("Adding player...");
          System.out.println("Name of player to add: ");

          String temp = str.nextLine();

          Player playerOne = pFactory.getPlayer("Player", "Adam", "Sports");

          System.out.println("Player added: " + temp);
          game.initializeGame(graph, playerOne);
          game.addPlayer(playerOne, 0, 1, 1);
          choice = 3;
          // str.close();
          break;

        case 2:
          System.out.println("Continuing game...");
          game.updateTime();
          System.out.println("Open lanes: " + player.getLaneNumber());
          System.out.println("Lane to Change to: ");
          player.changeLane(34);

          if (graph.isPlayerHead(player)) {
            try {
              System.out.println("...At intersection...");
              player.moveIntersection(graph, 4);
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
}