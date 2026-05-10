// Builder для шин
public class TireBuilder {
    private Tire.Season season;
    private int width;
    private int profile;
    private int diameter;

    public TireBuilder setSeason(Tire.Season season) {
        this.season = season;
        return this;
    }

    public TireBuilder setWidth(int width) {
        this.width = width;
        return this;
    }

    public TireBuilder setProfile(int profile) {
        this.profile = profile;
        return this;
    }

    public TireBuilder setDiameter(int diameter) {
        this.diameter = diameter;
        return this;
    }

    public Tire build() {
        return new Tire(season, width, profile, diameter);
    }
}

