package quit_game_server_client;
import oops_client_server.*;
public class quit_server {
     public static void main(String args[])throws Exception
     {
        System.out.println("Server is running and waiting for client connection...");
        oops_client_server.oop_server server = new oop_server();
        String messageFromClient;
        while (!(messageFromClient = server.reciver()).equals("quit")) {
            System.out.println("Client says  : "+messageFromClient);
            server.sender("Server Says: Message has been recieved from Client");
        }
        System.out.println("Client send quit Server is closing......");
        server.sender("quit");
     }
}
