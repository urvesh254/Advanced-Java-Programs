import java.sql.*;
import java.util.Arrays;

/* 
 - Question :- Write code to insert three records into student table using PreparedStatement (assume
student table with Name, RollNo, and Branch field ).
 */

public class PreparedStatementDemo {
    public static void main(String[] args) throws Exception {
        String database = "testdata";
        String username = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/" + database;
        Connection conn;

        Class.forName("com.mysql.jdbc.Driver");

        // Getting the Connection object. 
        conn = DriverManager.getConnection(url, username, password);

        String sql = "insert into student values(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Adding first data in batch.
        pstmt.setString(1, "Urvesh");
        pstmt.setInt(2, 25);
        pstmt.setString(3, "CE");
        pstmt.addBatch();

        // Adding second data in batch.
        pstmt.setString(1, "Dhruv");
        pstmt.setInt(2, 73);
        pstmt.setString(3, "CE");
        pstmt.addBatch();

        // Adding third data in batch.
        pstmt.setString(1, "Dhruvil");
        pstmt.setInt(2, 91);
        pstmt.setString(3, "CE");
        pstmt.addBatch();

        int[] rows = pstmt.executeBatch();
        System.out.println("rows = " + Arrays.toString(rows));

        conn.close();
    }
}