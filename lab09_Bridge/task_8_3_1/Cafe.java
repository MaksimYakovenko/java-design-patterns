public class Cafe {
    public static void main(String[] args) {
        ServingMethod dineIn = new DineIn();
        ServingMethod takeaway = new Takeaway();
        Beverage[] beverages = {
            new BlackCoffee(1, dineIn),
            new CoffeeWithMilk(2, takeaway),
            new BlackTee(0, dineIn),
            new TeeWithMilk(1, takeaway),
            new BlackChocolate(2, dineIn),
            new MilkChocolate(1, takeaway)
        };
        for (Beverage b : beverages) {
            System.out.println("=========================");
            b.prepare();
            b.drink();
            System.out.println("Cost: " + b.cost() + " grn");
        }
    }
}