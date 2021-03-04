import java.sql.*;

/* 
    Question :- Write database application that prints different records from a table. Find
    out the name of table, no. of columns, no. of records and type of the columns.
*/

public class MetaDataDemo {
    static String database = "testdata";
    static String username = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost:3306/" + database;
    static Connection conn;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        // Getting the Connection object. 
        conn = DriverManager.getConnection(url, username, password);

        // Task 1 : Print all records of table.
        printAllRecords();

        // Task 2 : Print meta data of table.
        printMetaData();
    }

    // Note :- Here you can get data from any table you created before. I select student table.
    public static void printAllRecords() throws Exception {
        String sqlQuery = "select * from student";
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sqlQuery);

        String row;
        System.out.println("\nPrinting All Student table records.");
        while (rs.next()) {
            row = String.format("Name = %s, Roll No. = %s, Branch = %s", rs.getString(1), rs.getString(2),
                    rs.getString(3));
            System.out.println(row);
        }

    }

    public static void printMetaData() throws Exception {
        String sqlQuery = "select * from student";
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sqlQuery);

        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("\n=> Table Info.");
        System.out.println("Table Name : " + rsmd.getTableName(1));
        System.out.println("No. of Column : " + rsmd.getColumnCount());
        System.out.println("Colums name and type : ");
        System.out.println("\t" + rsmd.getColumnName(1) + " -> " + rsmd.getColumnTypeName(1));
        System.out.println("\t" + rsmd.getColumnName(2) + " -> " + rsmd.getColumnTypeName(2));
        System.out.println("\t" + rsmd.getColumnName(3) + " -> " + rsmd.getColumnTypeName(3));

        int rows = 0;
        while (rs.next()) {
            rows++;
        }
        System.out.print("No. of Records : " + rows);

    }
}
