package Server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    static String host;
    static int port;

    private static String getHost() {
        try (Scanner in = new Scanner(System.in);) {
            System.out.println("Input Host IP: ");
            host = in.nextLine();
            in.close();
        } catch (Exception e) {
            System.err.println("Enter Valid Host ID");
        }
        return host;
    }

    private static int getPort() {
        try (Scanner in = new Scanner(System.in);) {
            System.out.println("Input Host IP: ");
            port = in.nextInt();
            in.close();
        } catch (Exception e) {
            System.err.println("Enter Valid Port Number");
        }
        return port;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("STARTING CLIENT");
        if (args.length != 2) {
            host = getHost();
            port = getPort();
        } else {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }

        try (Socket echoSocket = new Socket(host, port);) {
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            String serverInput;

            System.out.println(in.readLine());
            while ((serverInput = in.readLine()) != null) {
                System.out.println(serverInput);
                userInput = userIn.readLine();
                out.println(userInput);
                try {
                    if (Integer.parseInt(userInput) == 0) {
                        break;
                    }
                } catch (Exception e) {
                    // System.out.println("Exit");
                }

            }
        } catch (UnknownHostException e) {
            System.err.println("Could not connect to: " + host);
            System.exit(1);
        }
    }
}