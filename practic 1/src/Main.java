public class Main {
    public static void main(String[] args) {
        // Создаем счета
        BankAccount account1 = new BankAccount("Иван Иванов");
        BankAccount account2 = new BankAccount("Петр Петров");

        // Тест пополнения
        System.out.println("Пополнение 1000: " + account1.deposit(1000)); // true
        System.out.println("Баланс account1: " + account1.getBalance()); // 1000

        // Тест снятия
        System.out.println("Снятие 300: " + account1.withdraw(300)); // true
        System.out.println("Баланс account1: " + account1.getBalance()); // 700

        // Попытка снять больше, чем есть
        System.out.println("Снятие 800: " + account1.withdraw(800)); // false
        System.out.println("Баланс account1: " + account1.getBalance()); // 700

        // Тест перевода
        System.out.println("Перевод 500: " + account1.transfer(account2, 500)); // true
        System.out.println("Баланс account1: " + account1.getBalance()); // 200
        System.out.println("Баланс account2: " + account2.getBalance()); // 500

        // Попытка перевода на null-счет
        System.out.println("Перевод на null: " + account1.transfer(null, 100)); // false

        // Попытка перевода при недостатке средств
        System.out.println("Перевод 300: " + account1.transfer(account2, 300)); // false
    }
}