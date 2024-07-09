package computerSpare;

import java.sql.Connection;  

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class BookingDBUtil implements iBooking {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	public static int cusID;
	
    public boolean insertbooking(String date, String destination, String requests)
	{
		boolean isSuccess = false;
		
		try 
		{
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			//insert data to database

			String sql = "INSERT INTO booking(date, destination, request, id) VALUES ('"+date+"', '"+destination+"', '"+requests+"', '"+cusID+"')";
			


			int rs = stmt.executeUpdate(sql);
			//insert success out 1..unsuccess out 0
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccess;
	}
    
	public List<Booking> getBooking(int cusID)
	{
		ArrayList<Booking> booking = new ArrayList<Booking>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from booking where id = '"+cusID+"'";

			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int idbooking = rs.getInt(1);
				String date = rs.getString(2);
				String destination = rs.getString(3);
				String requests = rs.getString(4);
				
				
				Booking book = new Booking(idbooking, date, destination, requests);
				
				
				booking.add(book);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return booking;
	}
	
public boolean updatebooking(String idbooking, String date, String destination, String requests) {
		
		try {
			int ID=Integer.parseInt(idbooking); 
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "UPDATE booking SET  date= ?, destination = ? , request = ? where idbooking = ?";
			
			PreparedStatement statemnt = null;
			
			statemnt = con.prepareStatement(sql);
			
			statemnt.setString(1, date);
			statemnt.setString(2, destination);
			statemnt.setString(3, requests);
			statemnt.setInt(4, ID);
			
			
			int rs = statemnt.executeUpdate();
			
			if(rs > 0)
			{
				isSuccess = true;
			}
			else
			{
				isSuccess = false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccess;
	}

public List<Booking> getBookingDetails(String Idbooking)
{
	int convertedID = Integer.parseInt(Idbooking);
	ArrayList<Booking> booking = new ArrayList<>();
	try
	{
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		String sql = "select * from booking where idbooking = '"+convertedID+"'";
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int idbooking = rs.getInt(1);
			String date = rs.getString(2);
			String destination = rs.getString(3);
			String requests = rs.getString(4);
			
			
			//pass data to customer object
			Booking book = new Booking(idbooking, date, destination, requests);
			booking.add(book);
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return booking;
}

public boolean deleteBooking(String idbooking)
{
	
	
	try
	{
		con = DBConnect.getConnection(); 
		stmt = con.createStatement();
		String sql = "delete from booking where idbooking = "+idbooking;
		System.out.println(sql);
        int r =stmt.executeUpdate(sql);
	    
        if(r>0)
        {
        	isSuccess = true;
        }
        else {
        	isSuccess = false;
        }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return isSuccess;
}

}
