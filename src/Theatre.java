import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private String theatreName;
    private List<Movie> movies;
    private List<Show> shows;
    private List<Booking> bookings;

    public Theatre(String theatreName) {
        this.theatreName = theatreName;
        this.movies = new ArrayList<>();
        this.shows = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public String getTheatreName() {
        return theatreName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Show> getShows() {
        return shows;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void displayMovies() {
        System.out.println("\n========== AVAILABLE MOVIES ==========");

        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);

            System.out.println((i + 1) + ". " + movie.getTitle()
                    + " | " + movie.getLanguage()
                    + " | " + movie.getGenre()
                    + " | " + movie.getDuration() + " min");
        }
    }

    public void displayShows() {
        System.out.println("\n============= SHOWS =============");

        for (int i = 0; i < shows.size(); i++) {
            Show show = shows.get(i);

            System.out.println((i + 1) + ". "
                    + show.getMovie().getTitle()
                    + " | " + show.getShowTime()
                    + " | Rs. " + show.getTicketPrice());
        }
    }

    public Booking findBooking(String bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equalsIgnoreCase(bookingId)) {
                return booking;
            }
        }

        return null;
    }

    public boolean cancelBooking(String bookingId) {

        Booking booking = findBooking(bookingId);

        if (booking != null) {

            Show show = booking.getShow();

            for (int seat : booking.getSeats()) {
                show.releaseSeat(seat);
            }

            bookings.remove(booking);
            return true;
        }

        return false;
    }
}