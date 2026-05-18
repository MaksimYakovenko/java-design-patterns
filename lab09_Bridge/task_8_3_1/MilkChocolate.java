public class MilkChocolate extends Chocolate {
    public MilkChocolate(int sugar, ServingMethod sm) { super(sugar, sm); }
    public int cost() { return 55 + servingMethod.extraCost(); }
    public void prepare() { System.out.println("Prepare milk chocolate, sugar=" + sugar); }
}