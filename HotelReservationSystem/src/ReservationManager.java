import java.util.ArrayList;

public class ReservationManager {
    private ArrayList<Reservation> reservations;
    private RoomManager roomManager;
    private PaymentProcessor paymentProcessor;

    public ReservationManager(RoomManager roomManager) {
        this.roomManager = roomManager;
        this.reservations = new ArrayList<>();
        this.paymentProcessor = new PaymentProcessor();
    }

    public boolean makeReservation(int roomNumber, String userName, String paymentDetails) {
        Room room = roomManager.getRoom(roomNumber);
        if (room != null && room.isAvailable() && paymentProcessor.processPayment(paymentDetails)) {
            Reservation reservation = new Reservation(room, userName, paymentDetails);
            reservations.add(reservation);
            room.setAvailable(false);
            return true;
        }
        return false;
    }

    public void viewBookingDetails(String userName) {
        for (Reservation reservation : reservations) {
            if (reservation.getUserName().equals(userName)) {
                Room room = reservation.getRoom();
                System.out.println("Booking Details for " + userName + ":");
                System.out.println("Room Number: " + room.getRoomNumber() + ", Category: " + room.getCategory() + ", Price: " + room.getPrice());
                return;
            }
        }
        System.out.println("No booking found for " + userName);
    }
}
