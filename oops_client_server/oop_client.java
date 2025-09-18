package oops_client_server;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class oop_client
{
    String Ip_address = "127.0.0.1";
    int port_no = 1000;
    public Socket socket;

    public oop_client(String ip,int port) throws Exception
    {
        Ip_address = ip;
        port_no = port;
        socket = new Socket(Ip_address,port_no);
    }

    public void sender(String message) throws Exception{
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(message);
    }

    public String reciever() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = in.readLine();
        return response;
    }
    // socket.close();
}
