// Concrete Factory - Saeco (середній сегмент)
public class SaecoFactory implements CoffeeMachineFactory {
    private static final double MACHINE_COST = 100_000;      // Вартість машини
    private static final double MAINTENANCE_COST = 150;      // Обслуговування на день

    @Override
    public Espresso createEspresso() {
        return new Espresso(15, 45);  // Середня якість
    }

    @Override
    public Americano createAmericano() {
        return new Americano(18, 50);
    }

    @Override
    public Cappuccino createCappuccino() {
        return new Cappuccino(23, 65);
    }

    @Override
    public Latte createLatte() {
        return new Latte(25, 70);
    }

    @Override
    public String getManufacturerName() {
        return "Saeco";
    }

    @Override
    public double getMachineCost() {
        return MACHINE_COST;
    }

    @Override
    public double getMaintenanceCostPerDay() {
        return MAINTENANCE_COST;
    }
}

