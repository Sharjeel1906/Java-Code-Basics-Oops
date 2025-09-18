package classes.Library;
import java.util.ArrayList;

public class User {

    private String name;
    private String user_id;
    protected ArrayList<String> borrowed_books = new ArrayList<>();
    protected int book_count = 0;

    public User() {
    }

    public User(String user, String id) {
        this.name = user;
        this.user_id = id;
    }

    public void borrow_book(String book_name) {
        if (book_count < 5) {
            borrowed_books.add(book_name);
            book_count++;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Sorry!! You have exceeded the borrow limit.");
        }
    }

    public void returnBook(String bookName) {
        if (borrowed_books.remove(bookName)) {
            book_count--;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found in borrowed list!");
        }
    }

    public void displayUserDetails() {
        System.out.println("User Name : " + name);
        System.out.println("User ID   : " + user_id);
        System.out.println("Number of borrowed books : " + borrowed_books.size());
        System.out.println("List of borrowed books:");
        for (int i = 0; i < borrowed_books.size(); i++) {
            System.out.println((i + 1) + ". " + borrowed_books.get(i));
        }
    }
}
class Student extends User {

    public Student(String name, String id) {
        super(name, id);
    }

    @Override
    public void borrow_book(String bookName) {
        if (borrowed_books.size() < 3) {
            borrowed_books.add(bookName);
            System.out.println("Student borrowed: " + bookName);
        } else {
            System.out.println("You have exceeded the student borrowing limit (3 books)!");
        }
    }

    public void returnBook(String bookName, int lateDays) {
        if (borrowed_books.remove(bookName)) {
            System.out.println("Book returned.");
            System.out.println("Late fine is: " + (lateDays * 10) + " Rs");
        } else {
            System.out.println("Book not found in student's borrowed list.");
        }
    }
}
class Teacher extends User{
    Teacher(String name,String id)
    {
       super(name,id);
    }
     public void borrow_book(String name){
        if(borrowed_books.size()<5){
            borrowed_books.add(name);
        }
        else{
            System.out.println("You have exceeded the teacher borrowing limit (5 books)!");
        }
     }
     public void return_book(String name,int latedays){
       if(borrowed_books.remove(name)){
        System.out.println("Book returned");
        System.out.println("Late fine is : "+(latedays*5) + "Rs");
       }else{
        System.out.println("Book not found!!");
       }
     }
}