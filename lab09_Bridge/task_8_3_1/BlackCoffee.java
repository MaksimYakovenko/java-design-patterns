public class BlackCoffee extends Coffee {
    public BlackCoffee(int sugar, ServingMethod sm) { super(sugar, sm); }
    public int cost() { return 30 + servingMethod.extraCost(); }
    public void prepare() { System.out.println("Prepare black coffee, sugar=" + sugar); }
}