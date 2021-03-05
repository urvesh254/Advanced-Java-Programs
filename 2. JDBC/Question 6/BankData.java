import java.sql.*;
import java.util.Scanner;

/* 
    Question :- Consider Bank table with attributes AccountNo,CustomerName, Balance, Phone and
    Address. Write a database application which allows insertion, updation and
    deletion of records in Bank table. Print values of all customers whose balance
    is greater than 20,000.
*/

public class BankData {
    static String database = "testdata";
    static String username = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost:3306/" + database;
    static Scanner sc = new Scanner(System.in);
    static Connection conn;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        // Getting the Connection object. 
        conn = DriverManager.getConnection(url, username, password);

        /* 
            Note :- First you want to create bankdata table with accountNO,	customerName, balance, phoneNo, address.
            After that you successfully run the program.
         */

        while (true) {
            System.out.println("\n\t\tBank Application");
            System.out.println("\n1. Insert data");
            System.out.println("2. Update data");
            System.out.println("3. Delete record");
            System.out.println("4. Print data (balance >= 20000)");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertData();
                    break;
                case 2:
                    updateData();
                    break;
                case 3:
                    deleteData();
                    break;
                case 4:
                    printData();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("\nYou enter wrong choice");
            }
        }
    }

    // Inserting the data in database.
    public static void insertData() throws Exception {
        String sql = "insert into bankdata values(?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        System.out.print("\nAccount No. : ");
        long accountNo = Long.parseLong(sc.next());
        System.out.print("Customer Name : ");
        String customerName = sc.next();
        System.out.print("Balance : ");
        long balance = Long.parseLong(sc.next());
        System.out.print("Phone No. : ");
        long phoneNo = Long.parseLong(sc.next());
        System.out.print("Address : ");
        String address = sc.next();

        pstmt.setLong(1, accountNo);
        pstmt.setString(2, customerName);
        pstmt.setLong(3, balance);
        pstmt.setLong(4, phoneNo);
        pstmt.setString(5, address);

        pstmt.executeUpdate();
        System.out.println("\n\nData inserted successfully.\n");
    }

    // Updating the data in database.
    // Currently this program update only balance. You can try with different attributes.
    public static void updateData() throws Exception {
        String sql = "update bankdata set balance=? WHERE accountNo=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        System.out.print("\nAccount No. : ");
        long accountNo = Long.parseLong(sc.next());

        System.out.print("\nEnter new Balance : ");
        long balance = Long.parseLong(sc.next());

        pstmt.setLong(1, balance);
        pstmt.setLong(2, accountNo);

        pstmt.executeUpdate();
        System.out.println("\n\nData updated successfully.");
    }

    // Deleting the data from database.
    public static void deleteData() throws Exception {
        String sql = "delete from bankdata WHERE accountNo=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        System.out.print("\nAccount No. : ");
        long accountNo = Long.parseLong(sc.next());
        pstmt.setLong(1, accountNo);

        pstmt.executeUpdate();
        System.out.println("\n\nData deleted successfully.");
    }

    // Printing recores from databse.
    public static void printData() throws Exception {
        String sql = "select * from bankdata where balance > 20000";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        System.out.println("Records with balance > 20000");
        String row;
        while (rs.next()) {
            row = String.format("Account No. = %s, Customer Name = %s, Balance = %s, Phone No. = %s, Address = %s",
                    rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            System.out.println(row);
        }
    }
}
