import java.util.HashMap;
import java.util.Map;

public class ComponentManagement {
    private static Map<String, Integer> components = new HashMap<>();

    static {
        components.put("Ban", 500000);
        components.put("Oli Mesin", 250000);
        components.put("Filter Udara", 150000);
        components.put("Kampas Rem", 300000);
        components.put("Aki", 600000);
    }

    public static Map<String, Integer> getComponents() {
        return components;
    }

    public static void addComponent(String name, int price) {
        components.put(name, price);
    }
}
