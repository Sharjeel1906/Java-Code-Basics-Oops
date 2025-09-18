package Threads;
public class Tables {
    public static void main(String[] args){
        MyThread1 T1 = new MyThread1();
        MyThread2 T2 = new MyThread2();
        MyThread3 T3 = new MyThread3();
        MyThread4 T4 = new MyThread4();

        try{
            new Thread(T1).start();
            Thread.sleep(2000); 
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            new Thread(T2).start();
            Thread.sleep(2000); 
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        new Thread(T3).start();
        try{
            Thread.sleep(2000); 
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        new Thread(T4).start();
     
    }
}

class MyThread1 implements Runnable{
    @Override public void run (){
        System.out.println("Table of 2");
        for(int i=1;i<11;i++){
            System.out.println("2 * "+i + "=" + (2*i));
        }
    }
}
class MyThread2 implements Runnable{
    @Override public void run (){
        System.out.println("Table of 3");
        for(int i=1;i<11;i++){
            System.out.println("3 * "+i + "=" + (3*i));
        }
    }
}
class MyThread3 implements Runnable{
    @Override public void run (){
        System.out.println("Table of 4");
        for(int i=4;i<11;i++){
            System.out.println("4 * "+i + "=" + (4*i));
        }
    }
}
class MyThread4 implements Runnable{
    @Override public void run (){
        System.out.println("Table of 5");
        for(int i=1;i<11;i++){
            System.out.println("5 * "+i + "=" + (5*i));
        }
    }
}
