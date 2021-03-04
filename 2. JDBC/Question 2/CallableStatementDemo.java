import java.sql.*;

/* 
 - Question :- Write a procedure to insert a row into the table student(roll_no,name,branch)
    and call it using callable statement in JDBC application. ?
 */

public class CallableStatementDemo {
    public static void main(String[] args) throws Exception {
        String database = "testdata";
        String username = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/" + database;
        Connection conn;

        Class.forName("com.mysql.jdbc.Driver");

        // Getting the Connection object. 
        conn = DriverManager.getConnection(url, username, password);
        /* 
            -> First create Procedure in database.
        
            CREATE PROCEDURE insertRow(IN name VARCHAR(30), IN rollno INT(10), IN branch VARCHAR(30))
            BEGIN
            INSERT INTO student VALUES(name, rollno, branch);
            END
        */

        CallableStatement clstmt;
        clstmt = conn.prepareCall("CALL insertRow(?,?,?)");
        clstmt.setString(1, "Neel");
        clstmt.setInt(2, 1);
        clstmt.setString(3, "CE");

        int row = clstmt.executeUpdate();
        System.out.println("Row affected : " + row);

        conn.close();
    }
}
