import java.util.HashMap;
import java.util.Map;

/**
 * Реєстр прототипів автомобілів
 * Зберігає типові конфігурації автомобілів для швидкого клонування
 */
public class CarRegistry {
    private Map<String, Car> prototypes = new HashMap<>();

    /**
     * Додає прототип до реєстру
     */
    public void addPrototype(String key, Car prototype) {
        prototypes.put(key, prototype);
    }

    /**
     * Отримує клон прототипу за ключем
     */
    public Car getPrototype(String key) {
        Car prototype = prototypes.get(key);
        return prototype != null ? prototype.clone() : null;
    }

    /**
     * Перевіряє наявність прототипу
     */
    public boolean hasPrototype(String key) {
        return prototypes.containsKey(key);
    }

    /**
     * Видаляє прототип з реєстру
     */
    public void removePrototype(String key) {
        prototypes.remove(key);
    }

    /**
     * Отримує всі доступні ключі прототипів
     */
    public void listPrototypes() {
        System.out.println("Доступні прототипи автомобілів:");
        for (String key : prototypes.keySet()) {
            System.out.println("  - " + key);
        }
    }
}

