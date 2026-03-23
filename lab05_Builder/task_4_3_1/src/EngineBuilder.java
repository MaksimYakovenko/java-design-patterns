// Builder для двигуна
public class EngineBuilder {
    private int power;
    private int torque;
    private Engine.Fuel fuel;
    private float volume;

    public EngineBuilder setPower(int power) {
        this.power = power;
        return this;
    }

    public EngineBuilder setTorque(int torque) {
        this.torque = torque;
        return this;
    }

    public EngineBuilder setFuel(Engine.Fuel fuel) {
        this.fuel = fuel;
        return this;
    }

    public EngineBuilder setVolume(float volume) {
        this.volume = volume;
        return this;
    }

    public Engine build() {
        return new Engine(power, torque, fuel, volume);
    }
}

