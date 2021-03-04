import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

/* 
    Question :- Write a program using JDBC for getting personal information – name, birthdate sex, address, phone no, email-id & store it in database. Also provide list of all records, all male, all female & all minors (age below 18)
*/

public class GatheringInformation {
    static String database = "testdata";
    static String username = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost:3306/" + database;
    static Connection conn;

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        // Getting the Connection object. 
        conn = DriverManager.getConnection(url, username, password);

        // Task 1 : Gathering Information and store in the database. 
        gatheringInfo();

        // Task 2 : Print all records.
        printAllRecords();

        // Task 3 : Print only male records.
        printOnlyMale();

        // Task 3 : Print only female records.
        printOnlyFemale();

        // Task 4 : Print only minors records.
        printOnlyMinors();

        conn.close();
    }

    // Adding the personal info in personalinfo table.
    // Note :- Before running that you want to create personalinfo table first with name, birthdate, sex , address, phone no, email-id.
    public static void gatheringInfo() throws Exception {

        String sqlQuery = "insert into personalinfo values(?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
        java.util.Date date;

        pstmt.setString(1, "Urvesh");
        date = new SimpleDateFormat("dd-MM-yyyy").parse("25-4-2001");
        pstmt.setDate(2, new java.sql.Date(date.getTime()));
        pstmt.setString(3, "male");
        pstmt.setString(4, "Gandhinagar");
        pstmt.setLong(5, Long.parseLong("1234567890"));
        pstmt.setString(6, "urvesh@gmail.com");
        pstmt.addBatch();

        pstmt.setString(1, "Dhruv");
        date = new SimpleDateFormat("dd-MM-yyyy").parse("23-01-2000");
        pstmt.setDate(2, new java.sql.Date(date.getTime()));
        pstmt.setString(3, "male");
        pstmt.setString(4, "Ahmedabad");
        pstmt.setLong(5, Long.parseLong("2345678901"));
        pstmt.setString(6, "dhruv@gmail.com");
        pstmt.addBatch();

        pstmt.setString(1, "Dhruvil");
        date = new SimpleDateFormat("dd-MM-yyyy").parse("04-11-2005");
        pstmt.setDate(2, new java.sql.Date(date.getTime()));
        pstmt.setString(3, "male");
        pstmt.setString(4, "Ahmedabad");
        pstmt.setLong(5, Long.parseLong("3456789012"));
        pstmt.setString(6, "dhruvil@gmail.com");
        pstmt.addBatch();

        pstmt.setString(1, "Nirja");
        date = new SimpleDateFormat("dd-MM-yyyy").parse("11-08-2000");
        pstmt.setDate(2, new java.sql.Date(date.getTime()));
        pstmt.setString(3, "female");
        pstmt.setString(4, "Gandhinagar");
        pstmt.setLong(5, Long.parseLong("4567890123"));
        pstmt.setString(6, "nirja@gmail.com");
        pstmt.addBatch();

        pstmt.setString(1, "Khushi");
        date = new SimpleDateFormat("dd-MM-yyyy").parse("25-12-2000");
        pstmt.setDate(2, new java.sql.Date(date.getTime()));
        pstmt.setString(3, "female");
        pstmt.setString(4, "Ahmedabad");
        pstmt.setLong(5, Long.parseLong("5678901234"));
        pstmt.setString(6, "khushi@gmail.com");
        pstmt.addBatch();

        int[] rows = pstmt.executeBatch();
        System.out.println("Rows affeted : " + Arrays.toString(rows));

    }

    public static void printAllRecords() throws Exception {
        String sqlQuery = "select * from personalinfo";
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sqlQuery);

        System.out.println("\nPrinting all Records: ");
        String row;
        while (rs.next()) {
            row = String.format("Name = %s, birthdate = %s, sex = %s, address = %s, phone no = %s, email-id = %s",
                    rs.getString("name"), rs.getString("birthdate"), rs.getString("sex"), rs.getString("address"),
                    rs.getString("phoneNo"), rs.getString("emailID"));
            System.out.println(row);
        }
    }

    public static void printOnlyMale() throws Exception {
        String sqlQuery = "select * from personalinfo where sex='male'";
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sqlQuery);

        System.out.println("\n\nPrinting only Male Records: ");
        String row;
        while (rs.next()) {
            row = String.format("Name = %s, birthdate = %s, sex = %s, address = %s, phone no = %s, email-id = %s",
                    rs.getString("name"), rs.getString("birthdate"), rs.getString("sex"), rs.getString("address"),
                    rs.getString("phoneNo"), rs.getString("emailID"));
            System.out.println(row);
        }
    }

    public static void printOnlyFemale() throws Exception {
        String sqlQuery = "select * from personalinfo where sex='female'";
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sqlQuery);

        System.out.println("\n\nPrinting only Female Records: ");
        String row;
        while (rs.next()) {
            row = String.format("Name = %s, birthdate = %s, sex = %s, address = %s, phone no = %s, email-id = %s",
                    rs.getString("name"), rs.getString("birthdate"), rs.getString("sex"), rs.getString("address"),
                    rs.getString("phoneNo"), rs.getString("emailID"));
            System.out.println(row);
        }
    }

    public static void printOnlyMinors() throws Exception {
        String sqlQuery = "select * from personalinfo";
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sqlQuery);

        System.out.println("\n\nPrinting only Minors Records: ");
        int currentYear = LocalDate.now().getYear();
        String row;
        while (rs.next()) {
            int birthdateYear = LocalDate.parse(rs.getString("birthdate")).getYear();
            if (currentYear - birthdateYear < 18) {
                row = String.format("Name = %s, birthdate = %s, sex = %s, address = %s, phone no = %s, email-id = %s",
                        rs.getString("name"), rs.getString("birthdate"), rs.getString("sex"), rs.getString("address"),
                        rs.getString("phoneNo"), rs.getString("emailID"));
                System.out.println(row);
            }
        }
    }
}
