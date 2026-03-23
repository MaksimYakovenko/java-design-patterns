import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Клас кав'ярні, який використовує Abstract Factory
public class CoffeeShop {
    private String name;
    private CoffeeMachineFactory factory;
    private List<Beverage> soldBeverages;
    private Map<String, Integer> salesStatistics;

    public CoffeeShop(String name, CoffeeMachineFactory factory) {
        this.name = name;
        this.factory = factory;
        this.soldBeverages = new ArrayList<>();
        this.salesStatistics = new HashMap<>();
    }

    // Продаж напою через фабрику
    public void sellBeverage(String type) {
        Beverage beverage = null;

        switch (type.toLowerCase()) {
            case "espresso":
                beverage = factory.createEspresso();
                break;
            case "americano":
                beverage = factory.createAmericano();
                break;
            case "cappuccino":
                beverage = factory.createCappuccino();
                break;
            case "latte":
                beverage = factory.createLatte();
                break;
            default:
                System.out.println("✗ Невідомий напій: " + type);
                return;
        }

        soldBeverages.add(beverage);
        salesStatistics.put(beverage.getName(),
                salesStatistics.getOrDefault(beverage.getName(), 0) + 1);
    }

    // Розрахунок загального прибутку від продажу напоїв
    public double calculateDailyBeverageProfit() {
        double totalProfit = 0;
        for (Beverage beverage : soldBeverages) {
            totalProfit += beverage.getProfit();
        }
        return totalProfit;
    }

    // Розрахунок чистого прибутку за N днів з врахуванням вартості машини та обслуговування
    public double calculateNetProfit(int days) {
        double dailyProfit = calculateDailyBeverageProfit();
        double totalRevenue = dailyProfit * days;
        double totalMaintenance = factory.getMaintenanceCostPerDay() * days;
        double machineCost = factory.getMachineCost();

        return totalRevenue - totalMaintenance - machineCost;
    }

    // Розрахунок днів до окупності
    public int calculateBreakEvenDays() {
        double dailyProfit = calculateDailyBeverageProfit();
        double dailyMaintenance = factory.getMaintenanceCostPerDay();
        double netDailyProfit = dailyProfit - dailyMaintenance;

        if (netDailyProfit <= 0) {
            return -1; // Неможливо окупити
        }

        return (int) Math.ceil(factory.getMachineCost() / netDailyProfit);
    }

    public int getTotalSales() {
        return soldBeverages.size();
    }

    public String getFactoryName() {
        return factory.getManufacturerName();
    }

    public void printDailyReport() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║           ДЕННИЙ ЗВІТ КАВ'ЯРНІ '" + name + "'            ║");
        System.out.println("║       Кавова машина: " + factory.getManufacturerName() + "                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");

        System.out.println("\n📊 СТАТИСТИКА ПРОДАЖІВ:");
        System.out.println("───────────────────────────────────────────────────────────");
        for (Map.Entry<String, Integer> entry : salesStatistics.entrySet()) {
            System.out.printf("  %-15s: %3d шт.\n", entry.getKey(), entry.getValue());
        }

        System.out.println("\n💰 ФІНАНСОВІ ПОКАЗНИКИ:");
        System.out.println("───────────────────────────────────────────────────────────");
        System.out.printf("  Продано напоїв: %d шт.\n", getTotalSales());
        System.out.printf("  Прибуток від напоїв: %.2f грн\n", calculateDailyBeverageProfit());
        System.out.printf("  Витрати на обслуговування: %.2f грн/день\n", factory.getMaintenanceCostPerDay());
        System.out.printf("  Чистий денний прибуток: %.2f грн\n",
                calculateDailyBeverageProfit() - factory.getMaintenanceCostPerDay());

        System.out.println("\n🏭 ІНФОРМАЦІЯ ПРО ОБЛАДНАННЯ:");
        System.out.println("───────────────────────────────────────────────────────────");
        System.out.printf("  Виробник: %s\n", factory.getManufacturerName());
        System.out.printf("  Вартість машини: %.2f грн\n", factory.getMachineCost());
        System.out.printf("  Обслуговування: %.2f грн/день\n", factory.getMaintenanceCostPerDay());

        int breakEvenDays = calculateBreakEvenDays();
        if (breakEvenDays > 0) {
            System.out.printf("  📅 Окупність через: %d днів\n", breakEvenDays);
        }

        System.out.println("═══════════════════════════════════════════════════════════");
    }

    public void reset() {
        soldBeverages.clear();
        salesStatistics.clear();
    }
}

