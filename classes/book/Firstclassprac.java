package classes.book;
public class Firstclassprac {
    public static void main(String[] args){
        Book b1 = new Book(); // You can also add params to this obj
        System.out.println(b1.book_name);
        System.out.println(b1.book_author);
        System.out.println(b1.book_publisher); 
        System.out.println(b1.book_pages);
        System.out.println(b1.book_price);
        System.out.println(b1.get_no_of_books());   

        System.out.println("---------------------------------");

        eBook b2 = new eBook("Sample Book","Sharjeel","Gpt",200,500,"C:\\Users\\97155\\java_projects\\sample.txt");
        System.out.println(b2.book_name);
        System.out.println(b2.book_author);
        System.out.println(b2.book_publisher); 
        System.out.println(b2.book_pages);

        System.out.println(b2.book_price);
        System.out.println(b2.folder_path);
        System.out.println(b2.get_no_of_books()); 

        b2.display_console("C:\\Users\\97155\\java_projects\\sample.txt");
        b2.display_notepad("C:\\Users\\97155\\java_projects\\sample.txt");
        b2.open_diff_files("C:\\Users\\97155\\java_projects\\C++ How to Program, Paul Deitel.pdf");
    }
}
