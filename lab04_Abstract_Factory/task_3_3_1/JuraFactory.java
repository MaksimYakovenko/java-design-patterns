// Concrete Factory - Jura (преміум + сегмент)
public class JuraFactory implements CoffeeMachineFactory {
    private static final double MACHINE_COST = 200_000;      // Найдорожча машина
    private static final double MAINTENANCE_COST = 250;      // Найдорожче обслуговування

    @Override
    public Espresso createEspresso() {
        return new Espresso(10, 45);  // Найкраща якість - найнижча собівартість
    }

    @Override
    public Americano createAmericano() {
        return new Americano(13, 50);
    }

    @Override
    public Cappuccino createCappuccino() {
        return new Cappuccino(18, 65);
    }

    @Override
    public Latte createLatte() {
        return new Latte(20, 70);
    }

    @Override
    public String getManufacturerName() {
        return "Jura";
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

