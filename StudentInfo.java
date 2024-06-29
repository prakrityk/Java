import java.sql.*;

public class StudentInfo {

    // Database URL, username, and password
    static final String DB_URL = "jdbc:mysql://localhost:3306/College";
    static final String USER = "root";  // replace with your database username
    static final String PASS = "";      // replace with your database password

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            if (conn != null) {
                System.out.println("Connected to the database!");

                // Insert a record into the Student table
                insertStudent(conn);

                // Update the program from BCIS to BBA for the inserted record
                updateStudentProgram(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertStudent(Connection conn) {
        String insertSQL = "INSERT INTO Student (s_id, name, address, gender, program) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setInt(1, 1);
            pstmt.setString(2, "Sam");
            pstmt.setString(3, "Kathmandu");
            pstmt.setString(4, "male");
            pstmt.setString(5, "BCIS");

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new student record was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateStudentProgram(Connection conn) {
        String updateSQL = "UPDATE Student SET program = ? WHERE s_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, "BBA");
            pstmt.setInt(2, 1);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student program was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
