import java.util.*;
import java.util.Scanner;
                                             
class BankAccount 
{
    private double Balance;  

    public BankAccount(double initialBalance)
    {
        this.Balance = initialBalance;
    }

    public double returnbalance() 
    {
        return Balance;
    }

    public void deposit(double amount) 
    {
        if (amount > 0)
        {
            Balance += amount;
            System.out.println("Successfully Deposited. Updated Balance: Rs." + Balance);
        } 
        else
        {
            System.out.println("Invalid Amount");
        }
    }

    public boolean withdraw(double amount)
    {
        if (amount > 0)
        {
            if (amount <= Balance) 
            {
                Balance -= amount;
                System.out.println("Withdrawal Successful. Updated Balance: Rs." + Balance);
                return true;
            }
            else 
            {
                System.out.println("Insufficient funds for withdrawal. Current Balance: Rs." + Balance);
            }
        }
        else
        {
            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
        }
        return false;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) 
    {
        this.bankAccount = bankAccount;
    }

    public void display() {
        System.out.println("*****************   ATM Menu   *****************");
        System.out.println("\t\t 1: Check Balance");
        System.out.println("\t\t 2: Deposit");
        System.out.println("\t\t 3: Withdraw");
        System.out.println("\t\t 4: Exit");
    }

    public void run() 
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            display();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("Current Balance: Rs." + bankAccount.returnbalance());
                    break;
                case 2:
                    System.out.print("Enter the amount to be deposited: Rs.");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to be withdrawn: Rs.");
                    double withdrawalAmount = scanner.nextDouble();
                    boolean withdrawSuccess = bankAccount.withdraw(withdrawalAmount);
                    if (withdrawSuccess) {
                        System.out.println("Withdrawal successful.");
                    }
                    break;
                case 4:
                    System.out.println("Thank YOU!");
                    return;
                default:
                    System.out.println("Invalid Choice. Please Try again ");
            }
        }
    }
}

public class atminterface
{
    public static void main(String[] args)
    {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
