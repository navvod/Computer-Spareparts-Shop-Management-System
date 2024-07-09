package computerSpare;

import java.util.List;

// Interface defining methods for interacting with a customer database using OOP concepts

public interface iCustomerDButil {

	// Encapsulation: Method to validate a user by username and password
	public boolean validate(String userName, String password);

	// Abstraction: Method to retrieve customer information based on username
	public List<Customer> getCustomer(String userName);

	// Encapsulation: Method to insert a new customer into the database
	public boolean insertcustomer(String name, String phone, String email, String username, String password);

	// Encapsulation: Method to update customer information in the database
	public boolean updatecustomer(String id, String name, String email, String phone, String username, String password);

	// Abstraction: Method to retrieve customer details based on customer ID
	public List<Customer> getCustomerDetails(String Id);

	// Encapsulation: Method to delete a customer from the database
	public boolean deleteCustomer(String id);

	// Encapsulation: Method to insert a new booking into the database
	public boolean insertbooking(String date, String destination, String requests);

	// Abstraction: Method to retrieve bookings for a specific customer
	public List<Booking> getBooking(int cusID);

	// Encapsulation: Method to update booking information in the database
	public boolean updatebooking(String idbooking, String date, String destination, String requests);

	// Abstraction: Method to retrieve booking details based on booking ID
	public List<Booking> getBookingDetails(String Idbooking);

	// Encapsulation: Method to delete a booking from the database
	public boolean deleteBooking(String idbooking);

	// Abstraction: Method to validate a credit card by card number and card holder's name
	public List<Card> validate2(String cardnumber, String nameOfHolder);

	// Encapsulation: Method to insert a new credit card into the database
	public boolean insertcard(String card_number, String cardholder_name, String CVC, String expiry_date);

	// Abstraction: Method to retrieve credit cards for a specific customer
	public List<Card> getCard(int cusID);

	// Abstraction: Method to retrieve credit card details based on card ID
	public List<Card> getCardDetails(String Idcard);

	// Encapsulation: Method to delete a credit card from the database
	public boolean deletecard(String idcard);

	// Encapsulation: Method to update credit card information in the database
	public boolean updatecard(String idcard, String CardNumber, String CardHolderName, String CVC, String ExpiredDate);

	// Abstraction: Method to insert feedback into the database
	public boolean insertfeedback(String date, String name, String feedback);

	// Abstraction: Method to retrieve feedback for a specific customer
	public List<Feedback> getfeedback(int cusID);

	// Encapsulation: Method to update feedback information in the database
	public boolean updatefeedback(String idbooking, String date, String destination, String requests);

	// Abstraction: Method to retrieve feedback details based on feedback ID
	public List<Feedback> getfeedbackDetails(String Idbooking);

	// Encapsulation: Method to delete feedback from the database
	public boolean deletefeedback(String idbooking);
}
