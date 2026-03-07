public class Main {
    public static void main(String[] args) {

        BeverageFactory factory = new CoffeeShopFactory();
        CoffeeShop coffeeShop = new CoffeeShop("Кав'ярня Іванка", factory);

        System.out.println("РАНКОВА ЗМІНА (8:00 - 12:00)");
        System.out.println("───────────────────────────────────────────────────────────");
        coffeeShop.sellBeverage("espresso");
        coffeeShop.sellBeverage("americano");
        coffeeShop.sellBeverage("cappuccino");
        coffeeShop.sellBeverage("latte");
        coffeeShop.sellBeverage("espresso");
        coffeeShop.sellBeverage("cappuccino");
        coffeeShop.sellBeverage("americano");

        System.out.println("ОБІДНЯ ЗМІНА (12:00 - 16:00)");
        System.out.println("───────────────────────────────────────────────────────────");
        coffeeShop.sellBeverage("latte");
        coffeeShop.sellBeverage("mocha");
        coffeeShop.sellBeverage("cappuccino");
        coffeeShop.sellBeverage("flatwhite");
        coffeeShop.sellBeverage("macchiato");
        coffeeShop.sellBeverage("americano");

        System.out.println("ВЕЧІРНЯ ЗМІНА (16:00 - 20:00)");
        System.out.println("───────────────────────────────────────────────────────────");
        coffeeShop.sellBeverage("espresso");
        coffeeShop.sellBeverage("latte");
        coffeeShop.sellBeverage("cappuccino");
        coffeeShop.sellBeverage("mocha");
        coffeeShop.sellBeverage("flatwhite");
        coffeeShop.sellBeverage("macchiato");
        coffeeShop.sellBeverage("americano");
        coffeeShop.sellBeverage("latte");
        System.out.println("\n Робочий день завершено! Формуємо звіт...\n");
        coffeeShop.printReport();

        System.out.println("\n АНАЛІТИКА:");
        System.out.println("───────────────────────────────────────────────────────────");
        double avgProfit = coffeeShop.calculateTotalProfit() / coffeeShop.getTotalSales();
        System.out.printf("Середній прибуток з одного напою: %.2f грн\n", avgProfit);

        int workingDays = 22;
        double monthlyProfit = coffeeShop.calculateTotalProfit() * workingDays;
        System.out.printf("Прогнозований прибуток за місяць (%d робочих днів): %.2f грн\n",
                workingDays, monthlyProfit);
        System.out.println("═══════════════════════════════════════════════════════════");

        System.out.println("\n Симуляція завершена успішно!");
        System.out.println("Бізнес Іванка процвітає!");
    }
}

