package dasinjava.primer;
import java.util.Scanner;
public class R_1_4 {
    static boolean isEvan(Integer I){    	
    	return((I & 1)==0);//only considering the last digit is 1 or 0
    }
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter number: ");
    	while (!input.hasNextInt()){
    		input.nextLine();
    		System.out.println("Invalid Int Number, Try Again!");
    	} 
    	Integer I = input.nextInt();    	
		System.out.println(isEvan(I));	
		input.close();
    }
}
