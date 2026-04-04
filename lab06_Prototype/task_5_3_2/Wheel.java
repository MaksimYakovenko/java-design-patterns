public class Wheel implements Cloneable {
    private String material; // Матеріал диска (сталь, легкосплавний)
    private int diameter; // Діаметр диска (дюйми)

    public Wheel(String material, int diameter) {
        this.material = material;
        this.diameter = diameter;
    }

    @Override
    public Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return String.format("Wheel{material='%s', diameter=%d\"}", material, diameter);
    }

    // Getters
    public String getMaterial() { return material; }
    public int getDiameter() { return diameter; }

    // Setters
    public void setMaterial(String material) { this.material = material; }
    public void setDiameter(int diameter) { this.diameter = diameter; }
}

