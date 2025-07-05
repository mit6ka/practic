import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static void processClass(Class<?> clazz) {
        // Проверка аннотации класса
        if (clazz.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx annotation = clazz.getAnnotation(DeprecatedEx.class);
            printWarning("класс", clazz.getSimpleName(), annotation.message());
        }

        // Проверка аннотаций методов
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx annotation = method.getAnnotation(DeprecatedEx.class);
                printWarning("метод", method.getName(), annotation.message());
            }
        }
    }

    private static void printWarning(String elementType, String elementName, String message) {
        System.out.printf("Внимание: %s '%s' устарел. Альтернатива: '%s'%n",
                elementType, elementName, message);
    }

    public static void main(String[] args) {
        processClass(TestClass.class);
    }
}