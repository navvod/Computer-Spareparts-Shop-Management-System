package computerSpare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

// Implementation of the iCustomerDButil interface using OOP principles
public class CustomerDBUtil implements iCustomerDButil {

    // Static fields shared among instances
    private static boolean isSuccess;
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    public static int cusID; // Shared state for the customer ID

    // Implementation of the validation method using Encapsulation
    public boolean validate(String userName, String password) {
        // Method Overloading: The same method name with different parameters
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "select * from customer where username='" + userName + "' and password = '" + password + "'";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                cusID = rs.getInt(1); // Assigning the customer ID for future use
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    // Method Overloading: Different parameters for the same method name
    public List<Customer> getCustomer(String userName) {
        ArrayList<Customer> customer = new ArrayList();

        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "select * from customer where username = '" + userName + "'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String username = rs.getString(5);
                String password = rs.getString(6);

                // Creating Customer objects to encapsulate customer data
                Customer cus = new Customer(id, name, email, phone, username, password);
                customer.add(cus);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    // Method Overloading: Different parameters for the same method name
    public boolean insertcustomer(String name, String phone, String email, String username, String password) {
        boolean isSuccess = false;

        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "insert into customer values(0, '" + name + "', '" + email + "', '" + phone + "', '" + username + "', '" + password + "')";
            int rs = stmt.executeUpdate(sql);

            if (rs > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    // Method Overriding: Implementing a method from the interface
    @Override
    public boolean updatecustomer(String id, String name, String email, String phone, String username, String password) {
        try {
            int ID = Integer.parseInt(id);
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "UPDATE customer SET name = ?, email = ? , phone = ?, username = ?, password = ? where id = ?";

            // Using PreparedStatement for better performance and security
            PreparedStatement statemnt = null;

            statemnt = con.prepareStatement(sql);
            statemnt.setString(1, name);
            statemnt.setString(2, email);
            statemnt.setString(3, phone);
            statemnt.setString(4, username);
            statemnt.setString(5, password);
            statemnt.setInt(6, ID);
            int rs = statemnt.executeUpdate();

            if (rs > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    // Method Overriding: Implementing a method from the interface
    @Override
    public List<Customer> getCustomerDetails(String Id) {
        int convertedID = Integer.parseInt(Id);
        ArrayList<Customer> cus = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "select * from customer where id = '" + convertedID + "'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String username = rs.getString(5);
                String password = rs.getString(6);

                // Creating Customer objects to encapsulate customer data
                Customer c = new Customer(id, name, email, phone, username, password);
                cus.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cus;
    }

    // Method Overriding: Implementing a method from the interface
    @Override
    public boolean deleteCustomer(String id) {
        int convId = Integer.parseInt(id);

        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "delete from customer where id = '" + convId + "'";
            int r = stmt.executeUpdate(sql);

            if (r > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    // Method Overloading: Different parameters for the same method name
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
    
    // Method Overloading: Different parameters for the same method name
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
	@Override
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
	@Override
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
@Override
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

// Implementation of the validation method using Encapsulation
public List<Card> validate2(String cardnumber,String nameOfHolder){
	
	ArrayList<Card> crd=new ArrayList<>();
	
	//validate
	try {
		con=DBConnect.getConnection();
		stmt=con.createStatement();
		
		String sql="select * from carddetails where CardNumber='"+cardnumber+"' and NameofHolder= '"+nameOfHolder+"'"; 
		rs=stmt.executeQuery(sql);

		
		if(rs.next()) {
			int idcard = rs.getInt(1);
			String cardnumber1 = rs.getString(2);
			String nameofholder = rs.getString(3);
			String CVC = rs.getString(4);
			String expiredDate = rs.getString(5);
			
			
			Card c=new Card(idcard, cardnumber1,nameofholder,CVC,expiredDate);
			crd.add(c);
	
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	 
	
	return crd;
	
}

// Method Overloading: Different parameters for the same method name
public boolean insertcard(String card_number,String cardholder_name,String CVC,String expiry_date ) {
	
	boolean isSuccess=false;

	
	try {
		con=DBConnect.getConnection();
		stmt=con.createStatement();
    	
		String sql="insert into carddetails(CardNumber, NameofHolder, CVC, ExpiredDate, idcus) values('"+card_number+"','"+cardholder_name+"','"+CVC+"','"+expiry_date+"','"+cusID+"')";
		//"INSERT INTO booking(date, destination, request, id) VALUES ('"+date+"', '"+destination+"', '"+requests+"', '"+cusID+"')";
		int rs=stmt.executeUpdate(sql);
		
		if(rs>0) {
			isSuccess=true;
		} else {
			isSuccess=false;
		}	
		
	}catch(Exception e) {
		e.printStackTrace();
		
	}	
	
	return isSuccess;
}

// Method Overloading: Different parameters for the same method name
public List<Card> getCard(int cusID)
{
	ArrayList<Card> card = new ArrayList<Card>();
	
	try {
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		String sql = "select * from carddetails where idcus = '"+cusID+"'";

		rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			int idcard = rs.getInt(1);
			String CardNumber = rs.getString(2);
			String CardHolderName = rs.getString(3);
			String CVC = rs.getString(4);
			String ExpiredDate = rs.getString(5);
			
			//sent data to Customer constructor
			Card card1 = new Card(idcard, CardNumber, CardHolderName, CVC, ExpiredDate);
			
			//sent data to arraylist
			card.add(card1);
		}
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return card;
}


@Override
public List<Card> getCardDetails(String Idcard)
{
	int convertedID = Integer.parseInt(Idcard);
	ArrayList<Card> card = new ArrayList<>();
	try
	{
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		String sql = "select * from carddetails where idcard = '"+convertedID+"'";
		rs = stmt.executeQuery(sql);
		//check valid id 
		while(rs.next()) {
			int idcard = rs.getInt(1);
			String CardNumber = rs.getString(2);
			String CardHolderName = rs.getString(3);
			String CVC = rs.getString(4);
			String ExpiredDate = rs.getString(5);
			
			
			//pass data to customer object
			Card card1 = new Card(idcard, CardNumber, CardHolderName, CVC, ExpiredDate);
			card.add(card1);
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return card;
}
@Override
public boolean deletecard(String idcard)
{
	
	
	try
	{
		con = DBConnect.getConnection(); 
		stmt = con.createStatement();
		String sql = "delete from carddetails where idcard = "+idcard;
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


@Override
public boolean updatecard(String idcard, String CardNumber, String CardHolderName, String CVC, String ExpiredDate) {
	
	try {
		int ID=Integer.parseInt(idcard); 
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		String sql = "UPDATE carddetails SET  CardNumber= ?, NameofHolder = ? , CVC = ? , ExpiredDate = ? where idcard = ?";
		
		PreparedStatement statemnt = null;
		
		statemnt = con.prepareStatement(sql);
		
		statemnt.setString(1, CardNumber);
		statemnt.setString(2, CardHolderName);
		statemnt.setString(3, CVC);
		statemnt.setString(4, ExpiredDate);
		statemnt.setInt(5, ID);
		
		
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

// Method Overloading: Different parameters for the same method name
public boolean insertfeedback(String date, String name, String feedback)
{
	boolean isSuccess = false;
	
	try 
	{
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		//insert data to database

		String sql = "INSERT INTO feedback(date, name, feedback, id) VALUES ('"+date+"', '"+name+"', '"+feedback+"', '"+cusID+"')";
		


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

// Method Overloading: Different parameters for the same method name
public List<Feedback> getfeedback(int cusID)
{
	ArrayList<Feedback> feedback = new ArrayList<Feedback>();
	
	try {
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		String sql = "select * from feedback where id = '"+cusID+"'";

		rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			int idbooking = rs.getInt(1);
			String date = rs.getString(2);
			String name = rs.getString(3);
			String feedbacks = rs.getString(4);
			
			
			Feedback feed = new Feedback(idbooking, date, name, feedbacks);
			
			
			feedback.add(feed);
		}
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return feedback;
}
@Override
public boolean updatefeedback(String idbooking, String date, String name, String feedbacks) {
	
	try {
		int ID=Integer.parseInt(idbooking); 
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		String sql = "UPDATE feedback SET  date= ?, name = ? , feedback = ? where idbooking = ?";
		
		PreparedStatement statemnt = null;
		
		statemnt = con.prepareStatement(sql);
		
		statemnt.setString(1, date);
		statemnt.setString(2, name);
		statemnt.setString(3, feedbacks);
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
@Override
public List<Feedback> getfeedbackDetails(String Idbooking)
{
int convertedID = Integer.parseInt(Idbooking);
ArrayList<Feedback> feedback = new ArrayList<>();
try
{
	con = DBConnect.getConnection();
	stmt = con.createStatement();
	String sql = "select * from feedback where idbooking = '"+convertedID+"'";
	rs = stmt.executeQuery(sql);
	
	while(rs.next()) {
		int idbooking = rs.getInt(1);
		String date = rs.getString(2);
		String name = rs.getString(3);
		String feedbacks = rs.getString(4);
		
		
		//pass data to customer object
		Feedback feed = new Feedback(idbooking, date, name, feedbacks);
		feedback.add(feed);
	}
}
catch(Exception e){
	e.printStackTrace();
}
return feedback;
}
@Override
public boolean deletefeedback(String idbooking)
{


try
{
	con = DBConnect.getConnection(); 
	stmt = con.createStatement();
	String sql = "delete from feedback where idbooking = "+idbooking;
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
