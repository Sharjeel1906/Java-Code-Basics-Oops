package lambda_anonymas;

@FunctionalInterface
interface A {
    void show();
}
interface B{
    void display(int i);
}
interface C {
    void show(int i,int j);
}
interface Product{
    double product(double i,double j);
}
// lmbda func is only applicable to functional interface(in which only one function is avaiable)
public class lambda_func { // -> lambda symbol
    public static void main(String[] args){
    //     A obj  = new A() {
    //     public void show(){
    //         System.out.println("Hello world");
    //     }
    // };
    A obj1 = ()-> System.out.println("Hello world");
    obj1.show();
    B obj2 = i -> System.out.println("Hello world "+ i);
    obj2.display(5);
    C obj3 = (i,j)->{
        System.out.println("Hello World " + (i+j));
    };
    obj3.show(10, -2);
   // Traditional way
    Product obj4 = new Product() {
        public double product(double i,double j ){
            return i*j;
        }
    };
    System.out.println(obj4.product(24, 87));
    // Lambda func
    Product obj5 = (i,j)->i*j;
    System.out.println(obj5.product(299, 87));
    
    // Built in interface usage
    Runnable task = ()->System.out.println("Running in a thread");
    task.run();
    new Thread(task).start();
    }
    
}
