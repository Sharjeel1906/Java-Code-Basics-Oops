package Azan_chat_box;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class chat_client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9090);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to server. Type 'quit' to exit.");

            boolean chatting = true;
            while (chatting) {
                System.out.print("You (client): ");
                String message = scanner.nextLine();
                out.println(message);

                String response = in.readLine();
                if (response != null) {
                    System.out.println("Server says: " + response);
                }

                if (message.equalsIgnoreCase("quit")) {
                    System.out.println("Are you sure you want to quit? (y/n)");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("y")) {
                        chatting = false;
                        System.out.println("Chat ended.");
                    } else {
                        System.out.println("Continue chatting!");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}
