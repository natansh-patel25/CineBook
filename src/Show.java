import java.util.ArrayList;
import java.util.List;

public class Show {

    private String showId;
    private Movie movie;
    private String showTime;
    private int ticketPrice;
    private int totalSeats;
    private List<Integer> bookedSeats;

    public Show(String showId, Movie movie, String showTime, int ticketPrice, int totalSeats) {
        this.showId = showId;
        this.movie = movie;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
        this.totalSeats = totalSeats;
        this.bookedSeats = new ArrayList<>();
    }

    public String getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getShowTime() {
        return showTime;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public boolean isSeatAvailable(int seatNumber) {
        return seatNumber >= 1
                && seatNumber <= totalSeats
                && !bookedSeats.contains(seatNumber);
    }

    public boolean bookSeat(int seatNumber) {
        if (isSeatAvailable(seatNumber)) {
            bookedSeats.add(seatNumber);
            return true;
        }

        return false;
    }

    public void releaseSeat(int seatNumber) {
        bookedSeats.remove(Integer.valueOf(seatNumber));
    }

    public void displayAvailableSeats() {
        System.out.println("\n========== AVAILABLE SEATS ==========");

        boolean found = false;

        for (int i = 1; i <= totalSeats; i++) {
            if (isSeatAvailable(i)) {
                System.out.print(i + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No seats available.");
        }

        System.out.println();
    }

    public void displayShow() {
        System.out.println("Show ID     : " + showId);
        System.out.println("Movie       : " + movie.getTitle());
        System.out.println("Show Time   : " + showTime);
        System.out.println("Ticket Price: Rs. " + ticketPrice);
        System.out.println("Total Seats : " + totalSeats);
    }
}