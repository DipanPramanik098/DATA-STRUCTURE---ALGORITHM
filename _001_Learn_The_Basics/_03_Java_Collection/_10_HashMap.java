import java.util.HashMap;
import java.util.Map;

public class _10_HashMap {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        // put(K,V)
        map.put("Apple", 10);
        map.put("Banana", 20);

        // get(K)
        System.out.println(map.get("Apple"));

        // containsKey()
        System.out.println(map.containsKey("Banana"));

        // containsValue()
        System.out.println(map.containsValue(10));

        // remove()
        map.remove("Banana");

        // keySet()
        for(String key : map.keySet()) {
            System.out.println(key);
        }

        // values()
        for(Integer value : map.values()) {
            System.out.println(value);
        }

        // entrySet()
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // size()
        System.out.println(map.size());

        // clear()
        // map.clear();
    }
}
