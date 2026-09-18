CineBook – Movie Theatre Management System

# Overview

CineBook is a command-line based Movie Theatre Management System developed using Java.

The project simulates the basic process of booking movie tickets in a theatre. Users can view available movies and shows, check seat availability, book tickets, view booking details, and cancel bookings.

The main aim of the project is to apply Java and Object-Oriented Programming concepts in a practical application.

---

# Features

- View available movies with their details.
- View available shows and ticket prices.
- Check available seats for a selected show.
- Book one or more seats.
- Validate customer and booking inputs.
- Generate a booking ID for successful bookings.
- Calculate the total ticket amount automatically.
- Award loyalty points to regular customers.
- View booking details using a booking ID.
- Cancel a booking and release its seats.
- Save confirmed booking details in a text file.
- Handle invalid inputs without unexpectedly terminating the program.

---

# Java Concepts Used

- Classes and Objects – Used to represent movies, shows, customers, bookings, and the theatre.
- Constructors – Used to initialize objects with their required information.
- Encapsulation – Used through private data members and public methods.
- Inheritance – RegularCustomer extends Customer.
- Method Overriding – RegularCustomer overrides displayCustomer().
- Polymorphism – A Customer reference is used with a RegularCustomer object.
- Collections – List and ArrayList are used to manage movies, shows, bookings, and seats.
- Loops and Conditional Statements – Used for menu operations, seat checking, and validation.
- Exception Handling – Used to handle invalid input and file-related errors.
- File Handling – FileWriter is used to save booking details.

---

# Project Structure

CineBook/
│
├── src/
│   ├── Main.java
│   ├── Movie.java
│   ├── Show.java
│   ├── Customer.java
│   ├── RegularCustomer.java
│   ├── Booking.java
│   └── Theatre.java
│
└── data/
    └── bookings.txt

---

# Requirements

- Java Development Kit (JDK)
- Command Prompt or Terminal
- A Java-supported editor or IDE

The project was developed and tested using Java JDK 25.

To check the Java installation:

java -version

javac -version

---

# How to Run

Open the terminal in the main CineBook project folder.

## Compile the project

javac src/*.java

## Run the project

java -cp src Main

Run these commands from the main CineBook folder, not from inside the src folder.

---

# Using the Application

After running the program, the following menu is displayed:

========================================
              CINEBOOK
     MOVIE THEATRE MANAGEMENT SYSTEM
========================================
1. View Movies
2. View Shows
3. View Available Seats
4. Book Ticket
5. Cancel Ticket
6. View Booking
7. Exit
========================================

Enter the number of the required option.

For a new booking, select a show, enter the customer details, choose the number of seats, and select the required seat numbers.

After a successful booking, the system displays the booking ID, customer details, selected seats, number of tickets, total amount, and loyalty points earned.

A booking can later be viewed or cancelled using its booking ID.

---

# Booking Data

Confirmed bookings are stored locally in:

data/bookings.txt

The stored information includes the booking ID, customer name, phone number, movie, show time, selected seats, number of tickets, and total amount.

---

# Testing

The application was tested with normal and invalid inputs, including:	

- Viewing movies and shows.
- Checking available seats.
- Booking tickets.
- Calculating the ticket amount.
- Saving bookings to the text file.
- Viewing a booking.
- Cancelling a booking.
- Releasing cancelled seats.
- Entering invalid menu choices.
- Entering invalid numeric values.
- Entering an invalid phone number.
- Selecting invalid or already booked seats.

The tested operations worked as expected.

---

# Conclusion

CineBook is a simple Java-based theatre booking system that brings different programming concepts together in one practical application.

The project provided hands-on experience with classes, objects, constructors, inheritance, polymorphism, collections, exception handling, and file handling while implementing a complete command-line ticket booking process.