package dasinjava.primer;
import java.util.Scanner;
public class InputAndOutput {
    public static void main(String[] args) {
		  Scanner input = new Scanner(System.in);
    	System.out.println("Enter your age in years: ");
    	while (!input.hasNextDouble()){
    		input.nextLine();
    		System.out.println("Invalid Number, Try Again!");
    	}
    	double age = input.nextDouble();
     	System.out.println("Enter your maximum heart rate: ");
   		double rate = input.nextDouble();
   		double fb = (rate-age)*0.65;
   		System.out.println("Your indeal fat-burning heart rate is "+fb);
   		
   		input.close();
    }
}
