public class Transmission {
    public enum Type {
        Manual,     // Механічна
        Automatic   // Автоматична
    }

    final private Type type;        // Тип трансмісії
    final private int gears;        // Кількість передач

    public Transmission(Type type, int gears) {
        this.type = type;
        this.gears = gears;
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "type=" + type +
                ", gears=" + gears +
                '}';
    }
}

