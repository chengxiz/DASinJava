package dasinjava.primer;
import java.util.Scanner;
public class R_1_7 {
    static int SumSqrPosInt(int i){
    	int sum = 0;
    	try{   		
	    	do{
    			i--;
    			sum += i*i;
    		}while(i>0);    		
    	}
    	catch (Exception e){
    		System.out.println(e);
    	}
    	return(sum);
    }
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter number: ");
    	while (!input.hasNextInt()){
    		input.nextLine();
    		System.out.println("Invalid Int Number, Try Again!");
    	} 
    	Integer I = input.nextInt();    	
		System.out.println(SumSqrPosInt(I));	
		input.close();    	
    }
}
