public class BlackChocolate extends Chocolate {
    public BlackChocolate(int sugar, ServingMethod sm) { super(sugar, sm); }
    public int cost() { return 50 + servingMethod.extraCost(); }
    public void prepare() { System.out.println("Prepare dark chocolate, sugar=" + sugar); }
}