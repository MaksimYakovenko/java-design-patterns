public class UserSize implements Size {
    private final String customSize;
    public UserSize(String customSize) { this.customSize = customSize; }
    public String getSizeName() { return customSize; }
}
