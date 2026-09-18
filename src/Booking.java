import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Booking {

    private String bookingId;
    private Customer customer;
    private Show show;
    private List<Integer> seats;
    private double totalAmount;

    public Booking(String bookingId, Customer customer, Show show, List<Integer> seats) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.show = show;
        this.seats = new ArrayList<>(seats);
        this.totalAmount = seats.size() * show.getTicketPrice();
    }

    public String getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Show getShow() {
        return show;
    }

    public List<Integer> getSeats() {
        return seats;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void displayBooking() {

        System.out.println("----------------------------------------");
        System.out.println("          BOOKING DETAILS");
        System.out.println("----------------------------------------");
        System.out.println("Booking ID   : " + bookingId);
        System.out.println("Customer     : " + customer.getName());
        System.out.println("Movie        : " + show.getMovie().getTitle());
        System.out.println("Show Time    : " + show.getShowTime());
        System.out.println("Seats        : " + seats);
        System.out.println("Tickets      : " + seats.size());
        System.out.println("Total Amount : Rs. " + totalAmount);
        System.out.println("----------------------------------------");
    }

    public void saveToFile() {

        try (FileWriter writer = new FileWriter("data/bookings.txt", true)) {

            writer.write("========================================\n");
            writer.write("Booking ID   : " + bookingId + "\n");
            writer.write("Customer     : " + customer.getName() + "\n");
            writer.write("Phone        : " + customer.getPhoneNumber() + "\n");
            writer.write("Movie        : " + show.getMovie().getTitle() + "\n");
            writer.write("Show Time    : " + show.getShowTime() + "\n");
            writer.write("Seats        : " + seats + "\n");
            writer.write("Tickets      : " + seats.size() + "\n");
            writer.write("Total Amount : Rs. " + totalAmount + "\n");
            writer.write("========================================\n\n");

        } catch (IOException e) {

            System.out.println("Unable to save booking to file.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}