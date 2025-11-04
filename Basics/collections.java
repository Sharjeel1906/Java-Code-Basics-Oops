import java.util.HashMap;
import java.util.HashSet;

public class collections {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        map.put("Ali", 85);
        map.put("Ahmed", 90);
        map.put("Zara", 85);
        map.put("Hamza", 76);
        map.put("Sara", 95);
        map.put(null, 70);
        map.put("Areeba", 67);
        map.forEach((k,v)->{
            if(!set.contains(v)){
                set.add(v);
            }else{
                System.out.println("set already contains " + v);
            }
        });
        for(int val:set){
            System.out.println(val);
        }
    }

}
