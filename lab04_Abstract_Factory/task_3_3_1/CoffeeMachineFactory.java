// Abstract Factory - інтерфейс для створення кавових машин різних виробників
public interface CoffeeMachineFactory {
    // Створення напоїв
    Espresso createEspresso();
    Americano createAmericano();
    Cappuccino createCappuccino();
    Latte createLatte();

    // Характеристики виробника
    String getManufacturerName();
    double getMachineCost();           // Вартість кавової машини
    double getMaintenanceCostPerDay(); // Вартість обслуговування на день
}

