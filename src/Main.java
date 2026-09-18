import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Theatre theatre;
    private static int bookingCounter = 1001;

    public static void main(String[] args) {

        setupTheatre();

        boolean running = true;

        while (running) {

            displayMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    theatre.displayMovies();
                    break;

                case 2:
                    theatre.displayShows();
                    break;

                case 3:
                    displayAvailableSeats();
                    break;

                case 4:
                    bookTicket();
                    break;

                case 5:
                    cancelTicket();
                    break;

                case 6:
                    viewBooking();
                    break;

                case 7:
                    running = false;
                    System.out.println("\nThank you for using CineBook!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please select 1-7.");
            }
        }

        scanner.close();
    }

    private static void setupTheatre() {

        theatre = new Theatre("CineBook Multiplex");

        Movie movie1 = new Movie(
                "M101",
                "Avengers",
                "English",
                "Action",
                180
        );

        Movie movie2 = new Movie(
                "M102",
                "The Batman",
                "English",
                "Action",
                176
        );

        Movie movie3 = new Movie(
                "M103",
                "3 Idiots",
                "Hindi",
                "Comedy",
                170
        );

        theatre.addMovie(movie1);
        theatre.addMovie(movie2);
        theatre.addMovie(movie3);

        Show show1 = new Show(
                "S101",
                movie1,
                "06:30 PM",
                180,
                30
        );

        Show show2 = new Show(
                "S102",
                movie2,
                "09:30 PM",
                200,
                30
        );

        Show show3 = new Show(
                "S103",
                movie3,
                "03:00 PM",
                150,
                30
        );

        theatre.addShow(show1);
        theatre.addShow(show2);
        theatre.addShow(show3);
    }

    private static void displayMenu() {

        System.out.println("\n========================================");
        System.out.println("              CINEBOOK");
        System.out.println("     MOVIE THEATRE MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. View Movies");
        System.out.println("2. View Shows");
        System.out.println("3. View Available Seats");
        System.out.println("4. Book Ticket");
        System.out.println("5. Cancel Ticket");
        System.out.println("6. View Booking");
        System.out.println("7. Exit");
        System.out.println("========================================");
    }

    private static void displayAvailableSeats() {

        theatre.displayShows();

        int showChoice = readInt("Select show number: ");

        if (showChoice < 1 || showChoice > theatre.getShows().size()) {
            System.out.println("Invalid show selection.");
            return;
        }

        Show selectedShow = theatre.getShows().get(showChoice - 1);

        selectedShow.displayAvailableSeats();
    }

    private static void bookTicket() {

        System.out.println("\n========== BOOK TICKET ==========");

        theatre.displayShows();

        int showChoice = readInt("Select show number: ");

        if (showChoice < 1 || showChoice > theatre.getShows().size()) {
            System.out.println("Invalid show selection.");
            return;
        }

        Show selectedShow = theatre.getShows().get(showChoice - 1);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            return;
        }

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        if (!phoneNumber.matches("\\d{10}")) {
            System.out.println("Please enter a valid 10-digit phone number.");
            return;
        }

        selectedShow.displayAvailableSeats();

        int numberOfSeats = readInt("Enter number of seats: ");

        if (numberOfSeats <= 0) {
            System.out.println("Number of seats must be greater than zero.");
            return;
        }

        if (numberOfSeats > selectedShow.getTotalSeats()
                - selectedShow.getBookedSeats().size()) {

            System.out.println("Not enough seats available.");
            return;
        }

        List<Integer> selectedSeats = new ArrayList<>();

        for (int i = 1; i <= numberOfSeats; i++) {

            int seatNumber = readInt("Select seat " + i + ": ");

            if (!selectedShow.isSeatAvailable(seatNumber)) {
                System.out.println("Seat " + seatNumber
                        + " is not available.");
                return;
            }

            if (selectedSeats.contains(seatNumber)) {
                System.out.println("Seat " + seatNumber
                        + " was already selected.");
                return;
            }

            selectedSeats.add(seatNumber);
        }

        for (int seat : selectedSeats) {
            selectedShow.bookSeat(seat);
        }

        Customer customer = new RegularCustomer(
                "C" + bookingCounter,
                name,
                phoneNumber,
                0
        );

        String bookingId = "BK" + bookingCounter++;

        Booking booking = new Booking(
                bookingId,
                customer,
                selectedShow,
                selectedSeats
        );

        theatre.addBooking(booking);
        booking.saveToFile();

        if (customer instanceof RegularCustomer) {

            RegularCustomer regularCustomer =
                    (RegularCustomer) customer;

            regularCustomer.addLoyaltyPoints(numberOfSeats * 10);
        }

        System.out.println("\n========== BOOKING CONFIRMED ==========");

        booking.displayBooking();

        if (customer instanceof RegularCustomer) {

            RegularCustomer regularCustomer =
                    (RegularCustomer) customer;

            System.out.println("Loyalty Points Earned: "
                    + regularCustomer.getLoyaltyPoints());
        }

        System.out.println("\n========================================");
        System.out.println("       THANK YOU FOR BOOKING!");
        System.out.println("========================================");
        System.out.println("Press Enter to return to the main menu...");
        scanner.nextLine();
    }

    private static void cancelTicket() {

        System.out.println("\n========== CANCEL TICKET ==========");

        System.out.print("Enter booking ID: ");
        String bookingId = scanner.nextLine();

        boolean cancelled = theatre.cancelBooking(bookingId);

        if (cancelled) {
            System.out.println("Booking " + bookingId
                    + " cancelled successfully.");
        } else {
            System.out.println("Booking not found.");
        }
    }

    private static void viewBooking() {

        System.out.println("\n========== VIEW BOOKING ==========");

        System.out.print("Enter booking ID: ");
        String bookingId = scanner.nextLine();

        Booking booking = theatre.findBooking(bookingId);

        if (booking != null) {
            booking.displayBooking();
        } else {
            System.out.println("Booking not found.");
        }
    }

    private static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}