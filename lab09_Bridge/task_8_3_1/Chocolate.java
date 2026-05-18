public abstract class Chocolate extends Beverage {
    public Chocolate(int sugar, ServingMethod sm) { super(sugar, sm); }
    public void prepare() { System.out.println("Prepare chocolate, sugar=" + sugar); }
    public void drink() { System.out.println("Drink chocolate " + servingMethod.serve()); }
}