class Engine {
    private String type;
    private int horsepower;

    public Engine(String type, int horsepower) {
        this.type = type;
        this.horsepower = horsepower;
    }

    public String getType() {
        return type;
    }

    public int getHorsepower() {
        return horsepower;
    }

    @Override
    public String toString() {
        return "Engine{type='" + type + "', horsepower=" + horsepower + "}";
    }
}

class Wheel {
    private int diameter;
    private String brand;

    public Wheel(int diameter, String brand) {
        this.diameter = diameter;
        this.brand = brand;
    }

    public int getDiameter() {
        return diameter;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Wheel{diameter=" + diameter + ", brand='" + brand + "'}";
    }
}

class Car {
    private String model;
    private Engine engine;
    private Wheel[] wheels;

    public Car(String model, Engine engine, Wheel[] wheels) {
        this.model = model;
        this.engine = engine;
        this.wheels = wheels;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void displayInfo() {
        System.out.println("Car Model: " + model);
        System.out.println("Engine: " + engine);
        System.out.println("Wheels count: " + wheels.length);
        for (int i = 0; i < wheels.length; i++) {
            System.out.println("  Wheel " + (i + 1) + ": " + wheels[i]);
        }
    }
}

class CarBuilder {
    private String model;
    private Engine engine;
    private Wheel[] wheels;

    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder setEngine(String type, int horsepower) {
        this.engine = new Engine(type, horsepower);
        return this;
    }

    public CarBuilder setWheels(int diameter, String brand, int count) {
        this.wheels = new Wheel[count];
        for (int i = 0; i < count; i++) {
            this.wheels[i] = new Wheel(diameter, brand);
        }
        return this;
    }

    public Car build() {
        if (model == null || engine == null || wheels == null) {
            throw new IllegalStateException("Car is not fully configured");
        }
        return new Car(model, engine, wheels);
    }
}

class CarSimulator {
    private CarBuilder carBuilder;

    public CarSimulator() {
        this.carBuilder = new CarBuilder();
    }

    public void simulateCar() {
        System.out.println("=== Car Simulation Started ===\n");
        Car car = carBuilder
                .setModel("Tesla Model S")
                .setEngine("Electric", 670)
                .setWheels(19, "Michelin", 4)
                .build();

        System.out.println("Car created successfully!");
        car.displayInfo();

        System.out.println("\n=== Simulation Complete ===");
    }
}

public class Main {
    public static void main(String[] args) {
        CarSimulator simulator = new CarSimulator();
        simulator.simulateCar();
    }
}

