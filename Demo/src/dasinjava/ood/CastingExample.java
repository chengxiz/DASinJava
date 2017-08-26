package dasinjava.ood;

public class CastingExample {
    public static void main(String[] args) {

    	// Casting with Classes
    	CreditCard card = new PredatoryCreditCard("John Bowen", "Citi", "2222", 2500, 300, 0.28);										// widening
    	System.out.println( card instanceof CreditCard);
    	System.out.println( card instanceof PredatoryCreditCard);
    	System.out.println(card.getClass().getName());
    	PredatoryCreditCard pc = (PredatoryCreditCard) card;	// narrowing	   	
    	System.out.println( pc instanceof CreditCard);
    	System.out.println( pc instanceof PredatoryCreditCard);
    	System.out.println(pc.getClass().getName());

    	// Casting with Interfaces
    	Student s1 = new Student("K345P","Barry",50);
    	Student s2 = new Student("D386T","Jared",40);
    	Student s3 = new Student("D386T","Jerry",40);    	
    	System.out.println(s2.equals(s3));
    	System.out.println(s1.equals(s2));
    	System.out.println(s1.equals(pc));
    }
    
}
