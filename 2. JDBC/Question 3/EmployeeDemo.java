import java.sql.*;

/* 
    Question :- Write Java application program to change the basic = basic + 500 of all the
    employees whose age is greater than 40 from employee table then display how many record updated.
 */

public class EmployeeDemo {
    static String database = "testdata";
    static String username = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost:3306/" + database;
    static Connection conn;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        // Getting the Connection object. 
        conn = DriverManager.getConnection(url, username, password);

        // Note :- First you want to create the employee table with name, age and salary and add some rows.
        // After that you run this program successfully.

        Statement stmt = conn.createStatement();
        String sqlQuery = "update employee set salary=salary+500 where age>40";

        int rows = stmt.executeUpdate(sqlQuery);

        System.out.println("Records updated = " + rows);

        conn.close();
    }
}