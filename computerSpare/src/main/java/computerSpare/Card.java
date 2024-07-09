package computerSpare;

//Class representing a Card entity
public class Card {

 // Instance variables encapsulating the state of a Card
 private int idcard;              // Encapsulation
 private String CardNumber;
 private String CardHolderName;
 private String CVC;
 private String ExpiredDate;

 // Parameterized constructor for initializing Card instances
 public Card(int cardId, String cardNumber, String cardHolderName, String cvc, String expiredDate) {
     // 'this' keyword for disambiguation
     this.idcard = cardId;
     this.CardNumber = cardNumber;
     this.CardHolderName = cardHolderName;
     this.CVC = cvc;
     this.ExpiredDate = expiredDate;
 }

 // Getter methods to access the state of a Card
 // Encapsulation: Restricting direct access to variables
 public int getIdcard() {
     return idcard;
 }

 public String getCardNumber() {
     return CardNumber;
 }

 public String getCardHolderName() {
     return CardHolderName;
 }

 public String getCVC() {
     return CVC;
 }

 public String getExpiredDate() {
     return ExpiredDate;
 }
}
