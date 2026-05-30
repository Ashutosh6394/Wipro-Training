package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankDAO {

    public void createAccount(String name, String userId, String password, double balance) {
        if (balance < 0) {
            System.out.println("Opening balance cannot be negative");
            return;
        }

        try {
            Connection con = DBConnection.getConnection();

            String sql = "insert into accounts(name, user_id, password, balance) values(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, userId);
            ps.setString(3, password);
            ps.setDouble(4, balance);

            ps.executeUpdate();

            System.out.println("Account created successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deposit(int accountNo, double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero");
            return;
        }

        try {
            Connection con = DBConnection.getConnection();

            String sql = "update accounts set balance = balance + ? where account_no = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setInt(2, accountNo);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                addTransaction(accountNo, "Deposit", amount);
                System.out.println("Money deposited successfully");
            } else {
                System.out.println("Account not found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void withdraw(int accountNo, double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero");
            return;
        }

        try {
            Connection con = DBConnection.getConnection();

            String checkSql = "select balance from accounts where account_no = ?";

            PreparedStatement checkPs = con.prepareStatement(checkSql);
            checkPs.setInt(1, accountNo);

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");

                if (balance >= amount) {
                    String sql = "update accounts set balance = balance - ? where account_no = ?";

                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setDouble(1, amount);
                    ps.setInt(2, accountNo);

                    ps.executeUpdate();

                    addTransaction(accountNo, "Withdraw", amount);

                    System.out.println("Money withdrawn successfully");
                } else {
                    System.out.println("Insufficient balance");
                }

            } else {
                System.out.println("Account not found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void transfer(int fromAcc, int toAcc, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        if (fromAcc == toAcc) {
            System.out.println("Cannot transfer to same account");
            return;
        }

        try {
            Connection con = DBConnection.getConnection();
            con.setAutoCommit(false);

            String checkSql = "select balance from accounts where account_no = ?";
            PreparedStatement checkPs = con.prepareStatement(checkSql);
            checkPs.setInt(1, fromAcc);

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");

                if (balance >= amount) {
                    String receiverSql = "select account_no from accounts where account_no = ?";
                    PreparedStatement receiverPs = con.prepareStatement(receiverSql);
                    receiverPs.setInt(1, toAcc);

                    ResultSet receiverRs = receiverPs.executeQuery();

                    if (receiverRs.next()) {
                        PreparedStatement deductPs = con.prepareStatement(
                                "update accounts set balance = balance - ? where account_no = ?"
                        );
                        deductPs.setDouble(1, amount);
                        deductPs.setInt(2, fromAcc);
                        deductPs.executeUpdate();

                        PreparedStatement addPs = con.prepareStatement(
                                "update accounts set balance = balance + ? where account_no = ?"
                        );
                        addPs.setDouble(1, amount);
                        addPs.setInt(2, toAcc);
                        addPs.executeUpdate();

                        addTransaction(fromAcc, "Transfer Sent", amount);
                        addTransaction(toAcc, "Transfer Received", amount);

                        con.commit();

                        System.out.println("Transfer successful");

                    } else {
                        con.rollback();
                        System.out.println("Receiver account not found");
                    }

                } else {
                    con.rollback();
                    System.out.println("Insufficient balance");
                }

            } else {
                con.rollback();
                System.out.println("Sender account not found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void checkBalance(int accountNo) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "select account_no, name, balance from accounts where account_no = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accountNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Account No: " + rs.getInt("account_no"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Balance: " + rs.getDouble("balance"));
            } else {
                System.out.println("Account not found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewAccounts() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "select account_no, name, user_id, balance from accounts";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("---------------------");
                System.out.println("Account No: " + rs.getInt("account_no"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("User ID: " + rs.getString("user_id"));
                System.out.println("Balance: " + rs.getDouble("balance"));
            }

            if (!found) {
                System.out.println("No account found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewTransactions(int accountNo) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "select * from transactions where account_no = ? order by transaction_date desc";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accountNo);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("---------------------");
                System.out.println("Transaction ID: " + rs.getInt("transaction_id"));
                System.out.println("Account No: " + rs.getInt("account_no"));
                System.out.println("Type: " + rs.getString("type"));
                System.out.println("Amount: " + rs.getDouble("amount"));
                System.out.println("Date: " + rs.getTimestamp("transaction_date"));
            }

            if (!found) {
                System.out.println("No transaction found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void miniStatement(int accountNo) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "select * from transactions where account_no = ? order by transaction_date desc limit 5";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accountNo);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("---------------------");
                System.out.println("Transaction ID: " + rs.getInt("transaction_id"));
                System.out.println("Type: " + rs.getString("type"));
                System.out.println("Amount: " + rs.getDouble("amount"));
                System.out.println("Date: " + rs.getTimestamp("transaction_date"));
            }

            if (!found) {
                System.out.println("No transaction found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addTransaction(int accountNo, String type, double amount) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "insert into transactions(account_no, type, amount) values(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accountNo);
            ps.setString(2, type);
            ps.setDouble(3, amount);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}