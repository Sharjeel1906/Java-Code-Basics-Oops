package Threads;

public class Number_printer {
    public static void main(String[] args){
        MyThread1 T1 = new MyThread1();
        MyThread2 T2 = new MyThread2();
        try{
            new Thread(T1).start();
            Thread.sleep(2000); 
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        new Thread(T2).start();

    }
}
class MyThread1 implements Runnable{

    @Override public void  run(){
            for(int i=1;i<11;i++){
                System.out.println(i);
            }
    }
}
class MyThread2 implements Runnable{

    @Override public void  run(){
            for(int i=11;i<21;i++){
                System.out.println(i);
            }
    }
}