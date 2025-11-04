package webpage_rendering;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.File;
import java.awt.Desktop;
import java.util.Scanner;
import java.net.URL;
public class pract {
    public static void main(String[] args){
        String input;
        int no_of_line=0;
        Scanner read = new Scanner(System.in);
        System.out.println("Entre the Url : ");
        input  = read.nextLine();
        try{
            URL url = new URL(input);
            InputStreamReader in = new InputStreamReader(url.openStream());
            BufferedReader out  = new BufferedReader(in);
            FileWriter file = new FileWriter("download.html");
            String line;
            while((line = out.readLine())!=null){
                no_of_line++;
                file.write(line+"\n");
            }
            File htmFile = new File("download.html");
            if(Desktop.isDesktopSupported()){
                Desktop.getDesktop().browse(htmFile.toURI());;
            }
            read.close();
            file.close();
            System.out.println(no_of_line);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
