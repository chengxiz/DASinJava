package dasinjava.primer;
import java.util.Scanner;
public class R_1_3 {
    static boolean isMultiple(Long l1, Long l2){
    	return((l1 % l2)==0);
    }
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter First Long number: ");
    	while (!input.hasNextLong()){
    		input.nextLine();
    		System.out.println("Invalid Long Number, Try Again!");
    	} 
    	Long l1 = input.nextLong();
    	System.out.println("Enter First Long number: ");
		while (!input.hasNextLong()){
			input.nextLine();
			System.out.println("Invalid Long Number, Try Again!");
		}    
		Long l2 = input.nextLong();
		System.out.println(isMultiple(l1,l2));	
		input.close();
    }
}
