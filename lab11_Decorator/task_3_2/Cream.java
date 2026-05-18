public class Cream extends CondimentDecorator {
    public Cream(Beverage b) { super(b); }
    public String description() { return beverage.description() + ", Cream (Krem)"; }
    public double cost() { return beverage.cost() + 0.25; }
}