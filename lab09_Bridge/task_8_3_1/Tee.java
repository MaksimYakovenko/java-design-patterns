public abstract class Tee extends Beverage {
    public Tee(int sugar, ServingMethod sm) { super(sugar, sm); }
    public void prepare() { System.out.println("Prepare tea, sugar=" + sugar); }
    public void drink() { System.out.println("Drink tea " + servingMethod.serve()); }
}