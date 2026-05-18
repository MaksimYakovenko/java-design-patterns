public abstract class Coffee extends Beverage {
    public Coffee(int sugar, ServingMethod sm) { super(sugar, sm); }
    public void prepare() { System.out.println("Prepare coffee, sugar=" + sugar); }
    public void drink() { System.out.println("Drink coffee " + servingMethod.serve()); }
}