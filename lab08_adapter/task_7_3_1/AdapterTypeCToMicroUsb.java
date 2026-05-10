import com.mobile.Legacy.MicroUsbCharger;

public class AdapterTypeCToMicroUsb implements MicroUsbCharger {

    private final TypeCCharger typeCCharger;

    public AdapterTypeCToMicroUsb(TypeCCharger typeCCharger) {
        this.typeCCharger = typeCCharger;
    }

    @Override
    public float getOutputVoltage() {
        // approximate: assume Type-C power ~ voltage * amperage; choose a default voltage (e.g., 5V)
        float power = typeCCharger.getOutputPower();
        float assumedVoltage = 5.0f;
        float amperage = power / assumedVoltage;
        return assumedVoltage;
    }

    @Override
    public float getOutputAmperage() {
        float power = typeCCharger.getOutputPower();
        float assumedVoltage = 5.0f;
        return power / assumedVoltage;
    }
}

