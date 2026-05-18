public class BlackTee extends Tee {
    public BlackTee(int sugar, ServingMethod sm) { super(sugar, sm); }
    public int cost() { return 20 + servingMethod.extraCost(); }
    public void prepare() { System.out.println("Prepare black tea, sugar=" + sugar); }
}