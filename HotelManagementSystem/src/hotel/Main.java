package hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n======= HOTEL MANAGEMENT SYSTEM =======");
            System.out.println("1. Register Customer");
            System.out.println("2. Allocate Room");
            System.out.println("3. Process Payment");
            System.out.println("4. Order Food");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    Customer.registerCustomer();
                    break;
                case 2:
                    Room.allocateRoom();
                    break;
                case 3:
                    Payment.processPayment();
                    break;
                case 4:
                    FoodOrder.orderFood();
                    break;
                case 5:
                    System.out.println("✅ Exiting... Thank you!");
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid Choice! Try again.");
            }
        }
    }
}
