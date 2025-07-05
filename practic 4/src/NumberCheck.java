import java.util.function.Function;

public class NumberCheck {
    public static void main(String[] args) {
        Function<Integer, String> numberClassifier = num -> {
            if (num > 0) return "Положительное число";
            else if (num < 0) return "Отрицательное число";
            else return "Ноль";
        };

        System.out.println(numberClassifier.apply(5));   // Положительное
        System.out.println(numberClassifier.apply(-3)); // Отрицательное
        System.out.println(numberClassifier.apply(0));   // Ноль
    }
}