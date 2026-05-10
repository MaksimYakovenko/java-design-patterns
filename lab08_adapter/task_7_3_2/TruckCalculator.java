public class TruckCalculator implements VehicleCalculator {
    private Truck truck;

    @Override
    public void setVehicle(Vehicle v) {
        if (!(v instanceof Truck)) throw new IllegalArgumentException("TruckCalculator requires Truck");
        this.truck = (Truck) v;
    }

    @Override
    public double calculatePrice() {
        if (truck == null) throw new IllegalStateException("Vehicle not set");
        double base = 40000;
        base -= truck.getAge() * 2000;
        base -= truck.getMileage() * 0.1;
        base *= (1.0 - truck.getDamaged());
        return Math.max(5000, base);
    }
}

