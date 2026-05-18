public class Main {
    public static void main(String[] args) {
        PrintableString s = new PrintableString("");
        s = new PostWordDecorator(s, "Hello");
        s = new PostComaDecorator(s);
        s = new PostSpaceDecorator(s);
        s = new PostWordDecorator(s, "World");
        s = new PostExclaimDecorator(s);
        s = new PostEndlDecorator(s);
        s.print();
    }
}
