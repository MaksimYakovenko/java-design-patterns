public class VehicleToAutoAdapter implements Customs {
    private final VehicleCalculator calculator;
    private final double usdToUah;

    public VehicleToAutoAdapter(VehicleCalculator calculator, double usdToUah) {
        this.calculator = calculator;
        this.usdToUah = usdToUah;
    }

    // Адаптує Auto в конкретний Vehicle, який очікує переданий калькулятор
    private Vehicle adapt(Auto a) {
        float damaged = a.damaged ? 1.0f : 0f;
        String model = a.model;
        // Якщо калькулятор спеціалізований для Car або Truck — створимо відповідний підклас,
        // інакше повернемо загальний Vehicle
        if (calculator instanceof CarCalculator) {
            return new Car(model, a.age, damaged, a.mileage);
        } else if (calculator instanceof TruckCalculator) {
            return new Truck(model, a.age, damaged, a.mileage);
        } else {
            return new Vehicle(model, a.age, damaged, a.mileage);
        }
    }

    @Override
    public float vehiclePrice(Auto a) {
        // Перетворимо Auto у відповідний Vehicle (Car/Truck/Vehicle) і використаємо калькулятор
        Vehicle v = adapt(a);
        calculator.setVehicle(v);
        double priceUsd = calculator.calculatePrice();
        return (float) (priceUsd * usdToUah);
    }

    @Override
    public float tax(Auto a) {
        // Використаємо vehiclePrice і порахуємо податок: 10% + 500 UAH
        float price = vehiclePrice(a);
        return price * 0.1f + 500f;
    }
}
