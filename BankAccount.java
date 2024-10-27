// BankAccount.java

// Represents a bank account with basic functionalities
public class BankAccount {
    private String accountHolderName;
    private int accountNumber;
    private double balance;
    private boolean isActive;

    // Constructor to create a new Bank Account
    public BankAccount(String accountHolderName, int accountNumber, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.isActive = true; // New accounts are active by default
    }

    // Getter for account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Getter for account holder name
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Must be positive.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". Remaining balance: $" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Account Balance: $" + balance);
    }

    // Method to deactivate the account
    public void deactivateAccount() {
        isActive = false;
        System.out.println("Account " + accountNumber + " has been deactivated.");
    }

    // Method to check if the account is active
    public boolean isActive() {
        return isActive;
    }

    // Method to transfer money between accounts
    public boolean transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);  // Withdraw from the source account
            targetAccount.deposit(amount);  // Deposit to the target account
            System.out.println("Transferred $" + amount + " to Account " + targetAccount.getAccountNumber());
            return true;
        } else {
            System.out.println("Transfer failed. Insufficient balance or invalid amount.");
            return false;
        }
    }

    // Method to display account details
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Account Status: " + (isActive ? "Active" : "Inactive"));
        System.out.println("---------------------------");
    }
}
