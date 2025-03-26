package hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Payment {
    public static void processPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Booking ID: ");
        int bookingId = scanner.nextInt();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();

        String sql = "INSERT INTO payments (booking_id, amount, payment_status) VALUES (?, ?, 'Paid')";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookingId);
            stmt.setDouble(2, amount);
            stmt.executeUpdate();
            System.out.println("✅ Payment Successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
