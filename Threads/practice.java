package Threads;
class Counter{
    int count=0;
    synchronized void increment(){
        count++;
    }
}
class Thread1 extends Thread{
    String name;
    Thread1(String name){
        this.name = name;
    }
    public void run(){
        for(int i=0;i<3;i++){
            System.out.println("Thread1 is running...");
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            // yield() gives hint to CPU to switch to another thread
            Thread.yield();
        }
        System.out.println("Thread 1 Finished");
    }
}
class Thread2 extends Thread{
    String name;
    Thread2(String name){
        this.name = name;
    }
    public void run(){
        for(int i=0;i<3;i++){
            System.out.println("Thread2 is running...");
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            // yield() gives hint to CPU to switch to another thread
            Thread.yield();
        }
        System.out.println("Thread 2 Finished");
        
    }
}
class Thread3 extends Thread{
    String name;
    Counter c;
    Thread3(String name,Counter c){
        this.name=name;
        this.c = c;
    }
    public void run(){
        for(int i=0;i<1000000;i++) c.increment();
    }
}
class Thread4 extends Thread{
    String name;
    Counter c;
    Thread4(String name,Counter c){
        this.name=name;
        this.c = c;
    }
    public void run(){
        for(int i=0;i<1000000;i++) c.increment();
    }
}

// whenever thread have to use sam var or resources we use synchronization
public class practice {
    public static void main(String[] args)throws Exception{
        Thread1 t1 = new Thread1("Sharjeel");
        Thread2 t2 =new Thread2("Ali");
        // isAlive() checks whether thread is active (before starting)
        System.out.println("t1 alive before start? " + t1.isAlive());
        System.out.println("t2 alive before start? " + t2.isAlive());
        t1.start(); // using extends we can directly call .start()
        // After t1.start its run method is running in parrallel with main thread and main thread continues to next line before completeing t1
        t1.join(); // it completes t1 first and then move on to next line || It stops the main thread until t1 finshes
        t2.start(); // using impliments we have to mke new Thread and then call .start()
        // isAlive() after start will return true (threads are running)
        System.out.println("t1 alive after start? " + t1.isAlive());
        System.out.println("t2 alive after start? " + t2.isAlive());

        Counter c = new Counter();
        Thread3 t3 = new Thread3("AZAN",c);
        Thread4 t4 = new Thread4("Ahmed",c);
        t3.setDaemon(true); // Run thread in background
        t3.setPriority(Thread.MAX_PRIORITY); // Highest priorirty among all
        t3.start();
        System.out.println(t3.isDaemon()); // check is daemon or not 
        t4.start();
        
        t3.join();// first completes t3 and t4 and then move to next line
        t4.join();
        System.out.println(c.count);
    }
    
}
