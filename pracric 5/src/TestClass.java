@DeprecatedEx(message = "Вместо этого класса используйте NewTestClass")
public class TestClass {

    @DeprecatedEx(message = "Используйте newMethod() вместо этого")
    public void oldMethod() {}

    public void validMethod() {}

    @DeprecatedEx(message = "Этот метод будет удален в следующей версии")
    public void deprecatedMethod() {}
}