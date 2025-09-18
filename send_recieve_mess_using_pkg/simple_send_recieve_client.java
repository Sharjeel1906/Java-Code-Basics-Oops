package send_recieve_mess_using_pkg;
import oops_client_server.*;
public class simple_send_recieve_client {
    public static void main(String[] args) throws Exception
    {
        oops_client_server.oop_client client = new oop_client("localhost", 9090);
        client.sender("hello world");
        System.out.println(client.reciever());
    }
}
