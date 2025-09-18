import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
public class File_io {
    public static void main(String []args){
        try{

        FileWriter writer = new FileWriter("output.txt");
        writer.write("hello world");
        writer.close();
File myfile = new File("        C:\\Users\\97155\\java_projects\\output.txt");
        Scanner read = new Scanner(myfile);
        read.close();
    }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        }
    }

