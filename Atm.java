import java.util.Scanner;
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    public void displayMenu() {
        System.out.println("ATM Interface");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
    }
    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                System.out.print("Enter the amount to withdraw: Rs");
                double withdrawAmount = scanner.nextDouble();
                withdraw(withdrawAmount);
                break;
            case 3:
                System.out.print("Enter the amount to deposit: Rs");
                double depositAmount = scanner.nextDouble();
                deposit(depositAmount);
                break;
            case 4:
                System.out.println("Thank you! Visit again");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void checkBalance() {
        System.out.println("Your balance is: Rs" + bankAccount.getBalance());
    }

    private void withdraw(double amount) {
        bankAccount.withdraw(amount);
    }

    private void deposit(double amount) {
        bankAccount.deposit(amount);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Your new balance is: Rs" + balance);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is: Rs" + balance);
        } else {
            System.out.println(" You don't have That much of money in your account!!.");
        }
    }
}


public class Main {
    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(5000);
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            atm.processOption(choice);
        }
    }
}
