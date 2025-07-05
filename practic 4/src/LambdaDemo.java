public class LambdaDemo {
    public static void main(String[] args) {
        Printable printer = () -> System.out.println("Hello, Lambda!");
        printer.print();
    }
}