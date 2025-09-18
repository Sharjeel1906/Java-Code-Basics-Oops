package quit_game_server_client;
import java.util.Scanner;

import oops_client_server.*;
public class quit_client {
     public static void main(String[] args) throws Exception
    {
        oops_client_server.oop_client client = new oop_client("localhost", 9090);
        Scanner read = new Scanner(System.in);
        client.sender("Lets begin the quit game");
        System.out.println("Lets begin the quit game !");
        String messageFromServer;
        while (!(messageFromServer=client.reciever()).equals("quit")) {
            String mess = read.nextLine();
            client.sender(mess);
            System.out.println(messageFromServer);
           
        }
        read.close();
    }
}
