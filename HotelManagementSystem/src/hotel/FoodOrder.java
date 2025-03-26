package hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class FoodOrder {
    public static void orderFood() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Booking ID: ");
        int bookingId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Food Item: ");
        String foodItem = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        String sql = "INSERT INTO food_orders (booking_id, food_item, price) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookingId);
            stmt.setString(2, foodItem);
            stmt.setDouble(3, price);
            stmt.executeUpdate();
            System.out.println("✅ Food Order Placed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
