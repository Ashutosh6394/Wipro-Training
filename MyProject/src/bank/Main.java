package bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankDAO bankDao = new BankDAO();
        LoginService loginDao = new LoginService();

        while (true) {
            System.out.println("\n===== Bank Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                sc.nextLine();

                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Create user id: ");
                String userId = sc.nextLine();

                System.out.print("Create password: ");
                String password = sc.nextLine();

                System.out.print("Enter opening balance: ");
                double balance = sc.nextDouble();

                bankDao.createAccount(name, userId, password, balance);

            } else if (choice == 2) {
                sc.nextLine();

                System.out.print("Enter user id: ");
                String userId = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                int accountNo = loginDao.login(userId, password);

                if (accountNo != -1) {
                    System.out.println("Login successful");

                    while (true) {
                        System.out.println("\n===== User Menu =====");
                        System.out.println("1. Deposit Money");
                        System.out.println("2. Withdraw Money");
                        System.out.println("3. Check Balance");
                        System.out.println("4. View All Accounts");
                        System.out.println("5. View Transactions");
                        System.out.println("6. Mini Statement");
                        System.out.println("7. Transfer Money");
                        System.out.println("8. Logout");
                        System.out.print("Enter your choice: ");

                        int userChoice = sc.nextInt();

                        if (userChoice == 1) {
                            System.out.print("Enter amount: ");
                            double amount = sc.nextDouble();

                            bankDao.deposit(accountNo, amount);

                        } else if (userChoice == 2) {
                            System.out.print("Enter amount: ");
                            double amount = sc.nextDouble();

                            bankDao.withdraw(accountNo, amount);

                        } else if (userChoice == 3) {
                            bankDao.checkBalance(accountNo);

                        } else if (userChoice == 4) {
                            bankDao.viewAccounts();

                        } else if (userChoice == 5) {
                            bankDao.viewTransactions(accountNo);

                        } else if (userChoice == 6) {
                            bankDao.miniStatement(accountNo);

                        } else if (userChoice == 7) {
                            System.out.print("Enter receiver account number: ");
                            int toAcc = sc.nextInt();

                            System.out.print("Enter amount: ");
                            double amount = sc.nextDouble();

                            bankDao.transfer(accountNo, toAcc, amount);

                        } else if (userChoice == 8) {
                            System.out.println("Logout successful");
                            break;

                        } else {
                            System.out.println("Invalid choice");
                        }
                    }

                } else {
                    System.out.println("Invalid user id or password");
                }

            } else if (choice == 3) {
                System.out.println("Thank you");
                break;

            } else {
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}