public class Americano extends Beverage {
    public Americano() {
        super("Американо", 18.0, 40.0);
    }

    @Override
    public String getDescription() {
        return "Еспресо, розбавлене гарячою водою. Компоненти: кавові зерна (7г), вода (120мл)";
    }
}

