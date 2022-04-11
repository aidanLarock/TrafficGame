package Server;

import java.net.*;

import Game.Game;
import Map.Graph;
import Players.Player;
import Players.PlayerFactory;

import java.io.*;

public class Server {

    // TrafficMain main = new TrafficMain();

    public static void main(String[] args) throws IOException {
        PlayerFactory pFactory = new PlayerFactory();
        Graph graph = new Graph();
        Game game = new Game();

        String menuS = "Select one hit enter to continue ||  0: Quit  ||  1: Add Player  ||  2: Continue Game  ||";
        String enter = " Hit Enter to continue";
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        System.out.println("STARTING SERVER");
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            System.out.println("Connection accepted!");
            Player playerOne = null;
            String inputLine;
            // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            out.println("Welcome To Traffic Sim");
            out.println(menuS);
            zero: while ((inputLine = in.readLine()) != null) {
                try {
                    switch (Integer.parseInt(inputLine)) {
                        case 0:
                            break zero;
                        case 1:
                            out.println("Name of player to add: ");
                            String name = in.readLine();
                            out.println(
                                    "Added Player: " + name + ". Specify type of vehicle, Bus, Car, Sports, Truck: ");
                            String type = in.readLine();
                            out.println("Vehicle Added: " + type + ". " + menuS);
                            playerOne = pFactory.getPlayer("Player", name, type);
                            game.initializeGame(graph, playerOne);
                            game.addPlayer(playerOne, 0, 1, 0);
                            System.out.println("Server added: " + name + " " + type);
                            break;

                        case 2:
                            System.out.println("Client is continuing game...");
                            game.updateTime();
                            out.println("Continuing Game..." + " Open lanes: " + playerOne.getLaneNumber()
                                    + ". Can Change lanes." + enter);
                            in.readLine();
                            out.println("Options are: " + playerOne.lanesString());
                            try {
                                int lane = Integer.parseInt(in.readLine());
                                out.println(playerOne.changeLane(lane) + enter);
                                in.readLine();
                            } catch (Exception e) {
                                out.println("Not a valid lane!" + enter);
                            }
                            if (graph.isPlayerHead(playerOne)) {
                                try {
                                    out.println("...At intersection... 0, 1 , 2");
                                    playerOne.moveIntersection(graph, Integer.parseInt(in.readLine()));
                                    out.println("Changed Intersections..." + enter);
                                    in.readLine();
                                } catch (Exception e) {
                                    out.println("Sike!, we actually can't do that" + enter);
                                    in.readLine();
                                }
                            }
                            out.println(menuS);
                            break;

                        default:
                            out.println("Exiting Game");
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("Invalid Number, back to menu " + menuS);
                }

            }
            System.out.println("Client exit");
            out.println("Good Exit");
        }

        catch (IOException e) {
            System.out.println("Could not connect to: " + portNumber);
            System.out.println(e.getMessage());
        }
    }
}