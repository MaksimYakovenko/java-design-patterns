public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрація шаблону Прототип для автомобілів ===\n");

        // Створюємо реєстр прототипів
        CarRegistry registry = new CarRegistry();

        // Створюємо базові прототипи автомобілів
        createBasicPrototypes(registry);

        // Демонстрація 1: Клонування базового прототипу
        System.out.println("--- Демонстрація 1: Клонування базового прототипу ---");
        demonstrateBasicCloning(registry);

        // Демонстрація 2: Глибоке vs поверхневе клонування
        System.out.println("\n--- Демонстрація 2: Глибоке vs поверхневе клонування ---");
        demonstrateDeepVsShallowCloning();

        // Демонстрація 3: Модифікація клонованих об'єктів
        System.out.println("\n--- Демонстрація 3: Модифікація клонованих об'єктів ---");
        demonstrateModification(registry);

        // Демонстрація 4: Створення модельного ряду
        System.out.println("\n--- Демонстрація 4: Створення модельного ряду ---");
        demonstrateModelRange(registry);
    }

    /**
     * Створює базові прототипи автомобілів в реєстрі
     */
    private static void createBasicPrototypes(CarRegistry registry) {
        // Економ-седан
        Engine economyEngine = new Engine(110, 1.6, 150, "бензин");
        Transmission manualTransmission = new Transmission("механічна", 5);
        Wheel steelWheel = new Wheel("сталь", 15);
        Tire budgetTire = new Tire("Continental", "всесезонна", "195/65R15");
        Car economySedan = new Car("седан", economyEngine, manualTransmission,
                                   steelWheel, budgetTire, "білий");
        registry.addPrototype("economy-sedan", economySedan);

        // Спортивний хетчбек
        Engine sportEngine = new Engine(200, 2.0, 280, "бензин");
        Transmission autoTransmission = new Transmission("автоматична", 6);
        Wheel alloyWheel = new Wheel("легкосплавний", 18);
        Tire sportTire = new Tire("Michelin", "літня", "225/40R18");
        Car sportHatchback = new Car("хетчбек", sportEngine, autoTransmission,
                                     alloyWheel, sportTire, "червоний");
        registry.addPrototype("sport-hatchback", sportHatchback);

        // Преміум SUV
        Engine premiumEngine = new Engine(300, 3.0, 450, "дизель");
        Transmission premiumTransmission = new Transmission("автоматична", 8);
        Wheel premiumWheel = new Wheel("легкосплавний", 20);
        Tire premiumTire = new Tire("Pirelli", "всесезонна", "255/50R20");
        Car premiumSUV = new Car("SUV", premiumEngine, premiumTransmission,
                                premiumWheel, premiumTire, "чорний");
        registry.addPrototype("premium-suv", premiumSUV);

        // Електромобіль
        Engine electricEngine = new Engine(150, 0, 310, "електро");
        Transmission electricTransmission = new Transmission("автоматична", 1);
        Wheel electricWheel = new Wheel("легкосплавний", 17);
        Tire electricTire = new Tire("Bridgestone", "всесезонна", "215/50R17");
        Car electricCar = new Car("хетчбек", electricEngine, electricTransmission,
                                 electricWheel, electricTire, "синій");
        registry.addPrototype("electric-hatchback", electricCar);

        System.out.println("Створено базові прототипи автомобілів:");
        registry.listPrototypes();
        System.out.println();
    }

    /**
     * Демонструє базове клонування прототипу
     */
    private static void demonstrateBasicCloning(CarRegistry registry) {
        // Клонуємо економ-седан
        Car car1 = registry.getPrototype("economy-sedan");
        Car car2 = registry.getPrototype("economy-sedan");

        System.out.println("Оригінальний прототип:");
        System.out.println(car1);

        System.out.println("\nКлонований автомобіль:");
        System.out.println(car2);

        System.out.println("\nПеревірка: це різні об'єкти? " + (car1 != car2));
        System.out.println("Але з однаковими характеристиками? " +
                         (car1.getBodyType().equals(car2.getBodyType()) &&
                          car1.getColor().equals(car2.getColor())));
    }

    /**
     * Демонструє різницю між глибоким та поверхневим клонуванням
     */
    private static void demonstrateDeepVsShallowCloning() {
        // Створюємо оригінальний автомобіль
        Engine engine = new Engine(150, 2.0, 200, "бензин");
        Transmission transmission = new Transmission("механічна", 6);
        Wheel wheel = new Wheel("легкосплавний", 16);
        Tire tire = new Tire("Nokian", "зимова", "205/55R16");
        Car original = new Car("седан", engine, transmission, wheel, tire, "сірий");

        // Глибоке клонування
        Car deepClone = original.clone();
        // Поверхневе клонування
        Car shallowClone = original.shallowClone();

        System.out.println("Оригінальний автомобіль:");
        System.out.println(original);

        // Змінюємо характеристики двигуна в оригіналі
        original.getEngine().setPower(180);
        original.setColor("зелений");

        System.out.println("\nПісля зміни оригіналу (потужність двигуна: 180, колір: зелений):");

        System.out.println("\nГлибоке клонування (незалежне):");
        System.out.println(deepClone);
        System.out.println("Потужність двигуна глибокого клону: " + deepClone.getEngine().getPower() + " к.с.");

        System.out.println("\nПоверхневе клонування (залежне від оригіналу):");
        System.out.println(shallowClone);
        System.out.println("Потужність двигуна поверхневого клону: " + shallowClone.getEngine().getPower() + " к.с.");
        System.out.println("Колір поверхневого клону: " + shallowClone.getColor());
    }

    /**
     * Демонструє модифікацію клонованих об'єктів
     */
    private static void demonstrateModification(CarRegistry registry) {
        // Беремо базовий прототип спортивного хетчбека
        Car baseCar = registry.getPrototype("sport-hatchback");

        // Створюємо кастомізовану версію
        Car customCar = baseCar.clone();
        customCar.setColor("жовтий");
        customCar.getEngine().setPower(250); // Тюнінг двигуна
        customCar.setWheel(new Wheel("легкосплавний", 19)); // Більші диски

        System.out.println("Базова модель:");
        System.out.println(baseCar);

        System.out.println("\nКастомізована версія:");
        System.out.println(customCar);

        System.out.println("\nБазова модель залишилась незмінною!");
    }

    /**
     * Демонструє створення модельного ряду з одного прототипу
     */
    private static void demonstrateModelRange(CarRegistry registry) {
        // Базова модель SUV
        Car baseSUV = registry.getPrototype("premium-suv");

        // Створюємо різні комплектації
        System.out.println("Модельний ряд SUV:\n");

        // Базова комплектація
        Car basicVersion = baseSUV.clone();
        basicVersion.setColor("сірий");
        basicVersion.getEngine().setPower(250);
        basicVersion.setWheel(new Wheel("легкосплавний", 18));
        System.out.println("1. Базова комплектація:");
        System.out.println(basicVersion);

        // Комфорт комплектація
        Car comfortVersion = baseSUV.clone();
        comfortVersion.setColor("білий");
        comfortVersion.getTransmission().setGearCount(9);
        System.out.println("\n2. Комфорт комплектація:");
        System.out.println(comfortVersion);

        // Топова комплектація
        Car topVersion = baseSUV.clone();
        topVersion.setColor("чорний металік");
        topVersion.getEngine().setPower(350);
        topVersion.setWheel(new Wheel("легкосплавний", 21));
        topVersion.setTire(new Tire("Pirelli P Zero", "літня", "275/45R21"));
        System.out.println("\n3. Топова комплектація:");
        System.out.println(topVersion);

        System.out.println("\nВсі три автомобілі створені на базі одного прототипу!");
    }
}

