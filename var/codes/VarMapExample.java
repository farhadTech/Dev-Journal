import java.util.HashMap;

public class VarMapExample {
    public static void main(String[] args) {
        var map = new HashMap<String, Integer>();
        map.put("Alice", 25);
        map.put("Bob", 30);

        for(var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
