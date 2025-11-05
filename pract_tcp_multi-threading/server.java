package pract_tcp_multi;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException {
        server new_Server = new server(9090);
        new_Server.start();
    }

    ServerSocket serverSocket;

    server(int port_no) throws IOException {
        serverSocket = new ServerSocket(port_no);
        System.out.println("Shrjeel`s Server is running on port " + port_no);
    }

    public void start() throws IOException {
        System.out.println("Waiting for client to connect...");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new ClientHandler(clientSocket).start();
        }

    }

    class ClientHandler extends Thread {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;
        private Scanner read;

        ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            String name;
            int no_of_lines = 0;
            int no_of_words = 0;
            String largest = "";
            String smallest = null;
            ArrayList<String> arr = new ArrayList<>();
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Entre your name:");
                name = in.readLine();
                System.out.println(name + " connected to server");
                out.println("Entre the path of folder");
                String folder_path = in.readLine();
                out.println("Entre the file name of which you want stats");
                String file_name = in.readLine();
                File folder = new File(folder_path);
                File[] files = folder.listFiles();
                int no_of_files = files.length;
                for (File f : files) {
                    if (f.getName().equals(file_name)) {
                        File founded_file = new File(folder,f.getName());
                        Scanner file_read = new Scanner(founded_file);
                        String line;
                        while (file_read.hasNextLine()) {
                            line = file_read.nextLine();
                            no_of_lines++;
                            arr.add(line);
                        }
                        file_read.close();
                    }
                }
                for (String l : arr) {
                    String[] lineStrings = l.split(" ");
                    for (String w : lineStrings) {
                        if (w.trim().isEmpty()) continue;
                        if (w.length() > largest.length()) {
                            largest = w;
                        } else if (smallest==null||w.length() < smallest.length()) {
                            smallest = w;
                        }
                        no_of_words++;
                    }
                }
                out.println("No of files in given directory = " + no_of_files);
                out.println("No of lines in given file = " + no_of_lines);
                out.println("No of words = " + no_of_words);
                out.println("Largest word is = " + largest);
                out.println("Smallest word is = " + smallest);
                out.flush();

            } catch (Exception e) {
                
                System.out.println(e.getMessage());
            }
        }
    }
}
