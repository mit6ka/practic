import java.util.function.Predicate;

public class StringPatternCheck {
    public static void main(String[] args) {
        Predicate<String> startsWithJorN = s -> s.startsWith("J") || s.startsWith("N");
        Predicate<String> endsWithA = s -> s.endsWith("A");

        Predicate<String> combined = startsWithJorN.and(endsWithA);

        System.out.println(combined.test("JavaA"));  // true
        System.out.println(combined.test("NexusA")); // true
        System.out.println(combined.test("Python")); // false
    }
}