// Director - керуючий клас для побудови різних типів автомобілів
public class CarDirector {

    // Бюджетний седан для міста
    public Car constructBudgetSedan() {
        Engine engine = new EngineBuilder()
                .setPower(90)
                .setTorque(130)
                .setFuel(Engine.Fuel.Petrol)
                .setVolume(1.2f)
                .build();

        Transmission transmission = new TransmissionBuilder()
                .setType(Transmission.Type.Manual)
                .setGears(5)
                .build();

        Wheel wheel = new WheelBuilder()
                .setMaterial(Wheel.Material.Steel)
                .setDiameter(14)
                .build();

        Tire tire = new TireBuilder()
                .setSeason(Tire.Season.AllSeason)
                .setWidth(175)
                .setProfile(65)
                .setDiameter(14)
                .build();

        return new CarBuilder()
                .setType(Car.Type.Sedan)
                .setCarColor(Car.CarColor.White)
                .setEngine(engine)
                .setTransmission(transmission)
                .setWheel(wheel)
                .setTire(tire)
                .build();
    }

    // Спортивний хетчбек
    public Car constructSportHatchback() {
        Engine engine = new EngineBuilder()
                .setPower(200)
                .setTorque(280)
                .setFuel(Engine.Fuel.Petrol)
                .setVolume(2.0f)
                .build();

        Transmission transmission = new TransmissionBuilder()
                .setType(Transmission.Type.Manual)
                .setGears(6)
                .build();

        Wheel wheel = new WheelBuilder()
                .setMaterial(Wheel.Material.Alloy)
                .setDiameter(18)
                .build();

        Tire tire = new TireBuilder()
                .setSeason(Tire.Season.Summer)
                .setWidth(225)
                .setProfile(40)
                .setDiameter(18)
                .build();

        return new CarBuilder()
                .setType(Car.Type.Hatchback)
                .setCarColor(Car.CarColor.Red)
                .setEngine(engine)
                .setTransmission(transmission)
                .setWheel(wheel)
                .setTire(tire)
                .build();
    }

    // Преміум SUV
    public Car constructLuxurySUV() {
        Engine engine = new EngineBuilder()
                .setPower(249)
                .setTorque(370)
                .setFuel(Engine.Fuel.Diesel)
                .setVolume(3.0f)
                .build();

        Transmission transmission = new TransmissionBuilder()
                .setType(Transmission.Type.Automatic)
                .setGears(8)
                .build();

        Wheel wheel = new WheelBuilder()
                .setMaterial(Wheel.Material.Forged)
                .setDiameter(20)
                .build();

        Tire tire = new TireBuilder()
                .setSeason(Tire.Season.AllSeason)
                .setWidth(255)
                .setProfile(50)
                .setDiameter(20)
                .build();

        return new CarBuilder()
                .setType(Car.Type.SUV)
                .setCarColor(Car.CarColor.Black)
                .setEngine(engine)
                .setTransmission(transmission)
                .setWheel(wheel)
                .setTire(tire)
                .build();
    }

    // Електричний седан
    public Car constructElectricSedan() {
        Engine engine = new EngineBuilder()
                .setPower(150)
                .setTorque(310)
                .setFuel(Engine.Fuel.Electric)
                .setVolume(0.0f)
                .build();

        Transmission transmission = new TransmissionBuilder()
                .setType(Transmission.Type.Automatic)
                .setGears(1)
                .build();

        Wheel wheel = new WheelBuilder()
                .setMaterial(Wheel.Material.Alloy)
                .setDiameter(17)
                .build();

        Tire tire = new TireBuilder()
                .setSeason(Tire.Season.AllSeason)
                .setWidth(205)
                .setProfile(55)
                .setDiameter(17)
                .build();

        return new CarBuilder()
                .setType(Car.Type.Sedan)
                .setCarColor(Car.CarColor.Grey)
                .setEngine(engine)
                .setTransmission(transmission)
                .setWheel(wheel)
                .setTire(tire)
                .build();
    }

    // Сімейний SUV
    public Car constructFamilySUV() {
        Engine engine = new EngineBuilder()
                .setPower(140)
                .setTorque(220)
                .setFuel(Engine.Fuel.Petrol)
                .setVolume(1.8f)
                .build();

        Transmission transmission = new TransmissionBuilder()
                .setType(Transmission.Type.Automatic)
                .setGears(6)
                .build();

        Wheel wheel = new WheelBuilder()
                .setMaterial(Wheel.Material.Alloy)
                .setDiameter(17)
                .build();

        Tire tire = new TireBuilder()
                .setSeason(Tire.Season.AllSeason)
                .setWidth(215)
                .setProfile(60)
                .setDiameter(17)
                .build();

        return new CarBuilder()
                .setType(Car.Type.SUV)
                .setCarColor(Car.CarColor.Grey)
                .setEngine(engine)
                .setTransmission(transmission)
                .setWheel(wheel)
                .setTire(tire)
                .build();
    }
}

