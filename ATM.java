import java.io.*;
import java.util.Scanner;

public class ATM{
    public static void main(String args[]) {
        int balance = 0;
        System.out.println("Current Balance = " + balance);
        Scanner sc = new Scanner(System.in);
        System.out.println("ATM MACHINE\n");
        int var;

        do {
            System.out.println("\nEnter one of the following options.\n");
            System.out.println("1. Withdraw\n2. Deposit\n3. Check Balance\n4. EXIT");
            var = sc.nextInt();

            switch (var) {
                case 1:
                    System.out.println("WITHDRAW\n\nCurrent Balance = " + balance);
                    if (balance == 0) {
                        System.out.println("Nothing to withdraw");
                    } else {
                        System.out.println("Enter amount to be withdrawn:");
                        int withdraw = sc.nextInt();
                        if (withdraw > balance) {
                            System.out.println("Please enter an amount less than your existing balance.");
                        }
                        else{
                            balance = balance - withdraw;
                            System.out.println("Current Balance = " + balance);
                        }
                    }
                    break;

                case 2:
                    System.out.println("DEPOSIT\nEnter amount to deposit:");
                    int deposit = sc.nextInt();
                    balance = balance + deposit;
                    System.out.println("Balance after depositing = " + balance);
                    break;

                case 3:
                    System.out.println("CHECK BALANCE");
                    System.out.println("Current Balance = " + balance);
                    break;

                case 4:
                    System.out.println("EXIT");
                    break;

                default:
                    System.out.println("Please enter a valid number");
            }
        } while (var != 4);
        sc.close();
    }
}
