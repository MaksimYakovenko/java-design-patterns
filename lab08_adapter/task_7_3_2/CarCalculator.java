public class CarCalculator implements VehicleCalculator {
    private Car car;

    @Override
    public void setVehicle(Vehicle v) {
        if (!(v instanceof Car)) throw new IllegalArgumentException("CarCalculator requires Car");
        this.car = (Car) v;
    }

    @Override
    public double calculatePrice() {
        if (car == null) throw new IllegalStateException("Vehicle not set");
        // Простий алгоритм: базова вартість залежить від віку, пробігу і пошкоджень
        double base = 20000; // USD
        base -= car.getAge() * 1000;
        base -= car.getMileage() * 0.05;
        base *= (1.0 - car.getDamaged());
        return Math.max(1000, base);
    }
}

