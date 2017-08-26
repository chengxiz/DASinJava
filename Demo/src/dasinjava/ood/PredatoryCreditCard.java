package dasinjava.ood;

public class PredatoryCreditCard extends CreditCard {
    // Additional instance variable
    private double apr;					// annual percentage rate

    // Constructor for this class
    public PredatoryCreditCard(String cust, String bk, String acnt, int lim, double initialBal, double rate){
    	super(cust, bk, acnt, lim, initialBal);
    	this.apr = rate;
    }
    // A new method for assessing monthly interest charges
    public void processMonth(){
    	if (this.balance > 0){ //only charge interest on a positive balance
    		double monthlyFactor = Math.pow(1 + apr, 1.0/12); 	//compute monthly rate
    		balance *= monthlyFactor;							//assess interest
    	}
    }

    //Overriding the charge method defined in the superclass
    public boolean charge(double price){
    	boolean isSuccess = super.charge(price);				//call inherited method
    	if (!isSuccess){
    		balance += 5;										//assess a $5 penalty
    	}
    	return isSuccess;
    }
}