// Concrete Factory для виробника Volvo
public class VolvoFactory implements TransportFactory {
    @Override
    public Bus createBus() {
        return new Bus(6_000_000, 20);
    }

    @Override
    public Tram createTram() {
        return new Tram(10_000_000, 7);
    }

    @Override
    public Trolleybus createTrolleybus() {
        return new Trolleybus(7_000_000, 13);
    }
}

