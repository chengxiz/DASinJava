package dasinjava.ood;

public class PredatoryCreditCardTest {
	public static void main(String[] args) {
    	PredatoryCreditCard[] wallet2 = new PredatoryCreditCard[3];
    	wallet2[0] = new PredatoryCreditCard("John Bowen", "BoA", "5555", 5000, 0,0.22);
    	wallet2[1] = new PredatoryCreditCard("John Bowen", "Discover", "4444", 3500,0, 0.24);
    	wallet2[2] = new PredatoryCreditCard("John Bowen", "Citi", "2222", 2500, 300, 0.28);

    	for(int val = 1; val <= 16; val++){
    		wallet2[0].charge(3*val);
    		wallet2[0].processMonth();
    		wallet2[1].charge(2*val);
    		wallet2[1].processMonth();
    		wallet2[2].charge(1*val);
    		wallet2[2].processMonth();
    	}
    	for(PredatoryCreditCard card:wallet2){
    		PredatoryCreditCard.printSummary(card);
    		while (card.getBalance() > 200.0){
    			card.makePayment(200);
    			System.out.println("New balance = " + card.getBalance());
    		}
    	}

	}
}
