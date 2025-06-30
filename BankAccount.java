import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private long accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    Account(String accountHolder, long accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited:" + amount);
            System.out.println(amount + " Deposited successfully.");
        } else {
            System.out.println("Invalid Amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdraw:" + amount);
            System.out.println(amount + " Withdraw successfully.");
        } else {
            System.out.println("Invalid amount or Insufficient balance.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance:" + balance);
    }

    public void showTransactionHistory() {
        System.out.println("\nTransaction History");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void accountDetails() {
        System.out.println("\nAccount Details:");
        System.out.println("Account Holder Name:" + accountHolder);
        System.out.println("Account Number:" + accountNumber);
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the account Holder name:");
        String name = sc.nextLine();
        System.out.print("Enter the account number:");
        long acc_no = sc.nextLong();
        Account account = new Account(name, acc_no);
        int ch;
        do {
            System.out.println("\n====Bank Menu=====");
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Check Balance");
            System.out.println("4.View Your Transaction History");
            System.out.println("5.View Account Details");
            System.out.println("6.Exit");
            System.out.print("Choose an option(1-6):");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter amount to deposit:");
                    double dep_amt = sc.nextDouble();
                    account.deposit(dep_amt);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw:");
                    double with_amt = sc.nextDouble();
                    account.withdraw(with_amt);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    account.accountDetails();
                    break;
                case 6:
                    System.out.println("Thank you for using our Bank!");
                    break;
                default:
                    System.out.println("Invalid Option. Try again.");
            }
        } while (ch != 6);

    }
}
