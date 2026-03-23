public class Main {
    public static void main(String[] args) {
        System.out.println("АНАЛІЗ ОПТИМАЛЬНОГО ВИРОБНИКА КАВОВОЇ МАШИНИ ДЛЯ КАВ'ЯРНІ");

        CoffeeMachineFactory[] factories = {
            new DeLonghiFactory(),
            new SaecoFactory(),
            new JuraFactory(),
            new KrupsFactory()
        };

        final int PLANNING_DAYS = 365;

        System.out.println("УМОВИ АНАЛІЗУ:");
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("Тестовий період: типовий робочий день");
        System.out.println("Планований горизонт: " + PLANNING_DAYS + " днів");
        System.out.println("Аналізується: прибуток, окупність, вартість обладнання\n");

        double bestNetProfit = Double.NEGATIVE_INFINITY;
        CoffeeMachineFactory bestFactory = null;
        int bestBreakEven = Integer.MAX_VALUE;

        for (CoffeeMachineFactory factory : factories) {
            CoffeeShop shop = new CoffeeShop("Кав'ярня Іванка", factory);

            simulateTypicalDay(shop);

            shop.printDailyReport();

            double netProfit = shop.calculateNetProfit(PLANNING_DAYS);
            int breakEvenDays = shop.calculateBreakEvenDays();

            System.out.println("\nПРОГНОЗ НА " + PLANNING_DAYS + " ДНІВ:");
            System.out.println("───────────────────────────────────────────────────────────────");
            System.out.printf("  Чистий прибуток: %.2f грн\n", netProfit);
            System.out.printf("  Рентабельність: %.1f%%\n",
                (netProfit / factory.getMachineCost()) * 100);
            if (netProfit > bestNetProfit) {
                bestNetProfit = netProfit;
                bestFactory = factory;
                bestBreakEven = breakEvenDays;
            }
        }

        // Виводимо остаточні рекомендації
        System.out.println("\nОПТИМАЛЬНИЙ ВИБІР: " + bestFactory.getManufacturerName());
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.printf("Вартість машини: %.2f грн\n", bestFactory.getMachineCost());
        System.out.printf("Обслуговування: %.2f грн/день\n", bestFactory.getMaintenanceCostPerDay());
        System.out.printf("Окупність через: %d днів (%.1f місяців)\n",
            bestBreakEven, bestBreakEven / 30.0);
        System.out.printf("Чистий прибуток за %d днів: %.2f грн\n",
            PLANNING_DAYS, bestNetProfit);
        System.out.printf("Рентабельність інвестиції: %.1f%%\n\n",
            (bestNetProfit / bestFactory.getMachineCost()) * 100);

        System.out.println("ОБҐРУНТУВАННЯ:");
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("  Виробник " + bestFactory.getManufacturerName() + " забезпечує найкращий баланс між:");
        System.out.println("Початковими інвестиціями (вартість машини)");
        System.out.println("Операційними витратами (собівартість + обслуговування)");
        System.out.println("Швидкістю окупності та довгостроковим прибутком");
        System.out.println("\nІванко може впевнено починати бізнес з обраним обладнанням!");
    }

    private static void simulateTypicalDay(CoffeeShop shop) {
        shop.sellBeverage("espresso");
        shop.sellBeverage("espresso");
        shop.sellBeverage("americano");
        shop.sellBeverage("americano");
        shop.sellBeverage("cappuccino");
        shop.sellBeverage("cappuccino");
        shop.sellBeverage("latte");
        shop.sellBeverage("americano");

        // Обідня зміна (12:00 - 16:00) - різноманітні напої
        shop.sellBeverage("latte");
        shop.sellBeverage("latte");
        shop.sellBeverage("cappuccino");
        shop.sellBeverage("cappuccino");
        shop.sellBeverage("americano");
        shop.sellBeverage("espresso");

        // Вечірня зміна (16:00 - 20:00) - менше продажів
        shop.sellBeverage("espresso");
        shop.sellBeverage("cappuccino");
        shop.sellBeverage("latte");
        shop.sellBeverage("americano");
        shop.sellBeverage("latte");
    }
}

