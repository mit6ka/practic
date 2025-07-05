import java.util.function.Consumer;

public class HeavyBoxDemo {
    public static void main(String[] args) {
        Consumer<HeavyBox> ship = box ->
                System.out.println("Отгрузили ящик с весом " + box.getWeight());

        Consumer<HeavyBox> send = box ->
                System.out.println("Отправляем ящик с весом " + box.getWeight());

        Consumer<HeavyBox> combined = ship.andThen(send);

        combined.accept(new HeavyBox(50));
    }
}
