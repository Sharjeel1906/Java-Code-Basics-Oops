package Threads;

public class Hello_thread {
    public static void main(String[] args){
        MyThread T1 = new MyThread("Sharjeel");
        new Thread(T1).start();
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        MyThread T2 = new MyThread("Ahmed");
        new Thread(T2).start();
    }
    
}

class MyThread implements Runnable{
    String name;
    MyThread(String name){
        this.name = name;
    }
    @Override public void run(){

        for(int i=0;i<5;i++){
            System.out.println("Hello from Thread "+name);
        }
    }

}
