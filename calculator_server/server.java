package calculator_server;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.io.IOException;
public class server {

    public static void main(String[] args)throws IOException{
        ServerSocket serversocket = new ServerSocket(9090);
        System.out.println("Server is running and waiting for client...");
        Socket clienSocket = serversocket.accept();
        System.out.println("Client Connected");
        PrintWriter out = new PrintWriter(clienSocket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));

        String exp = in.readLine();
        String[] arr = exp.split(" ");
        int n1 = Integer.parseInt(arr[0]);
        int n2 = Integer.parseInt(arr[2]);
        String op = arr[1];

        double result = 0;
        switch (op) {
        case "+": result = n1 + n2; break;
        case "-": result = n1 - n2; break;
        case "*": result = n1 * n2; break;
        case "/": result = n1 / n2; break;
        }


        out.println(result);
        out.flush();
        serversocket.close();

    }
}
