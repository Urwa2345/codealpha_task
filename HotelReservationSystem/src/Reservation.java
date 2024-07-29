public class Reservation {
    private Room room;
    private String userName;
    private String paymentDetails;

    public Reservation(Room room, String userName, String paymentDetails) {
        this.room = room;
        this.userName = userName;
        this.paymentDetails = paymentDetails;
    }

    public Room getRoom() {
        return room;
    }

    public String getUserName() {
        return userName;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }
}
