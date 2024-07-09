package computerSpare;

import java.util.List;

public interface iBooking {
	public boolean insertbooking(String date, String destination, String requests);
	
	public List<Booking> getBooking(int cusID);
	
	public boolean updatebooking(String idbooking, String date, String destination, String requests);
	
	public List<Booking> getBookingDetails(String Idbooking);
	
	public boolean deleteBooking(String idbooking);

}
