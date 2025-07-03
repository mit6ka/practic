import java.util.*;

public class Car implements Comparable<Car> {
    private final String VIN;
    private final String model;
    private final String manufacturer;
    private final int productionYear;
    private final int mileage;
    private final double price;

    public Car(String VIN, String model, String manufacturer,
               int productionYear, int mileage, double price) {
        this.VIN = VIN;
        this.model = model;
        this.manufacturer = manufacturer;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.price = price;
    }

    // Геттеры
    public String getVIN() { return VIN; }
    public String getModel() { return model; }
    public String getManufacturer() { return manufacturer; }
    public int getProductionYear() { return productionYear; }
    public int getMileage() { return mileage; }
    public double getPrice() { return price; }

    // equals и hashCode по VIN
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return VIN.equals(car.VIN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VIN);
    }

    // Сортировка по году выпуска (новые -> старые)
    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.productionYear, this.productionYear);
    }
}

// Отдельный класс для тестирования Car
class CarTest {
    public static void main(String[] args) {
        // Проверка уникальности по VIN
        Set<Car> carSet = new HashSet<>();
        carSet.add(new Car("VIN1", "Model A", "Toyota", 2020, 30000, 25000));
        carSet.add(new Car("VIN2", "Model B", "BMW", 2021, 20000, 35000));
        carSet.add(new Car("VIN1", "Model C", "Toyota", 2019, 40000, 20000)); // Дубликат VIN

        System.out.println("Количество уникальных машин: " + carSet.size()); // Должно быть 2

        // Проверка сортировки по году
        List<Car> cars = new ArrayList<>(carSet);
        Collections.sort(cars);
        System.out.println("Машины отсортированы по году (новые -> старые):");
        cars.forEach(c -> System.out.println(c.getModel() + " " + c.getProductionYear()));
    }
}