import java.time.LocalDateTime;

public class BankAccount {
    private final String ownerName;
    private int balance;
    private final LocalDateTime openingDate;
    private boolean isBlocked;

    // Конструктор с одним параметром (имя владельца)
    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0;
        this.openingDate = LocalDateTime.now();
        this.isBlocked = false;
    }

    // Пополнение счета
    public boolean deposit(int amount) {
        if (isBlocked || amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    // Снятие денег
    public boolean withdraw(int amount) {
        if (isBlocked || amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    // Перевод денег на другой счет
    public boolean transfer(BankAccount otherAccount, int amount) {
        if (otherAccount == null || isBlocked || otherAccount.isBlocked ||
                amount <= 0 || amount > balance) {
            return false;
        }

        this.balance -= amount;
        otherAccount.balance += amount;
        return true;
    }

    // Геттеры (для проверки)
    public String getOwnerName() {
        return ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}