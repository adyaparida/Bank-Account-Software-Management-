// BankSystem.java

import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    private ArrayList<BankAccount> accounts = new ArrayList<>();  // List to hold accounts
    private Scanner scanner = new Scanner(System.in);
    private int accountCounter = 1001;  // Unique account number starts from 1001

    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        bankSystem.run();  // Start the banking system
    }

    // Main loop to run the banking system
    public void run() {
        int choice;
        do {
            // Display the menu
            System.out.println("\nWelcome to the Bank System");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("5. Deactivate account");
            System.out.println("6. Transfer funds");
            System.out.println("7. View all accounts");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = validateIntegerInput();  // Validate user choice

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    deactivateAccount();
                    break;
                case 6:
                    transferFunds();
                    break;
                case 7:
                    viewAllAccounts();
                    break;
                case 8:
                    System.out.println("Thank you for using the bank system!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);  // Exit when the user chooses option 8
    }

    // Method to create a new bank account
    private void createAccount() {
        try {
            System.out.print("Enter account holder name: ");
            String name = scanner.nextLine();

            System.out.print("Enter initial deposit: ");
            double initialDeposit = validateDoubleInput();

            if (initialDeposit < 0) {
                throw new IllegalArgumentException("Initial deposit must be positive.");
            }

            BankAccount newAccount = new BankAccount(name, accountCounter++, initialDeposit);
            accounts.add(newAccount);
            System.out.println("Account created successfully. Account number: " + newAccount.getAccountNumber());

        } catch (Exception e) {
            System.out.println("Error while creating account: " + e.getMessage());
            scanner.nextLine();  // Clear buffer in case of exception
        }
    }

    // Method to deposit money into a selected account
    private void depositMoney() {
        BankAccount account = findAccount();
        if (account != null && account.isActive()) {
            System.out.print("Enter deposit amount: ");
            double amount = validateDoubleInput();
            account.deposit(amount);
        } else {
            System.out.println("Account not found or inactive.");
        }
    }

    // Method to withdraw money from a selected account
    private void withdrawMoney() {
        BankAccount account = findAccount();
        if (account != null && account.isActive()) {
            System.out.print("Enter withdrawal amount: ");
            double amount = validateDoubleInput();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found or inactive.");
        }
    }

    // Method to check the balance of a selected account
    private void checkBalance() {
        BankAccount account = findAccount();
        if (account != null && account.isActive()) {
            account.checkBalance();
        } else {
            System.out.println("Account not found or inactive.");
        }
    }

    // Method to deactivate a selected account
    private void deactivateAccount() {
        BankAccount account = findAccount();
        if (account != null && account.isActive()) {
            account.deactivateAccount();
        } else {
            System.out.println("Account not found or already inactive.");
        }
    }

    // Method to transfer funds between two accounts
    private void transferFunds() {
        System.out.println("Transfer Funds Between Accounts:");
        BankAccount sourceAccount = findAccount("Enter source account number: ");
        if (sourceAccount != null && sourceAccount.isActive()) {
            BankAccount targetAccount = findAccount("Enter target account number: ");
            if (targetAccount != null && targetAccount.isActive()) {
                System.out.print("Enter transfer amount: ");
                double amount = validateDoubleInput();
                sourceAccount.transfer(targetAccount, amount);
            } else {
                System.out.println("Target account not found or inactive.");
            }
        } else {
            System.out.println("Source account not found or inactive.");
        }
    }

    // Method to view details of all accounts
    private void viewAllAccounts() {
        System.out.println("\nList of all accounts:");
        for (BankAccount account : accounts) {
            account.displayAccountInfo();
        }
    }

    // Method to find an account by its number with a custom message
    private BankAccount findAccount(String prompt) {
        System.out.print(prompt);
        int accountNumber = validateIntegerInput();

        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    // Overloaded method to find account by default message
    private BankAccount findAccount() {
        return findAccount("Enter account number: ");
    }

    // Method to validate integer input
    private int validateIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next();  // Clear invalid input
        }
        return scanner.nextInt();
    }

    // Method to validate double input
    private double validateDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();  // Clear invalid input
        }
        double input = scanner.nextDouble();
        scanner.nextLine();  // Consume newline character
        return input;
    }
}
