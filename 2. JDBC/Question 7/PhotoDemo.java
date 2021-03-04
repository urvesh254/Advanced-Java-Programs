import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.Thread.State;
import java.sql.*;

/* 
    Question :- Write a JDBC program to insert and retrieve photo in database. (Hint: Use
    LongBlob datatype to store image in database)

*/

public class PhotoDemo {
    static String database = "testdata";
    static String username = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost:3306/" + database;
    static Connection conn;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        // Getting the Connection object. 
        conn = DriverManager.getConnection(url, username, password);

        // Insert photo in the databse.
        insertPhoto();

        // Retrive photo from the database.
        retrivePhoto();
    }

    // Note : First you want to create table with name as varchar and photo as LongBlob datatype.
    public static void insertPhoto() throws Exception {
        String sqlQuery = "insert into photodemo values(?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
        FileInputStream photo = new FileInputStream("Urvesh.png");

        pstmt.setString(1, "Urvesh");
        pstmt.setBlob(2, photo);

        int row = pstmt.executeUpdate();
        System.out.println("Photo is inserted in the database.");
        System.out.println("Row affected : " + row);
    }

    public static void retrivePhoto() throws Exception {
        String sqlQuery = "select * from photodemo";
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sqlQuery);

        while (rs.next()) {
            String fileName = rs.getString("name") + "_database.png";

            // Retriving blob file of photo from database. 
            Blob blobPhoto = rs.getBlob("photo");

            // Converting blob file into bytes array. 
            byte[] photoInBytes = blobPhoto.getBytes(1, (int) blobPhoto.length());

            // Write this byte array in file.
            FileOutputStream photo = new FileOutputStream(fileName);
            photo.write(photoInBytes);
        }

        System.out.println("\nPhots is retrive from the database.");
    }
}
