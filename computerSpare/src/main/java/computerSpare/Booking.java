package computerSpare;

//Class representing a Booking entity
public class Booking {

 // Instance variables encapsulating the state of a Booking
 private int idbooking;      // Encapsulation
 private String date;
 private String destination;
 private String requests;

 // Parameterized constructor for initializing Booking instances
 // Constructor Overloading: Multiple constructors for flexibility
 public Booking(int bookingId, String date, String destination, String requests) {
     this.idbooking = bookingId;   // 'this' keyword for disambiguation
     this.date = date;
     this.destination = destination;
     this.requests = requests;
 }

 // Default constructor (optional, based on your needs)
 public Booking() {
     // You can leave it empty or remove it if not needed
 }

 // Getter methods to access the state of a Booking
 // Encapsulation: Restricting direct access to variables
 public int getId() {
     return idbooking;
 }

 public String getDate() {
     return date;
 }

 public String getDestination() {
     return destination;
 }

 public String getRequests() {
     return requests;
 }
}
