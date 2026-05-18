public class Whip extends CondimentDecorator {
    public Whip(Beverage b) { super(b); }
    public String description() { return beverage.description() + ", Whip (Vershky)"; }
    public double cost() { return beverage.cost() + 0.20; }
}