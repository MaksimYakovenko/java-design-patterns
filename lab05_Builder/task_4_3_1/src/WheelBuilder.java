// Builder для колісних дисків
public class WheelBuilder {
    private Wheel.Material material;
    private int diameter;

    public WheelBuilder setMaterial(Wheel.Material material) {
        this.material = material;
        return this;
    }

    public WheelBuilder setDiameter(int diameter) {
        this.diameter = diameter;
        return this;
    }

    public Wheel build() {
        return new Wheel(material, diameter);
    }
}

