import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight-фабрика для двигунів.
 * Повертає вже існуючий об'єкт Engine, якщо двигун з такими параметрами вже створювався.
 */
public class EngineFactory {

    private static final Map<String, Engine> cache = new HashMap<>();

    public static Engine getEngine(int power, Engine.Fuel fuel) {
        String key = power + "_" + fuel;

        if (cache.containsKey(key)) {
            System.out.println("EngineFactory: reusing existing Engine(" + power + ", " + fuel + ")");
            return cache.get(key);
        }

        System.out.println("EngineFactory: creating new Engine(" + power + ", " + fuel + ")");
        Engine engine = new Engine(power, fuel);
        cache.put(key, engine);
        return engine;
    }

    public static int getCacheSize() {
        return cache.size();
    }
}

