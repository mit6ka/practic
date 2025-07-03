import java.util.*;
import java.util.stream.Collectors;

public class CarParkAnalyzer {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("VIN1", "Camry", "Toyota", 2018, 45000, 20000),
                new Car("VIN2", "X5", "BMW", 2020, 35000, 50000),
                new Car("VIN3", "Model 3", "Tesla", 2021, 10000, 40000),
                new Car("VIN4", "A4", "Audi", 2019, 60000, 30000),
                new Car("VIN5", "Corolla", "Toyota", 2022, 5000, 25000)
        );

        // 1. Фильтрация по пробегу
        List<Car> lowMileageCars = cars.stream()
                .filter(c -> c.getMileage() < 50_000)
                .collect(Collectors.toList());

        // 2. Сортировка по цене (убывание)
        List<Car> sortedByPrice = cars.stream()
                .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
                .collect(Collectors.toList());

        // 3. Топ-3 самые дорогие
        System.out.println("Топ-3 самые дорогие:");
        sortedByPrice.stream()
                .limit(3)
                .forEach(c -> System.out.println(c.getModel() + ": $" + c.getPrice()));

        // 4. Средний пробег
        double avgMileage = cars.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0);
        System.out.printf("Средний пробег: %.1f км%n", avgMileage);

        // 5. Группировка по производителю
        Map<String, List<Car>> byManufacturer = cars.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));

        System.out.println("Машины по производителям:");
        byManufacturer.forEach((maker, carList) -> {
            System.out.println(maker + ": " +
                    carList.stream().map(Car::getModel).collect(Collectors.joining(", ")));
        });
    }
}