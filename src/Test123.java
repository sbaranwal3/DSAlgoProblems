import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Test123 {
    public static void main(String[]args) {
        Map locMap = new ConcurrentHashMap<String, AtomicInteger>();
        locMap.put("a", new AtomicInteger(1));
        if (locMap.containsKey("a")) {
            locMap.put("a", locMap.get("a"));
            System.out.println(locMap.get("a"));
        }
    }
}
