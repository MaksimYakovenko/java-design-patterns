public class Main {
    public static void main(String[] args) {
        // Приклад для Car
        Car car = new Car("Toyota Corolla", 5, 0.15f, 80000);
        CarCalculator carCalc = new CarCalculator();
        carCalc.setVehicle(car);
        double carPriceUsd = carCalc.calculatePrice();
        System.out.printf("Car price (USD): %.2f\n", carPriceUsd);

        // Використаємо адаптер для митниці
        VehicleToAutoAdapter adapter = new VehicleToAutoAdapter(carCalc, 36.5);
        Auto auto = new Auto(car.getAge(), car.getModel(), car.getDamaged() > 0.5f, car.getMileage());
        System.out.println("Auto adapted: " + auto);
        System.out.printf("Customs price (UAH): %.2f\n", (double) adapter.vehiclePrice(auto));
        System.out.printf("Customs tax (UAH): %.2f\n", (double) adapter.tax(auto));

        // Приклад для Truck
        Truck truck = new Truck("Volvo Truck", 8, 0.2f, 250000);
        TruckCalculator truckCalc = new TruckCalculator();
        truckCalc.setVehicle(truck);
        double truckPriceUsd = truckCalc.calculatePrice();
        System.out.printf("Truck price (USD): %.2f\n", truckPriceUsd);

        VehicleToAutoAdapter truckAdapter = new VehicleToAutoAdapter(truckCalc, 36.5);
        Auto truckAuto = new Auto(truck.getAge(), truck.getModel(), truck.getDamaged() > 0.5f, truck.getMileage());
        System.out.println("Auto adapted: " + truckAuto);
        System.out.printf("Customs price (UAH): %.2f\n", (double) truckAdapter.vehiclePrice(truckAuto));
        System.out.printf("Customs tax (UAH): %.2f\n", (double) truckAdapter.tax(truckAuto));
    }
}

