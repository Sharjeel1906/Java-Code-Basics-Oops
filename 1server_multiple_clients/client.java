import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Scanner scanner;

    public client(String host, int port) throws IOException {
        socket = new Socket(host, port);
        System.out.println("Connected to Sharjeel's server.");
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        scanner = new Scanner(System.in);
    }

    public void startChat() throws IOException {
        // Server asks for name
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
    }

    public void close() throws IOException {
        if (socket != null) socket.close();
        if (scanner != null) scanner.close();
        System.out.println("Client closed.");
    }

    public static void main(String[] args) {
        try {
            client client = new client("localhost", 9090);
            client.startChat();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}