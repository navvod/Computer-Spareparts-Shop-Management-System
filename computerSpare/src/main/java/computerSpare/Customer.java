package computerSpare;

//Class representing a Customer entity
public class Customer {

 // Instance variables encapsulating the state of a Customer
 private static int id;         // Encapsulation
 private String name;
 private String email;
 private String phone;
 private String userName;
 private String password;

 // Constructor for initializing Customer instances
 public Customer(int customerId, String customerName, String customerEmail, String customerPhone, String customerUserName, String customerPassword) {
     // 'this' keyword for disambiguation
     Customer.id = customerId;
     this.name = customerName;
     this.email = customerEmail;
     this.phone = customerPhone;
     this.userName = customerUserName;
     this.password = customerPassword;
 }

 // Getter methods to access the state of a Customer
 // Encapsulation: Restricting direct access to variables
 public int getId() {
     return id;
 }

 public String getName() {
     return name;
 }

 public String getEmail() {
     return email;
 }

 public String getPhone() {
     return phone;
 }

 public String getUserName() {
     return userName;
 }

 public String getPassword() {
     return password;
 }
}

