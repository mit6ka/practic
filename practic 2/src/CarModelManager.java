import java.util.*;
import java.util.stream.Collectors;

public class CarModelManager {
    public static void main(String[] args) {
        // 1. Создание списка с дубликатами
        List<String> models = Arrays.asList(
                "Toyota Camry", "BMW X5", "Tesla Model S",
                "Audi A4", "Tesla Model 3", "BMW X5"
        );

        // 2. Удаление дубликатов и обратная сортировка
        List<String> uniqueModels = models.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Уникальные модели (обратная сортировка):");
        uniqueModels.forEach(System.out::println);

        // 3. Замена Tesla на ELECTRO_CAR
        List<String> processedModels = uniqueModels.stream()
                .map(model -> model.contains("Tesla") ? "ELECTRO_CAR" : model)
                .collect(Collectors.toList());

        System.out.println("После замены Tesla:");
        processedModels.forEach(System.out::println);

        // 4. Сохранение в Set
        Set<String> modelSet = new TreeSet<>(Comparator.reverseOrder());
        modelSet.addAll(processedModels);
    }
}