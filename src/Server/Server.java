package Server;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        try (
                ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
                Socket clientSocket = serverSocket.accept();

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            System.out.println("Connection accepted!");
            String inputLine, outputLine;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client said: " + inputLine);
                // out.println(inputLine);
                outputLine = reader.readLine();
                System.out.println("Server said: " + outputLine);
                out.println(outputLine);
            }
        }

        catch (IOException e) {
            System.out.println(
                    "Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}