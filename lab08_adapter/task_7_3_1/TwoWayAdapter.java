import com.mobile.Legacy.MicroUsbCharger;

public class TwoWayAdapter implements MicroUsbCharger, TypeCCharger {

    private MicroUsbCharger microUsbCharger;
    private TypeCCharger typeCCharger;

    public TwoWayAdapter(MicroUsbCharger microUsbCharger) {
        this.microUsbCharger = microUsbCharger;
    }

    public TwoWayAdapter(TypeCCharger typeCCharger) {
        this.typeCCharger = typeCCharger;
    }

    @Override
    public float getOutputVoltage() {
        if (microUsbCharger != null) {
            return microUsbCharger.getOutputVoltage();
        } else {
            // Assume standard voltage for Type-C
            return 5.0f;
        }
    }

    @Override
    public float getOutputAmperage() {
        if (microUsbCharger != null) {
            return microUsbCharger.getOutputAmperage();
        } else {
            // Calculate amperage from power
            return typeCCharger.getOutputPower() / 5.0f;
        }
    }

    @Override
    public float getOutputPower() {
        if (typeCCharger != null) {
            return typeCCharger.getOutputPower();
        } else {
            // Calculate power from voltage and amperage
            return microUsbCharger.getOutputVoltage() * microUsbCharger.getOutputAmperage();
        }
    }
}
