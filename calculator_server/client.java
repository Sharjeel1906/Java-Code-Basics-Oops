package calculator_server;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.net.Socket;
public class client {
    public static void main(String[] args)throws IOException{
        Scanner read = new Scanner(System.in);
        Socket socket = new Socket("localhost", 9090);
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("Please entre the expression you want to solve");
        out.println(read.nextLine());

        System.out.println("Result : "+in.readLine());
        socket.close();
        read.close();
    }
    
}
