package webpage_rendering;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.File;
import java.net.URL;
import java.awt.Desktop;

public class Webpage {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.coursera.org/");
            //Open the website
            InputStreamReader inputStream = new InputStreamReader(url.openStream());
            BufferedReader reader = new BufferedReader(inputStream);

            //FileWriter to save webpage content
            FileWriter writer = new FileWriter("webpage.html");

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n"); 
            }
            reader.close();
            writer.close();
            File htmlFile = new File("webpage.html");
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } else {
                System.out.println("Desktop not supported. Please open webpage.html manually.");
            }

            System.out.println("✅ Webpage saved and opened successfully!");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
