package pract_tcp_multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args)throws IOException{
        Scanner read = new Scanner(System.in);
    
        Socket socket = new Socket("localhost",9090);
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Connected to server");
        System.out.println(in.readLine());
        out.println(read.nextLine());
        System.out.println(in.readLine());
        out.println(read.nextLine()); // giving folder path
        System.out.println(in.readLine());
        out.println(read.nextLine()); // giving file name
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        out.flush();
        read.close();
        socket.close();
    }
}
