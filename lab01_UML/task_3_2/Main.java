public class Main {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Demo ===\n");

        Creator creator1 = new ConcreteCreator1();
        System.out.println("Using ConcreteCreator1:");
        creator1.someOperation();

        System.out.println();
        Creator creator2 = new ConcreteCreator2();
        System.out.println("Using ConcreteCreator2:");
        creator2.someOperation();
    }
}

