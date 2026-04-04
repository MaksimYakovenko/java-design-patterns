public class Car implements Cloneable {
    private String bodyType; // Тип кузова (седан, хетчбек, SUV, тощо)
    private Engine engine; // Двигун
    private Transmission transmission; // Трансмісія
    private Wheel wheel; // Колісний диск
    private Tire tire; // Гума
    private String color; // Колір кузова

    public Car(String bodyType, Engine engine, Transmission transmission,
               Wheel wheel, Tire tire, String color) {
        this.bodyType = bodyType;
        this.engine = engine;
        this.transmission = transmission;
        this.wheel = wheel;
        this.tire = tire;
        this.color = color;
    }

    /**
     * Глибоке клонування автомобіля разом з усіма його компонентами
     */
    @Override
    public Car clone() {
        try {
            Car cloned = (Car) super.clone();
            // Глибоке клонування всіх компонентів
            cloned.engine = this.engine != null ? this.engine.clone() : null;
            cloned.transmission = this.transmission != null ? this.transmission.clone() : null;
            cloned.wheel = this.wheel != null ? this.wheel.clone() : null;
            cloned.tire = this.tire != null ? this.tire.clone() : null;
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    /**
     * Поверхневе клонування (shallow copy) - копіюються тільки посилання на компоненти
     */
    public Car shallowClone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Car{\n  bodyType='%s',\n  color='%s',\n  engine=%s,\n  transmission=%s,\n  wheel=%s,\n  tire=%s\n}",
                bodyType, color, engine, transmission, wheel, tire
        );
    }

    // Getters
    public String getBodyType() { return bodyType; }
    public Engine getEngine() { return engine; }
    public Transmission getTransmission() { return transmission; }
    public Wheel getWheel() { return wheel; }
    public Tire getTire() { return tire; }
    public String getColor() { return color; }

    // Setters
    public void setBodyType(String bodyType) { this.bodyType = bodyType; }
    public void setEngine(Engine engine) { this.engine = engine; }
    public void setTransmission(Transmission transmission) { this.transmission = transmission; }
    public void setWheel(Wheel wheel) { this.wheel = wheel; }
    public void setTire(Tire tire) { this.tire = tire; }
    public void setColor(String color) { this.color = color; }
}

