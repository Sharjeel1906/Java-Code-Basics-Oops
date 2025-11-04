package classes;

import java.util.ArrayList;

class Gadget{
    protected String brand;
    private static int gadget_count=0;
    Gadget(String brand){
        gadget_count++;
        this.brand = brand;
    }
    public void turnon(){
        System.out.println("The gadget is turning on ....");
    }
    public static void show_no_of_gadgets(){
        System.out.println("No of gadgets = "+gadget_count);
    }
}
class Laptop extends Gadget{
    String processor;
    String ram;
    Laptop(String brand,String processor ,String ram){
        super(brand);
        this.processor = processor;
        this.ram = ram;
    }
    public void turnon(){
        System.out.println("Laptop booting with "+processor);
    }
    void compileCode() {
    System.out.println(brand + " Laptop is compiling Java code...");
    }
    public static void show_no_of_gadgets(){
        System.out.println("Laptop cannot be tracked indvidually");
    }
}
class MobilePhone extends Gadget{
    String sim;
    String storage;
    MobilePhone(String brand,String sim,String storage){
        super(brand);
        this.sim = sim;
        this.storage= storage;
    }
    public void turnon(){
        super.turnon();
        System.out.println("Smartphone unlocking with fingerprint…");
    }
    public void take_photo(){
        System.out.println("Taking photo....");
    }
}
class SmartWatch extends Gadget{
    private String heartRateSensor;
    SmartWatch(String brand){
        super(brand);
    }
    public void turnon(){
        System.out.println("SmartWatch syncing data…");
    }
    public void tracksteps(){
        System.out.println("Tracking Steps....");
    }
}
abstract class SmartDevices {
    private int deviceid;
    private String devicename;
    private boolean is_on;
    public void setter(int id,String name,boolean on){
        deviceid = id;
        devicename = name;
        is_on = on;
    }
    public void getter(){
        System.out.println("Device Id : "+deviceid);
        System.out.println("Device Name :  "+devicename);
        System.out.println("Is on : "+is_on);
    }
    abstract void performFunction();
    public void togglePower(){
        is_on = !is_on;
    }
    
}
interface Adjustable{
    void increaseSetting();
    void decreaseSetting();
}
class Light extends SmartDevices implements Adjustable{
    int brightness = 56;
    public void performFunction(){
        System.out.println("Light is glowing with "+brightness+" % brightness");
    }
    public void increaseSetting(){
        brightness +=10;
    }
    public void decreaseSetting(){
        brightness-=10;
    }
    
}
class Fans extends SmartDevices implements Adjustable{
    public int speed_level= 4;
    public void performFunction(){
        System.out.println("Fan is running at "+speed_level+" speed");
    }
    public void increaseSetting(){
        speed_level++;
    }
    public void decreaseSetting(){
        speed_level--;
    }
}
public class practice {
    public static void main(String[] args){
        ArrayList<SmartDevices> arr = new ArrayList<>();
        Light l = new Light();
        Fans f = new Fans();
        arr.add(f);
        arr.add(l);
        l.performFunction();
        f.performFunction();
        l.increaseSetting();
        f.decreaseSetting();
        l.performFunction();
        f.performFunction();

        // ArrayList<Gadget> array = new ArrayList<>();
        // Gadget g = new Gadget("Lenovo");
        // Laptop l = new Laptop("Dell", "Intel i7", "16 GB");
        // SmartWatch w = new SmartWatch("Apple");
        // MobilePhone m = new MobilePhone("Vivo", "Zong", "128 GB");
        // array.add(m);
        // array.add(g);
        // array.add(l);
        // array.add(w);
        // g.turnon();
        // l.turnon();
        // w.turnon();
        // m.turnon();
        // System.out.println("Array Methods");
        
        // for(Gadget G:array){
        //     G.turnon();
        // }
        // System.out.println(" Show Gadgets calling");
        // g.show_no_of_gadgets();
        // l.show_no_of_gadgets();

    }
    
}
