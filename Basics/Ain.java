import java.io.File;
public class Ain {
    public static void main(String[] args){
        File folder = new File("C:\\Users\\97155\\java_projects");
        File[] files = folder.listFiles();
        if(files != null){
            for(File file:files){
                if(file.isFile()){
                    System.out.println("File : " +file.getName());
                }else if (file.isDirectory()){
                   System.out.println("Directory : " + file.getName());
                }
            }
        }else{
            System.out.println("Folder not found or Folder is empty !!");
        }
    }
}
