package dasinjava.ood;

public class CreditCardTest {
    public static void main(String[] args) {
    	CreditCard[] wallet = new CreditCard[3];
    	wallet[0] = new CreditCard("John Bowen", "BoA", "5555", 5000);
    	wallet[1] = new CreditCard("John Bowen", "Discover", "4444", 3500);
    	wallet[2] = new CreditCard("John Bowen", "Citi", "2222", 2500, 300);

    	for(int val = 1; val <= 16; val++){
    		wallet[0].charge(3*val);
    		wallet[1].charge(2*val);
    		wallet[2].charge(1*val);
    	}
    	for(CreditCard card:wallet){
    		CreditCard.printSummary(card);
    		while (card.getBalance() > 200.0){
    			card.makePayment(200);
    			System.out.println("New balance = " + card.getBalance());
    		}
    	}  	    	

     } 
}
