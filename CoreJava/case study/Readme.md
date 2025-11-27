#  Bank Management System (Console Based Java Project)

A console-based **Bank Management System** built using **Core Java** with **MVC Architecture** and **Array-based data storage**.  
This project simulates basic banking operations such as account creation, deposits, withdrawals, transfers, interest calculation, loan handling, and reporting.

## Features

- **Account Management**: Create different types of accounts (Savings, Salary, Current, Loan)
- **Transactions**: Deposit, Withdraw, Transfer funds between accounts
- **Interest Calculation**: Apply monthly interest to accounts
- **Reports**: Generate end-of-day reports with account summaries and transaction details
- **Account Status**: View individual account details
- **Transaction History**: View all transactions across the bank

## Account Types

1. **Savings Account**: Requires minimum balance of ₹10,000, earns 4% annual interest
2. **Salary Account**: Extends Savings, automatically freezes after 2 months of inactivity
3. **Current Account**: Allows overdraft up to a specified limit, no interest
4. **Loan Account**: Negative balance for loans, earns interest on outstanding amount

## Classes in Single File

- `Transaction` - Transaction records
- `Account` (abstract) - Base account class
- `SavingsAccount`, `SalaryAccount`, `CurrentAccount`, `LoanAccount` - Account types
- `BankModel` - Manages accounts and transactions
- `Report` - Generates reports
- `BankView` - Handles console input/output
- `BankController` - Manages user interactions
- `BankSystemAll` - Main class

## Menu Options

1. **Create Account** - Add a new account (savings/salary/current/loan)
2. **Deposit** - Deposit money into an account
3. **Withdraw** - Withdraw money from an account
4. **Transfer** - Transfer money between accounts
5. **Apply Monthly Interest** - Calculate and apply interest to all accounts
6. **End Of Day Report** - Generate comprehensive daily report
7. **List Accounts** - Display all accounts
8. **Show Account Status** - View details of a specific account
9. **Show All Transactions** - Display all transactions
0. **Exit** - Close the application

## Sample Usage

```
======= BANK MENU =======
1. Create Account
2. Deposit
3. Withdraw
4. Transfer
5. Apply Monthly Interest
6. End Of Day Report
7. List Accounts
8. Show Account Status
9. Show All Transactions
0. Exit
Enter choice: 1
Type (savings/salary/current/loan): savings
Account Number: S1001
Holder Name: John Doe
Initial Amount: 15000
Account Created: ~~~~~~~~~S1001 | John Doe | 15000.0 | ACTIVE
```

## 💻 Technologies Used

- Language: **Java**
- IDE: VS Code / IntelliJ / Eclipse
- Storage: Arrays (No Collections used)
- Interface: Console-based UI