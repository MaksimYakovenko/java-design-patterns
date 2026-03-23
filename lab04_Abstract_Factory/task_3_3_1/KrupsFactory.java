// Concrete Factory - Krups (бюджетний сегмент)
public class KrupsFactory implements CoffeeMachineFactory {
    private static final double MACHINE_COST = 60_000;       // Найдешевша машина
    private static final double MAINTENANCE_COST = 100;      // Найдешевше обслуговування

    @Override
    public Espresso createEspresso() {
        return new Espresso(18, 45);  // Вища собівартість через нижчу ефективність
    }

    @Override
    public Americano createAmericano() {
        return new Americano(20, 50);
    }

    @Override
    public Cappuccino createCappuccino() {
        return new Cappuccino(25, 65);
    }

    @Override
    public Latte createLatte() {
        return new Latte(28, 70);
    }

    @Override
    public String getManufacturerName() {
        return "Krups";
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

