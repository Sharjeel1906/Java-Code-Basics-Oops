package webpage_rendering;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.Desktop;
import java.io.FileWriter;
import java.net.URL;
import java.io.File;
public class Webpage {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.coursera.org/");
            InputStreamReader in = new InputStreamReader(url.openStream());
            BufferedReader out = new BufferedReader(in);
            FileWriter writer = new FileWriter("webpage.html");
            String line;

            while ((line = out.readLine()) != null) {
                writer.write(line);
            }
            writer.close();
            out.close();

            File html = new File("webpage.html");
            Desktop.getDesktop().browse(html.toURI());

            String  path= new File("webpage.html").getAbsolutePath();
            String command = "cmd /c start chrome \"" + path + "\"";
            Runtime.getRuntime().exec(command);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
