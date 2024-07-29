import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {
        RoomManager roomManager = new RoomManager();
        ReservationManager reservationManager = new ReservationManager(roomManager);
        Scanner scanner = new Scanner(System.in);

        // Add sample rooms
        roomManager.addRoom(new Room(101, "Single", 100.0));
        roomManager.addRoom(new Room(102, "Double", 150.0));
        roomManager.addRoom(new Room(201, "Suite", 250.0));

        while (true) {
            System.out.println("Welcome to the Hotel Reservation System");
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View booking details");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    roomManager.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your payment details: ");
                    String paymentDetails = scanner.nextLine();
                    if (reservationManager.makeReservation(roomNumber, name, paymentDetails)) {
                        System.out.println("Reservation successful!");
                    } else {
                        System.out.println("Reservation failed. Room may be unavailable or payment unsuccessful.");
                    }
                    break;
                case 3:
                    System.out.print("Enter your name: ");
                    scanner.nextLine();
                    String userName = scanner.nextLine();
                    reservationManager.viewBookingDetails(userName);
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
