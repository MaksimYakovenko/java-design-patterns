public class Sugar extends CondimentDecorator {
    public Sugar(Beverage b) { super(b); }
    public String description() { return beverage.description() + ", Sugar"; }
    public double cost() { return beverage.cost() + 0.10; }
}