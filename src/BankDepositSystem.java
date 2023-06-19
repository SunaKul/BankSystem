import java.util.Scanner;

abstract class Bank {
    protected String name;
    protected int balance;

    public Bank(String name) {
        this.name = name;
        this.balance = 0;
    }

    public abstract void deposit(int amount);

    public abstract void withdraw(int amount);

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }
}

class GarantiBank extends Bank {
    public GarantiBank() {
        super("Garanti Bank");
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Not enough balance.");
        }
    }
}

class ZiraatBank extends Bank {
    public ZiraatBank() {
        super("Ziraat Bank");
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Not enough balance.");
        }
    }
}

class User {
    private String name;
    private int age;
    private Bank bank;

    public User(String name, int age, Bank bank) {
        this.name = name;
        this.age = age;
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Bank getBank() {
        return bank;
    }

    public void deposit(int amount) {
        bank.deposit(amount);
    }

    public void withdraw(int amount) {
        bank.withdraw(amount);
    }
}

public class BankDepositSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Choose your bank: ");
        System.out.println("1. Garanti Bank");
        System.out.println("2. Ziraat Bank");
        int choice = scanner.nextInt();

        Bank bank;
        if (choice == 1) {
            bank = new GarantiBank();
        } else {
            bank = new ZiraatBank();
        }

        User user = new User(name, age, bank);

        System.out.println("Enter the amount you want to deposit: ");
        int amount = scanner.nextInt();

        user.deposit(amount);

        System.out.println(user.getName()+" deposited " + user.getBank().getBalance()+ " TL to " +bank.getName());
    }
}
