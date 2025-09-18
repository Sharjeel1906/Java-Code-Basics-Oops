package classes.book;
import java.io.File;
import java.util.Scanner;
import java.awt.Desktop;
class Book {
   
    private static int number_of_books=0;
    
    public Book(){
        number_of_books+=1;
    }

    public Book(String book_name,String book_author,String book_publisher,double book_pages,double book_price){
        number_of_books+=1;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_publisher = book_publisher;
        this.book_pages = book_pages;
        this.book_price = book_price;
    }
    // If you want less parms then use this 
    public Book(String book_name,String book_author,String book_publisher,double book_pages){
        this(book_name,book_author,book_publisher,book_pages,0);
    }


    public String book_name = "Concepts of Java";
    public String book_author = "Paul Dietel";
    public String book_publisher = "Pakistan Publishers";
    public double book_price  = 500;
    public double book_pages = 1000;
    
   

    int get_no_of_books(){
        return number_of_books;
    }
}
class eBook extends Book {
     public eBook(){};

     public String folder_path = "";

     public eBook(String e_book_name,String e_book_author, String e_book_publisher,double e_book_no_of_pages,double e_book_price,String e_folder_path){
        super(e_book_name,e_book_author,e_book_publisher,e_book_no_of_pages,e_book_price);
        folder_path = e_folder_path;
     }

     public  void display_console(String path){
        String file_path = path;
        try{
            File myfile = new File(file_path);
            Scanner read = new Scanner(myfile);
            while (read.hasNextLine()){
                String data = read.nextLine();
                System.out.println(data);
            }
            read.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
     }
     public void display_notepad(String path){
        String file_path = "notepad "+path;
        try{
            Runtime.getRuntime().exec(file_path);
            //Process proc = run.exec(file_path);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
     }

     public void open_diff_files(String path){
            try {
            File file = new File(path);
            if (file.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("File not found or Desktop not supported.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

     }
    
}
