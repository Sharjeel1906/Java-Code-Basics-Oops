import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Smtp_client {
    public static void main(String[] args)throws IOException{
        Socket socket = new Socket("localhost",25); // add smtp server instead of localhost

        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println(in.readLine());
        out.println("HELO");//HELO
        System.out.println("Server: "+in.readLine());
        out.println("MAIL FROM:<sharjeelahmed1906@gmail.com>");// MAIL FROM
        System.out.println("Server: "+in.readLine());
        out.println("MAIL TO:<annukhan@gmail.com"); // MAIL TO
        System.out.println("Server: "+in.readLine());
        out.println("DATA");// DATA
        System.out.println("Server: "+in.readLine());
        out.println("SUBJECT: Hello world testing");//MESSAGE BODY
        out.println("Error in 1st line.");
        out.println("Need guidance");
        out.println(".");// SHOWS THAT MESSGE FINSHES
        System.out.println("Server: "+in.readLine());
        out.println("QUIT");// QUIT THE SERVER
        System.out.println("Server: "+in.readLine());
        out.flush();
        socket.close();
    }
}
