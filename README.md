# Bank-Account-Software-Management-
This project shows Java OOP principles through a bank account software management system
## Bank Management System
### Overview
The **Bank Management System** is a simple Java-based application that simulates a basic banking interface. It allows users to perform common banking operations like creating accounts, depositing and withdrawing money, transferring funds between accounts, and viewing account details. This project is designed with OOP principles, showcasing classes and methods for handling bank accounts and bank operations.

### Features
- **Account Creation**: Create new bank accounts with a unique account number, account holder’s name, and initial deposit.
- **Deposit Money**: Deposit funds into an active account.
- **Withdraw Money**: Withdraw funds from an active account if there are sufficient funds.
- **Check Balance**: View the current balance of an active account.
- **Deactivate Account**: Deactivate an account, preventing further transactions.
- **Transfer Funds**: Transfer funds between two active accounts.
- **View All Accounts**: Display all accounts and their details, including balance and status.
- **Input Validation**: Ensures all user inputs are valid and that transactions are allowed only on active accounts.

### Project Structure
```
Bank Management System/
├── BankAccount.java   # Class representing a bank account with deposit, withdraw, and transfer functionalities.
└── BankSystem.java    # Class with the main method and menu-driven interface for interacting with the BankAccount class.
```

### Getting Started

#### Prerequisites
- Java Development Kit (JDK) installed (version 8 or above).
- Any text editor or IDE, such as Visual Studio Code or IntelliJ IDEA.

#### Running the Program
1. **Clone the Repository**:
   ```sh
   git clone https://github.com/yourusername/BankManagementSystem.git
   ```
2. **Navigate to the Project Directory**:
   ```sh
   cd BankManagementSystem
   ```
3. **Compile the Program**:
   ```sh
   javac BankSystem.java
   ```
4. **Run the Program**:
   ```sh
   java BankSystem
   ```

### Usage
After launching the program, you’ll be presented with a menu of options. Enter the number corresponding to your choice to perform operations:
1. **Create a new account** - Set up a new account with initial deposit.
2. **Deposit money** - Add funds to an active account.
3. **Withdraw money** - Withdraw funds from an active account if sufficient balance is available.
4. **Check balance** - Display the balance of an active account.
5. **Deactivate account** - Deactivate an account, making it inactive.
6. **Transfer funds** - Transfer funds between two active accounts.
7. **View all accounts** - List details of all accounts, including status and balance.
8. **Exit** - Close the application.

### Code Highlights

- **Classes and Objects**: The project consists of two main classes, `BankAccount` and `BankSystem`, each encapsulating specific functionalities related to banking.
- **Data Structures**: Utilizes `ArrayList` to manage a dynamic list of bank accounts.
- **Exception Handling**: The program uses try-catch blocks to handle input validation and user input errors.
- **Input Validation**: Ensures valid inputs for numeric values and prevents incorrect operations on inactive accounts.

### Sample Output
```
Welcome to the Bank System
1. Create a new account
2. Deposit money
3. Withdraw money
4. Check balance
5. Deactivate account
6. Transfer funds
7. View all accounts
8. Exit
Enter your choice: 1

Enter account holder name: John Doe
Enter initial deposit: 500
Account created successfully. Account number: 1001
```

### Contributing
Feel free to fork the repository, make changes, and create pull requests. Contributions are welcome to add new features or improve existing functionalities.

### License
This project is open-source and available under the [MIT License](LICENSE).

### Author
This project was created by **Adya Parida** as part of the CSE 389 course Fall 2024 Syracuse University to demonstrate OOP principles and basic banking functionalities in Java.
