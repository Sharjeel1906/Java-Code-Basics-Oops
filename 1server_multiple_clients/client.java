import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9090);
            System.out.println("Connected to Sharjeel's server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.println(in.readLine());
            String name = scanner.nextLine();
            out.println(name);

            String message;
            do {
                System.out.print("Enter message: ");
                message = scanner.nextLine();
                out.println(message);

                if (message.equalsIgnoreCase("quit")) {
                    break;
                }

                String response = in.readLine();
                System.out.println("Server says: " + response);
            } while (true);

            socket.close();
            scanner.close();
            System.out.println("Client closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
