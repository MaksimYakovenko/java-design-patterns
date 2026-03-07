import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeShop {
    private String name;
    private BeverageFactory factory;
    private List<Beverage> soldBeverages;
    private Map<String, Integer> salesStatistics;

    public CoffeeShop(String name, BeverageFactory factory) {
        this.name = name;
        this.factory = factory;
        this.soldBeverages = new ArrayList<>();
        this.salesStatistics = new HashMap<>();
    }


    public void sellBeverage(String type) {
        Beverage beverage = factory.orderBeverage(type);
        if (beverage != null) {
            soldBeverages.add(beverage);
            salesStatistics.put(beverage.getName(),
                    salesStatistics.getOrDefault(beverage.getName(), 0) + 1);
            System.out.println("✓ Продано: " + beverage);
            System.out.println();
        }
    }

    public double calculateTotalProfit() {
        double totalProfit = 0;
        for (Beverage beverage : soldBeverages) {
            totalProfit += beverage.getProfit();
        }
        return totalProfit;
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0;
        for (Beverage beverage : soldBeverages) {
            totalRevenue += beverage.getSellingPrice();
        }
        return totalRevenue;
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (Beverage beverage : soldBeverages) {
            totalCost += beverage.getCostPrice();
        }
        return totalCost;
    }


    public void printReport() {
        System.out.println("              ЗВІТ КАВ'ЯРНІ \"" + name + "\"");
        System.out.println();

        System.out.println("СТАТИСТИКА ПРОДАЖІВ:");
        System.out.println("───────────────────────────────────────────────────────────");
        for (Map.Entry<String, Integer> entry : salesStatistics.entrySet()) {
            System.out.printf("%-15s : %3d порцій\n", entry.getKey(), entry.getValue());
        }
        System.out.println();

        System.out.println("ФІНАНСОВИЙ ЗВІТ:");
        System.out.println("───────────────────────────────────────────────────────────");
        System.out.printf("Всього продано напоїв: %d\n", soldBeverages.size());
        System.out.printf("Загальний дохід:       %.2f грн\n", calculateTotalRevenue());
        System.out.printf("Загальні витрати:      %.2f грн\n", calculateTotalCost());
        System.out.printf("ЧИСТИЙ ПРИБУТОК:       %.2f грн\n", calculateTotalProfit());
    }

    public String getName() {
        return name;
    }

    public int getTotalSales() {
        return soldBeverages.size();
    }
}

