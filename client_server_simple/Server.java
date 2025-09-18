package client_server_simple;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String args[]) throws IOException {
        boolean found = false;
        boolean Selected_file_found = false;
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server is running and waiting for client connection...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");
        // Setup input and output streams for communication with the client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Quit
        String chat;

        while ((chat = in.readLine()) != null) {
            if (chat.equals("quit")) {
                System.out.println("Client says: " + chat);
                break;
            }
            System.out.println("Client says: " + chat);
            out.println("Server_says message recieved!!");
        }

        // Files names
        String path = in.readLine();

        File folder = new File(path);
        File[] files_names = folder.listFiles();
        if (files_names != null) {
            for (File file : files_names) {
                if (file.isFile()) {
                    out.println(file.getName());
                } else if (file.isDirectory()) {
                    out.println(file.getName());
                }
            }
            System.out.println("Files names sended !");
            out.println("EOF");
        } else {
            System.out.println("Folder not found or incorrect path");
        }

        // // Get file_content

        String dir = in.readLine();
        System.out.println("Directory: " + dir);

        String file_name = in.readLine();
        System.out.println("File : " + file_name);

        File file_list = new File(dir);
        File[] files = file_list.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && (file.getName().equals(file_name))) {
                    found = true;
                    File myFile = new File(file.getPath());
                    Scanner read = new Scanner(myFile);
                    while (read.hasNextLine()) {
                        out.println(read.nextLine());
                    }
                    read.close();
                    out.println("EOF");
                    out.flush();
                }
            }
            if (found) {
                System.out.println("File founded and data has been sent to client!!");
            } else {
                System.out.println("File not found or wrong file name/dir!!");
            }
        }

        // Get file content from current directory
        String path_curr = in.readLine();
        System.out.println("Current Directory : " + path_curr);
        File curr_file_folder = new File(path_curr);
        File[] current_files_list = curr_file_folder.listFiles();
        if (current_files_list != null) {
            for (File curr_file : current_files_list) {
                if (curr_file.isFile()) {
                    out.println(curr_file);
                }
            }
            out.println("EOF");
            System.out.println("Files name displayed!!");
        }

        String File_path = in.readLine();
        System.out.println("Selected file:" + File_path);

        File sel_file = new File(File_path);
        Scanner read_sel_file = new Scanner(sel_file);

        while (read_sel_file.hasNextLine()) {
            Selected_file_found = true;
            out.println(read_sel_file.nextLine());
        }
        out.println("EOF");
        if (Selected_file_found) {
            System.out.println("File founded and data has been sent !");
        } else {
            System.out.println("File not found or incorrect path!");
        }
        read_sel_file.close();

        clientSocket.close();
        serverSocket.close();
    }
}
