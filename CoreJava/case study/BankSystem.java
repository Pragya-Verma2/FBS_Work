package Project;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/* ------------------ TRANSACTION CLASS ------------------ */

class Transaction {
    long txnId;
    String type;      // "DEPOSIT", "WITHDRAW", "TRANSFER", "INTEREST"
    double amount;
    LocalDate date;
    String performedBy;

    Transaction(long id, String type, double amt, LocalDate date, String by) {
        this.txnId = id;
        this.type = type;
        this.amount = amt;
        this.date = date;
        this.performedBy = by;
    }

    @Override
    public String toString() {
        return "Txn[" + txnId + "] " + type + " " + amount + " on " + date + " by " + performedBy;
    }
}

/* ------------------ BASE ACCOUNT ------------------ */

abstract class Account {
    String accNumber;
    String holderName;
    double balance;
    String status;   // ACTIVE, FROZEN, CLOSED

    Transaction[] dailyTxns = new Transaction[MAX_TXN];
    int txnCount = 0;
    static final int MAX_TXN = 200;

    Account(String accNumber, String holderName, double balance) {
        this.accNumber = accNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.status = "ACTIVE";
    }

    void addTransaction(Transaction t) {
        if (txnCount < MAX_TXN) dailyTxns[txnCount++] = t;
    }

    boolean deposit(double amt, Transaction t) {
        if (!status.equals("ACTIVE")) return false;
        balance += amt;
        addTransaction(t);
        return true;
    }

    boolean withdraw(double amt, Transaction t) {
        if (!status.equals("ACTIVE")) return false;
        if (balance - amt < 0) return false;
        balance -= amt;
        addTransaction(t);
        return true;
    }

    void closeAccount() { status = "CLOSED"; }
    void freezeAccount() { status = "FROZEN"; }
    void unfreezeAccount() { if (!status.equals("CLOSED")) status = "ACTIVE"; }

    abstract double calculateInterest();

    String summary() {
        return accNumber + " | " + holderName + " | " + balance + " | " + status;
    }
}

/* ------------------ SAVINGS ACCOUNT ------------------ */

class SavingsAccount extends Account {
    double minBalance = 10000.0;
    double annualInterestRate = 0.04;

    SavingsAccount(String acc, String name, double balance) {
        super(acc, name, balance);
    }

    @Override
    boolean withdraw(double amt, Transaction t) {
        if (!status.equals("ACTIVE")) return false;
        if (balance - amt < minBalance) return false;
        balance -= amt;
        addTransaction(t);
        return true;
    }

    @Override
    double calculateInterest() {
        return balance * (annualInterestRate / 12);
    }
}

/* ------------------ SALARY ACCOUNT ------------------ */

class SalaryAccount extends SavingsAccount {
    LocalDate lastTxnDate;

    SalaryAccount(String acc, String name, double balance) {
        super(acc, name, balance);
        lastTxnDate = LocalDate.now();
    }

    @Override
    boolean deposit(double amt, Transaction t) {
        boolean ok = super.deposit(amt, t);
        if (ok) lastTxnDate = LocalDate.now();
        return ok;
    }

    @Override
    boolean withdraw(double amt, Transaction t) {
        boolean ok = super.withdraw(amt, t);
        if (ok) lastTxnDate = LocalDate.now();
        return ok;
    }

    void checkInactive() {
        Period p = Period.between(lastTxnDate, LocalDate.now());
        int months = p.getMonths() + p.getYears() * 12;
        if (months >= 2 && status.equals("ACTIVE")) {
            freezeAccount();
            System.out.println("Salary Account " + accNumber + " frozen due to inactivity!");
        }
    }
}

/* ------------------ CURRENT ACCOUNT ------------------ */

class CurrentAccount extends Account {
    double overdraftLimit;

    CurrentAccount(String acc, String name, double balance, double limit) {
        super(acc, name, balance);
        overdraftLimit = limit;
    }

    @Override
    boolean withdraw(double amt, Transaction t) {
        if (!status.equals("ACTIVE")) return false;
        if (balance - amt < -overdraftLimit) return false;
        balance -= amt;
        addTransaction(t);
        return true;
    }

    @Override
    double calculateInterest() { return 0.0; }
}

/* ------------------ LOAN ACCOUNT ------------------ */

class LoanAccount extends Account {
    double annualInterestRate = 0.12;

    LoanAccount(String acc, String name, double loanAmt) {
        super(acc, name, -loanAmt);  // balance starts negative
    }

    @Override
    boolean deposit(double amt, Transaction t) {
        balance += amt; // reduces negative loan balance
        addTransaction(t);
        return true;
    }

    @Override
    boolean withdraw(double amt, Transaction t) {
        return false; // Cannot withdraw from loan
    }

    @Override
    double calculateInterest() {
        return -(Math.abs(balance) * annualInterestRate / 12);
    }
}

/* ------------------ MODEL ------------------ */

class BankModel {
    Account[] accounts = new Account[MAX_ACC];
    int accCount = 0;
    long txnSeq = 1000;

    static final int MAX_ACC = 200;

    // BankModel() {
    // }

    Account find(String acc) {
        for (int i = 0; i < accCount; i++) {
            if (accounts[i].accNumber.equals(acc)) return accounts[i];
        }
        return null;
    }

    boolean add(Account a) {
        if (accCount >= MAX_ACC) return false;
        accounts[accCount++] = a;
        return true;
    }

    Transaction makeTxn(String type, double amt, String by) {
        Transaction t = new Transaction(txnSeq++, type, amt, LocalDate.now(), by);
        return t;
    }

    void applyInterestToAll() {
        for (int i = 0; i < accCount; i++) {
            Account a = accounts[i];
            double interest = a.calculateInterest();

            if (interest != 0) {
                a.balance += interest;
                Transaction t = makeTxn("INTEREST", interest, "SYSTEM");
                a.addTransaction(t);
            }
        }
    }
}

class Report {

    double totalDeposits;
    double totalWithdrawals;
    String accountWiseSummary;

    Report() {
        totalDeposits = 0;
        totalWithdrawals = 0;
        accountWiseSummary = "";
    }

    void generate(BankModel model) {

        totalDeposits = 0;
        totalWithdrawals = 0;

        // Start report
        accountWiseSummary = "\n======= DAILY REPORT =======\n";

        // ---- ACCOUNT LIST ----
        for (int i = 0; i < model.accCount; i++) {
            Account a = model.accounts[i];

            accountWiseSummary =
                accountWiseSummary +
                "Account: " + a.accNumber +
                " | Holder: " + a.holderName +
                " | Balance: " + a.balance +
                " | Status: " + a.status +
                " | Txns: " + a.txnCount +
                "\n";
        }

        // ---- TRANSACTIONS SUMMARY ----
        accountWiseSummary += "\n-------- TRANSACTION SUMMARY --------\n";

        for (int i = 0; i < model.accCount; i++) {
            Account a = model.accounts[i];
            for (int j = 0; j < a.txnCount; j++) {
                Transaction t = a.dailyTxns[j];
                if (t == null) continue;

                accountWiseSummary +=
                    "Txn#: " + t.txnId +
                    " | Type: " + t.type +
                    " | Amount: " + t.amount +
                    " | By: " + t.performedBy +
                    " | Time: " + t.date +
                    "\n";

                // Update totals
                if (t.type.equals("DEPOSIT"))
                    totalDeposits += t.amount;
                else if (t.type.equals("WITHDRAW"))
                    totalWithdrawals += t.amount;
            }
        }

        // ---- TOTALS ----
        accountWiseSummary +=
            "\nTotal Deposits: " + totalDeposits +
            "\nTotal Withdrawals: " + totalWithdrawals +
            "\n-------------------------------------\n";
    }

    void print() {
        System.out.println(accountWiseSummary);
    }
}

/* ------------------ VIEW ------------------ */

class BankView {
    Scanner sc = new Scanner(System.in);

    void menu() {
        System.out.println("\n======= XYZ BANK MENU =======");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Apply Monthly Interest");
        System.out.println("6. End Of Day Report");
        System.out.println("7. List Accounts");
        System.out.println("8. Show Account Status");
        System.out.println("9. Show All Transactions");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    String ask(String text) {
        System.out.print(text);
        return sc.nextLine();
    }

    double askDouble(String text) {
        System.out.print(text);
        return  Double.parseDouble(sc.nextLine());
//        try { return Double.parseDouble(sc.nextLine()); }
//        catch(Exception e) { return 0; }
    }
}

/* ------------------ CONTROLLER ------------------ */

class BankController {
    BankModel model;
    BankView view;

    BankController(BankModel m, BankView v) {
        model = m;
        view = v;
    }

    void createAccount() {

    	while(true) {
        String type = view.ask("Type (savings/salary/current/loan): ").toLowerCase();


        Account a = null;

        switch (type) {
            case "savings":
            	  String acc = view.ask("Account Number: ");
                  String name = view.ask("Holder Name: ");
                  double amount = view.askDouble("Initial Amount: ");
                if (amount < 10000) {
                    System.err.println("Min balance 10000 required.");
                    continue;
                }
                a = new SavingsAccount(acc, name, amount);
                break;

            case "salary":
            	  String acc1 = view.ask("Account Number: ");
                  String name1 = view.ask("Holder Name: ");
                  double amount1 = view.askDouble("Initial Amount: ");
                a = new SalaryAccount(acc1, name1, amount1);
                break;

            case "current":
            	  String acc2 = view.ask("Account Number: ");
                  String name2 = view.ask("Holder Name: ");
                  double amount2 = view.askDouble("Initial Amount: ");
                double od = view.askDouble("Overdraft Limit: ");
                a = new CurrentAccount(acc2, name2, amount2, od);
                break;

            case "loan":
            	  String acc3 = view.ask("Account Number: ");
                  String name3 = view.ask("Holder Name: ");
                  double amount3 = view.askDouble("Initial Amount: ");
                a = new LoanAccount(acc3, name3, amount3);
                break;

            default:
                System.err.println("Invalid type.");
                return;
        }

        model.add(a);
        System.out.println("Account Created: ~~~~~~~~~" + a.summary());
        break;
    }

    }

    void deposit() {
        String acc = view.ask("Account No: ");
        Account a = model.find(acc);
        if (a == null) { System.out.println("Not found."); return; }

        double amt = view.askDouble("Amount: ");
        Transaction t = model.makeTxn("DEPOSIT", amt, acc);
        if (a.deposit(amt, t)) System.out.println("Deposit OK");
        else System.out.println("Deposit FAILED");
    }

    void withdraw() {
        String acc = view.ask("Account No: ");
        Account a = model.find(acc);
        if (a == null) { System.out.println("Not found."); return; }

        double amt = view.askDouble("Amount: ");
        Transaction t = model.makeTxn("WITHDRAW", amt, acc);
        if (a.withdraw(amt, t)) System.out.println("Withdraw OK");
        else System.out.println("Withdraw FAILED");
    }

    void transfer() {
        String from = view.ask("From Account: ");
        String to = view.ask("To Account: ");
        double amt = view.askDouble("Amount: ");

        Account A = model.find(from);
        Account B = model.find(to);

        if (A == null || B == null) {
            System.out.println("Invalid account.");
            return;
        }

        Transaction t1 = model.makeTxn("TRANSFER", amt, from + "->" + to);
        if (!A.withdraw(amt, t1)) {
            System.out.println("Transfer Failed.");
            return;
        }

        Transaction t2 = model.makeTxn("TRANSFER", amt, from + "->" + to);
        B.deposit(amt, t2);

        System.out.println("Transfer Successful.");
    }

    void applyInterest() {
        model.applyInterestToAll();
        System.out.println("Interest Applied.");
    }

    void eod() {

        Report report = new Report();
        report.generate(model);
        report.print();

        // If you don't want to clear daily transactions, comment this
        // model.clearEOD();
    }


    void listAccounts() {
        System.out.println("\n--- Accounts ---");
        for (int i = 0; i < model.accCount; i++) {
            System.out.println(model.accounts[i].summary());
        }
    }

    void showAccountStatus() {
        String acc = view.ask("Enter Account Number: ");
        Account a = model.find(acc);

        if (a == null) {
            System.out.println("Account not found.");
            return;
        }

        String type = a.getClass().getSimpleName(); // SavingsAccount / SalaryAccount / etc.

        System.out.println("\n----- ACCOUNT STATUS -----");
        System.out.println("Account Number : " + a.accNumber);
        System.out.println("Holder Name    : " + a.holderName);
        System.out.println("Account Type   : " + type);
        System.out.println("Balance        : " + a.balance);
        System.out.println("Status         : " + a.status);
        System.out.println("---------------------------\n");
    }

    void showAllTransactions() {

        System.out.println("\n======= ALL BANK TRANSACTIONS =======\n");

        boolean hasTxns = false;
        for (int i = 0; i < model.accCount; i++) {
            Account a = model.accounts[i];
            if (a.txnCount > 0) {
                hasTxns = true;
                break;
            }
        }

        if (!hasTxns) {
            System.out.println("No transactions found in the bank today.");
            return;
        }

        for (int i = 0; i < model.accCount; i++) {
            Account a = model.accounts[i];
            for (int j = 0; j < a.txnCount; j++) {
                Transaction t = a.dailyTxns[j];
                if (t == null) continue;

                System.out.println(
                    "Txn ID: " + t.txnId +
                    " | Type: " + t.type +
                    " | Amount: " + t.amount +
                    " | Date: " + t.date +
                    " | Performed By: " + t.performedBy
                );
            }
        }

        System.out.println("\n=====================================\n");
    }
}

/* ------------------ MAIN ------------------ */

public class BankSystemAll {
    public static void main(String[] args) {

        BankModel model = new BankModel();
        BankView view = new BankView();
        BankController c = new BankController(model, view);

        boolean run = true;

        while (run) {
            view.menu();
            int ch = Integer.parseInt(view.sc.nextLine());

            switch (ch) {
                case 1: c.createAccount(); break;
                case 2: c.deposit(); break;
                case 3: c.withdraw(); break;
                case 4: c.transfer(); break;
                case 5: c.applyInterest(); break;
                case 6: c.eod(); break;
                case 7: c.listAccounts(); break;
                case 8: c.showAccountStatus(); break;
                case 9: c.showAllTransactions(); break;
                case 0: run = false; break;
                default: System.out.println("Invalid option!");
            }

            // Automatic salary inactivity check
            for (int i = 0; i < model.accCount; i++) {
                if (model.accounts[i] instanceof SalaryAccount) {
                    ((SalaryAccount)model.accounts[i]).checkInactive();
                }
            }
        }

        System.out.println("System Closed.");
    }
}
