package send_recieve_mess_using_pkg;
import oops_client_server.*;

public class simple_send_recieve_server {
     public static void main(String args[])throws Exception
     {
        System.out.println("Server is running and waiting for client connection...");
        oops_client_server.oop_server server = new oop_server();
        System.out.println("Client says  : "+server.reciver());
        server.sender("Server Says: Message has been recieved from Client");
     }
}
