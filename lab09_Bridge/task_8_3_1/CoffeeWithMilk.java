public class CoffeeWithMilk extends Coffee {
    public CoffeeWithMilk(int sugar, ServingMethod sm) { super(sugar, sm); }
    public int cost() { return 40 + servingMethod.extraCost(); }
    public void prepare() { System.out.println("Prepare coffee with milk, sugar=" + sugar); }
}