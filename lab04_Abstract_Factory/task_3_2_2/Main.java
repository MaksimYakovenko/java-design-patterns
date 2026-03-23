import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final int A = 10;
        final int T = 5;
        final int Tr = 40;
        final int N = 200_000;

        TransportFactory volvoFactory = new VolvoFactory();
        TransportFactory skodaFactory = new SkodaFactory();
        TransportFactory hyundaiFactory = new HyundaiFactory();

        System.out.println("=== Розрахунок вартості контракту для різних виробників ===\n");

        long volvoCost = calculateTotalCost(volvoFactory, A, T, Tr, N);
        System.out.println("Volvo - загальна вартість контракту: " + volvoCost + " грн\n");

        long skodaCost = calculateTotalCost(skodaFactory, A, T, Tr, N);
        System.out.println("Skoda - загальна вартість контракту: " + skodaCost + " грн\n");

        long hyundaiCost = calculateTotalCost(hyundaiFactory, A, T, Tr, N);
        System.out.println("Hyundai - загальна вартість контракту: " + hyundaiCost + " грн\n");

        System.out.println("=== Висновок ===");
        long minCost = Math.min(volvoCost, Math.min(skodaCost, hyundaiCost));

        if (minCost == volvoCost) {
            System.out.println("Найвигідніший виробник: Volvo");
        } else if (minCost == skodaCost) {
            System.out.println("Найвигідніший виробник: Skoda");
        } else {
            System.out.println("Найвигідніший виробник: Hyundai");
        }
        System.out.println("Мінімальна вартість контракту: " + minCost + " грн");
    }

    private static long calculateTotalCost(TransportFactory factory, int busCount, int tramCount,
                                           int trolleybusCount, int distance) {
        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Tram> trams = new ArrayList<>();
        ArrayList<Trolleybus> trolleybuses = new ArrayList<>();

        for (int i = 0; i < busCount; i++) {
            buses.add(factory.createBus());
        }

        for (int i = 0; i < tramCount; i++) {
            trams.add(factory.createTram());
        }

        for (int i = 0; i < trolleybusCount; i++) {
            trolleybuses.add(factory.createTrolleybus());
        }

        long totalCost = 0;

        for (Bus bus : buses) {
            totalCost += bus.getCost() + (long) bus.getUsageCost() * distance;
        }

        for (Tram tram : trams) {
            totalCost += tram.getCost() + (long) tram.getUsageCost() * distance;
        }

        for (Trolleybus trolleybus : trolleybuses) {
            totalCost += trolleybus.getCost() + (long) trolleybus.getUsageCost() * distance;
        }

        System.out.println("  Автобусів: " + busCount + " шт.");
        System.out.println("  Трамваїв: " + tramCount + " шт.");
        System.out.println("  Тролейбусів: " + trolleybusCount + " шт.");
        System.out.println("  Орієнтований пробіг: " + distance + " км");

        return totalCost;
    }
}