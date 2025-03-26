package hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
public class Customer {
	public static void registerCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter ID Proof: ");
        String idProof = scanner.nextLine();

        String sql = "INSERT INTO customers (name, contact, id_proof) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, contact);
            stmt.setString(3, idProof);
            stmt.executeUpdate();
            System.out.println("✅ Customer Registered Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
