public class Milk extends CondimentDecorator {
    public Milk(Beverage b) { super(b); }
    public String description() { return beverage.description() + ", Milk"; }
    public double cost() { return beverage.cost() + 0.15; }
}