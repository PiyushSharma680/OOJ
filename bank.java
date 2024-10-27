import java.util.Scanner;

class Account {
    @SuppressWarnings("unused")
    String customerName;
    @SuppressWarnings("unused")
    String accountNumber;
    double balance;

    public Account(String customerName, String accountNumber, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
}

class SavingsAccount extends Account {
    double interestRate;

    public SavingsAccount(String customerName, String accountNumber, double initialBalance, double interestRate) {
        super(customerName, accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void computeAndDepositInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
        System.out.println("Interest computed and added: " + interest);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }
}

class CurrentAccount extends Account {
    static final double MINIMUM_BALANCE = 500;
    static final double SERVICE_CHARGE = 50;

    public CurrentAccount(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, initialBalance);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            checkMinimumBalance();
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    private void checkMinimumBalance() {
        if (balance < MINIMUM_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Minimum balance not maintained. Service charge of " + SERVICE_CHARGE + " imposed.");
        }
    }
}

public class bank {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter customer name for savings account: ");
        String savName = scanner.nextLine();
        System.out.print("Enter account number for savings account: ");
        String savAccNum = scanner.nextLine();
        System.out.print("Enter initial balance for savings account: ");
        double savInitialBalance = scanner.nextDouble();
        System.out.print("Enter interest rate for savings account: ");
        double interestRate = scanner.nextDouble();
        
        SavingsAccount savings = new SavingsAccount(savName, savAccNum, savInitialBalance, interestRate);
        
        
        scanner.nextLine(); 
        System.out.print("Enter customer name for current account: ");
        String curName = scanner.nextLine();
        System.out.print("Enter account number for current account: ");
        String curAccNum = scanner.nextLine();
        System.out.print("Enter initial balance for current account: ");
        double curInitialBalance = scanner.nextDouble();
        
        CurrentAccount current = new CurrentAccount(curName, curAccNum, curInitialBalance);
        
        
        savings.displayBalance();
        System.out.print("Enter amount to deposit in savings account: ");
        savings.deposit(scanner.nextDouble());
        savings.displayBalance();
        savings.computeAndDepositInterest();
        savings.displayBalance();
        System.out.print("Enter amount to withdraw from savings account: ");
        savings.withdraw(scanner.nextDouble());
        savings.displayBalance();
        
        
        current.displayBalance();
        System.out.print("Enter amount to deposit in current account: ");
        current.deposit(scanner.nextDouble());
        current.displayBalance();
        System.out.print("Enter amount to withdraw from current account: ");
        current.withdraw(scanner.nextDouble());
        current.displayBalance();
        
        scanner.close();
    }
}
