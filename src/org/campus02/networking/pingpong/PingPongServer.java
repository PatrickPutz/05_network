package org.campus02.networking.pingpong;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class PingPongServer {

    public static void main(String[] args) {

        HashMap<String, Integer> highScore = new HashMap<>();

        System.out.println("Server erzeugen");
        try (ServerSocket serverSocket = new ServerSocket(1111)) {
            while (true) {
                System.out.println("Server wartet auf Clients...");
                Socket client = serverSocket.accept();
                System.out.println("Verbindung zu Client hergestellt");
                ClientHandler clientHandler = new ClientHandler(client, highScore);
                // clientHandler.start();

                Thread th = new Thread(clientHandler);
                th.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
