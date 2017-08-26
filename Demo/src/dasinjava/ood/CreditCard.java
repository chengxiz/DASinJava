package dasinjava.ood;

public class CreditCard {
    // Instance variables:
    private String customer;			// name of the customer (e.g., "Barry Smith")
    private String bank;				// name of the bank (e.g.. "BoA")
    private String account; 			// acount identifier (e.g. "5391 0375 9387 5309")
    private int limit; 					// credit limit (measured in dollars)
    protected double balance;			// current balance (measured in dollars)
    // Constructors:
    public CreditCard(String cust, String bk, String acnt, int lim, double initialBal){
    	this.customer = cust;
    	this.bank = bk;
    	this.account = acnt;
    	this.limit = lim;
    	this.balance = initialBal;
    }
    public CreditCard(String cust, String bk, String acnt, int lim){
    	this(cust, bk, acnt, lim, 0.0);	// use a balance of zero as default
    }
    // Accessor methods:
    public String getCustomer() { return this.customer; }
    public String getBank() { return this.bank; } 
    public String getAccount() { return this.account; }
    public int getLimit() { return this.limit; }
    public double getBalance() { return this.balance; }
    // Update methods:
    public boolean charge(double price) {	// make a charge
    	if (price + balance > limit)		// if charge  surpass limit
    		return false;					// refuse the charge
    	balance += price;					// update the balance
    	return true;						// announce the good news
    }
    public void makePayment (double amount) {	// make a payment
    	balance -= amount;						
    }
    // Utility method to print a card's information
    public static void printSummary(CreditCard card){
    	System.out.println("Customer = " + card.customer);
    	System.out.println("Bank = " + card.bank);
    	System.out.println("Account = " + card.account);
    	System.out.println("Balance = " + card.balance);
    	System.out.println("Limit = " + card.limit);
    }
}

