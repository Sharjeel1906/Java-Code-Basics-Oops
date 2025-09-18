package classes.Library;

public class Users_main {
    public static void main(String[] args) {
         User u1 = new User("Sharjeel", "U1");
        u1.borrow_book("How to program");
         u1.borrow_book("CSSE 1st sem");
         u1.displayUserDetails();

        Student s1 = new Student("Ahmed", "S1");
        s1.borrow_book("hell");
        s1.borrow_book("hell");
        s1.returnBook("hell", 10);
        s1.displayUserDetails();

        Teacher t1 = new Teacher("Ali","t1");
        t1.borrow_book("tell");
        t1.displayUserDetails();
        t1.return_book("tell", 5);
    }
}
