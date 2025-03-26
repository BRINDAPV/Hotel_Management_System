package hotel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Room {
    public static void allocateRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Booking ID: ");
        int bookingId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Room Type (Single/Double/Suite): ");
        String roomType = scanner.nextLine();

        String sql = "SELECT room_id FROM rooms WHERE room_type = ? AND status = 'Available' LIMIT 1";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, roomType);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int roomId = rs.getInt("room_id");
                String updateSQL = "UPDATE rooms SET status = 'Occupied' WHERE room_id = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {
                    updateStmt.setInt(1, roomId);
                    updateStmt.executeUpdate();
                    System.out.println("✅ Room Allocated: Room ID " + roomId);
                }
            } else {
                System.out.println("❌ No available rooms of type: " + roomType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
