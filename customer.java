import java.sql.*;
import java.util.Scanner;

public class customer{

    // Database URL, username and password
    static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    static final String USER = "root";  // replace with your database username
    static final String PASS = "";      // replace with your database password

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            if (conn != null) {
                System.out.println("Connected to the database!");

                while (true) {
                    System.out.println("Choose an operation: ");
                    System.out.println("1. Insert a customer");
                    System.out.println("2. Read all customers");
                    System.out.println("3. Exit");
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // consume newline

                    switch (choice) {
                        case 1:
                            insertCustomer(conn, scanner);
                            break;
                        case 2:
                            readCustomers(conn);
                            break;
                        case 3:
                            System.out.println("Exiting...");
                            return;
                        default:
                            System.out.println("Invalid choice. Try again.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertCustomer(Connection conn, Scanner scanner) {
        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter Email:");
        String email = scanner.nextLine();
        System.out.println("Enter Phone:");
        String phone = scanner.nextLine();

        String sql = "INSERT INTO Customers (FirstName, LastName, Email, Phone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("A new customer was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void readCustomers(Connection conn) {
        String sql = "SELECT * FROM Customers";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("CustomerID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");

                System.out.printf("CustomerID: %d, FirstName: %s, LastName: %s, Email: %s, Phone: %s%n",
                        id, firstName, lastName, email, phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
