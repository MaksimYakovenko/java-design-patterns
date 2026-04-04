import java.util.HashMap;
import java.util.Map;

// Реєстр прототипів рівнянь
public class EquationRegistry {
    private Map<String, EquationPrototype> prototypes = new HashMap<>();

    // Реєстрація нового прототипу
    public void registerPrototype(String key, EquationPrototype prototype) {
        prototypes.put(key, prototype);
    }

    // Отримання клону зареєстрованого прототипу
    public EquationPrototype getPrototype(String key) {
        EquationPrototype prototype = prototypes.get(key);
        if (prototype != null) {
            return prototype.clone();
        }
        return null;
    }

    // Видалення прототипу з реєстру
    public void unregisterPrototype(String key) {
        prototypes.remove(key);
    }

    // Перевірка наявності прототипу
    public boolean hasPrototype(String key) {
        return prototypes.containsKey(key);
    }

    // Отримання списку зареєстрованих ключів
    public void listPrototypes() {
        System.out.println("Зареєстровані прототипи:");
        for (String key : prototypes.keySet()) {
            EquationPrototype prototype = prototypes.get(key);
            System.out.println("  - " + key + ": " + prototype.getClass().getSimpleName());
        }
    }
}

