package client_server_simple;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws IOException {
        Scanner read = new Scanner(System.in);

        Socket socket = new Socket("localhost", 9090);
        // Setup output stream to send data to the server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // Setup input stream to receive data from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Quit
        System.out.println("Continue chat with Server. Entre quit to Exit !! ");
        String message;
        while (true) {
            // Client sends message
            System.out.print("You (client): ");
            message = read.nextLine();
            out.println(message);

            if (message.equalsIgnoreCase("quit")) {
                System.out.println("Chat ended.");
                break;
            }
        }
        // Files names
        System.out.println("Entre the path of which you want to know files names!!");
        out.println(read.nextLine());

        String line;
        System.out.println("Files from server:");

        while (!(line = in.readLine()).equals("EOF")) {
            System.out.println(line);
        }

        // Get file_content
        System.out.println("Entre the path of which you want file content : ");
        out.println(read.nextLine());

        System.out.println("Entre the name of file: ");
        out.println(read.nextLine());

        String content;
        while (!(content = in.readLine()).equals("EOF")) {
            System.out.println(content);
        }
        System.out.println("File data has been displayed!!");
        System.out.println();
        System.out.println();

        // Get file content from current directory
        String path = System.getProperty("user.dir");
        System.out.println("Your current dir is :" + path);
        out.println(path);
        System.out.println();
        System.out.println("Your files in current directory are : ");
        String file;
        while (!(file = in.readLine()).equals("EOF")) {
            System.out.println(file);
        }
        System.out.println();
         System.out.println("All Above files are in your current Directory!!");
         System.out.println();

        System.out.println("Copy and paste  File path  you want to read !!");
        System.out.println();
        out.println(read.nextLine());
        String file_content;
        while (!(file_content = in.readLine()).equals("EOF")) {
            System.out.println(file_content);
        }

        socket.close();
        read.close();
    }
}
