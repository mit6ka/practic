import java.util.Arrays;
import java.util.Random;

public class CarYearStatistics {
    public static void main(String[] args) {
        // 1. Создание массива годов выпуска
        int[] productionYears = new int[50];
        Random random = new Random();

        for (int i = 0; i < productionYears.length; i++) {
            productionYears[i] = 2000 + random.nextInt(26); // 2000-2025
        }

        // 2. Вывод машин после 2015 года
        System.out.println("Машины после 2015 года:");
        Arrays.stream(productionYears)
                .filter(year -> year > 2015)
                .forEach(System.out::println);

        // 3. Средний возраст авто
        int currentYear = java.time.Year.now().getValue();
        double averageAge = Arrays.stream(productionYears)
                .mapToDouble(year -> currentYear - year)
                .average()
                .orElse(0);
        System.out.printf("Средний возраст: %.1f лет%n", averageAge);
    }
}