import java.util.function.Predicate;

public class StringCheck {
    public static void main(String[] args) {
        // 1. Проверка на null
        Predicate<String> notNull = s -> s != null;

        // 2. Проверка на пустоту
        Predicate<String> notEmpty = s -> !s.isEmpty();

        // 3. Комбинированная проверка
        Predicate<String> validString = notNull.and(notEmpty);

        System.out.println(validString.test("Hello")); // true
        System.out.println(validString.test(""));     // false
        System.out.println(validString.test(null));   // false
    }
}