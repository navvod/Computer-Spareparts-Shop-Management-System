package computerSpare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CardDBUtil implements iDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	public static int cusID;
	
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

}
