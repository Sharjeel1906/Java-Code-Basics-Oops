import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Smtp_server {
    public static void main(String[] args )throws IOException{
        ServerSocket serverSocket = new ServerSocket(25);
        System.out.println("Smtp receiving server is running...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("225 Connected to smtp server");
        String line;
        while((line=in.readLine())!=null){
            System.out.println("Client :"+line);
            if(line.startsWith("HELO")){
                out.println("250 Reciver server");
            }else if(line.startsWith("MAIL FROM:")){
                out.println("250 OK");
            }else if(line.startsWith("MAIL TO:")){
                out.println("250 OK");
            }else if(line.startsWith("DATA")){
                out.println("354 starts mail input,input end with .");
            }else if(line.startsWith(".")){
                out.println("250 OK");
            }else if(line.startsWith("QUIT")){
                out.println("221 Reciever smtp server");
            }
        }
        out.flush();
        serverSocket.close();
    }
}
