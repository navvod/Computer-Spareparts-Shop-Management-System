package computerSpare;

//Class representing Feedback entity
public class Feedback {

 // Instance variables encapsulating the state of a Feedback
 private static int idbooking;   // Encapsulation
 private String date;
 private String name;
 private String feedback;

 // Constructor for initializing Feedback instances
 public Feedback(int feedbackId, String feedbackDate, String feedbackName, String feedbackText) {
     // 'this' keyword for disambiguation
     this.idbooking = feedbackId;
     this.date = feedbackDate;
     this.name = feedbackName;
     this.feedback = feedbackText;
 }

 // Default constructor
 public Feedback() {
     // TODO Auto-generated constructor stub
 }

 // Getter methods to access the state of a Feedback
 // Encapsulation: Restricting direct access to variables
 public int getId() {
     return idbooking;
 }

 public String getDate() {
     return date;
 }

 public String getName() {
     return name;
 }

 public String getFeedback() {
     return feedback;
 }
}
