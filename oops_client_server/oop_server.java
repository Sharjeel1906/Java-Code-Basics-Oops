package oops_client_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class oop_server {
        ServerSocket serverSocket;
        Socket clientSocket;
        public oop_server() throws Exception
        {
                serverSocket = new ServerSocket(9090);
                clientSocket = serverSocket.accept();
                System.out.println("Client connected!");
        }

        public void sender(String message)throws Exception
        {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(message);
        }
        public String reciver()throws Exception
        {
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             String chat=in.readLine();
             return chat;
        }
}
