// Concrete Factory для виробника Hyundai
public class HyundaiFactory implements TransportFactory {
    @Override
    public Bus createBus() {
        return new Bus(5_500_000, 20);
    }

    @Override
    public Tram createTram() {
        return new Tram(9_500_000, 6);
    }

    @Override
    public Trolleybus createTrolleybus() {
        return new Trolleybus(7_000_000, 11);
    }
}

