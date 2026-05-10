public class CarBuilder {
    private Car.Type type;
    private Car.CarColor carColor;
    private Engine engine;
    private Transmission transmission;
    private Wheel wheel;
    private Tire tire;

    public CarBuilder setType(Car.Type type) {
        this.type = type;
        return this;
    }

    public CarBuilder setCarColor(Car.CarColor carColor) {
        this.carColor = carColor;
        return this;
    }

    public CarBuilder setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarBuilder setWheel(Wheel wheel) {
        this.wheel = wheel;
        return this;
    }

    public CarBuilder setTire(Tire tire) {
        this.tire = tire;
        return this;
    }

    public Car build() {
        return new Car(type, carColor, engine, transmission, wheel, tire);
    }
}

