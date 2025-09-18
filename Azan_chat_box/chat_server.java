package Azan_chat_box;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class chat_server {
    public static volatile boolean run = true; // Shared flag

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9090)) {
            System.out.println("Server is running and waiting for client connection...");

            while (run) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                // Start client handler threads
                new Thread(new ClientManager(clientSocket)).start();
                new Thread(new ServerManager(clientSocket)).start();

                System.out.println("Continue chat with client. Type 'quit' to exit.");
            }

            System.out.println("Server shutting down...");
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}

class ClientManager implements Runnable {
    private final Socket clientSocket;
    private final BufferedReader in;
    private final PrintWriter out;

    public ClientManager(Socket socket) throws IOException {
        this.clientSocket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Client says: " + clientMessage);
                if (clientMessage.equalsIgnoreCase("quit")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Client disconnected: " + e.getMessage());
        } finally {
            closeResources();
        }
    }

    private void closeResources() {
        try {
            out.println("quit");
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error closing client resources: " + e.getMessage());
        }
    }
}

class ServerManager implements Runnable {
    private final Socket clientSocket;
    private final PrintWriter out;
    private final Scanner scanner = new Scanner(System.in);

    public ServerManager(Socket socket) throws IOException {
        this.clientSocket = socket;
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            String serverMessage;
            while (true) {
                serverMessage = scanner.nextLine();
                out.println(serverMessage);

                if (serverMessage.equalsIgnoreCase("quit")) {
                    System.out.println("Are you sure you want to quit? (y/n)");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("y")) {
                        chat_server.run = false; // Stop main server loop
                        break;
                    } else {
                        System.out.println("Continue chatting!");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ServerManager error: " + e.getMessage());
        } finally {
            try {
                out.println("quit");
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing server resources: " + e.getMessage());
            }
        }
    }
}
