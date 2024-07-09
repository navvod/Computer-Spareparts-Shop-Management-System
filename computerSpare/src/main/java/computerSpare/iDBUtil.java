package computerSpare;

import java.util.List;


public interface iDBUtil {
	
	public List<Card> validate2(String cardnumber,String nameOfHolder);
	
	public boolean insertcard(String card_number,String cardholder_name,String CVC,String expiry_date );
	
	public List<Card> getCard(int cusID);
	
	public List<Card> getCardDetails(String Idcard);
	
	public boolean deletecard(String idcard);
	
	public boolean updatecard(String idcard, String CardNumber, String CardHolderName, String CVC, String ExpiredDate);

}
