import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight-фабрика для коліс.
 * Повертає вже існуючий об'єкт Wheel, якщо колесо з такими параметрами вже створювалось.
 */
public class WheelFactory {

    private static final Map<String, Wheel> cache = new HashMap<>();

    public static Wheel getWheel(int diameter) {
        String key = diameter + "_" + Wheel.Material.Steel;

        if (cache.containsKey(key)) {
            System.out.println("WheelFactory: reusing existing Wheel(" + diameter + ")");
            return cache.get(key);
        }

        System.out.println("WheelFactory: creating new Wheel(" + diameter + ")");
        Wheel wheel = new Wheel(diameter);
        cache.put(key, wheel);
        return wheel;
    }

    public static int getCacheSize() {
        return cache.size();
    }
}

