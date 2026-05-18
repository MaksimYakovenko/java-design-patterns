public class TeeWithMilk extends Tee {
    public TeeWithMilk(int sugar, ServingMethod sm) { super(sugar, sm); }
    public int cost() { return 30 + servingMethod.extraCost(); }
    public void prepare() { System.out.println("Prepare tea with milk, sugar=" + sugar); }
}