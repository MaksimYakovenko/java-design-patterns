public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрація шаблону Builder ===\n");

        // Створення автомобілів через Director
        CarDirector director = new CarDirector();

        System.out.println("1. Бюджетний седан:");
        Car budgetSedan = director.constructBudgetSedan();
        System.out.println(budgetSedan);

        System.out.println("2. Спортивний хетчбек:");
        Car sportHatchback = director.constructSportHatchback();
        System.out.println(sportHatchback);

        System.out.println("3. Преміум SUV:");
        Car luxurySUV = director.constructLuxurySUV();
        System.out.println(luxurySUV);

        System.out.println("4. Електричний седан:");
        Car electricSedan = director.constructElectricSedan();
        System.out.println(electricSedan);

        System.out.println("5. Сімейний SUV:");
        Car familySUV = director.constructFamilySUV();
        System.out.println(familySUV);

        System.out.println("=== Ручне створення автомобіля через Builder ===\n");

        // Приклад створення автомобіля вручну без Director
        Engine customEngine = new EngineBuilder()
                .setPower(180)
                .setTorque(250)
                .setFuel(Engine.Fuel.Diesel)
                .setVolume(2.2f)
                .build();

        Transmission customTransmission = new TransmissionBuilder()
                .setType(Transmission.Type.Automatic)
                .setGears(7)
                .build();

        Wheel customWheel = new WheelBuilder()
                .setMaterial(Wheel.Material.Alloy)
                .setDiameter(19)
                .build();

        Tire customTire = new TireBuilder()
                .setSeason(Tire.Season.Winter)
                .setWidth(235)
                .setProfile(45)
                .setDiameter(19)
                .build();

        Car customCar = new CarBuilder()
                .setType(Car.Type.SUV)
                .setCarColor(Car.CarColor.White)
                .setEngine(customEngine)
                .setTransmission(customTransmission)
                .setWheel(customWheel)
                .setTire(customTire)
                .build();

        System.out.println("Кастомний SUV:");
        System.out.println(customCar);
    }
}

