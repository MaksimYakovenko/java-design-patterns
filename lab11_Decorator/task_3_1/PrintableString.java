public class PrintableString {
    protected String value;
    public PrintableString(String value) { this.value = value; }
    public void print() { System.out.print(value); }
    public String getValue() { return value; }
}
