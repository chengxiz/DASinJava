package dasinjava.primer;
import java.util.Scanner;
public class R_1_9 extends R_1_8{
    static StringBuilder RmvPunct(String s){
    	StringBuilder sb = new StringBuilder(s.replaceAll("\\W",""));
    	return sb;
    }
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter String: ");
    	while (!input.hasNext()){
    		input.nextLine();
    		System.out.println("Invalid String, Try Again!");
    	} 
    	String s = input.next();    	
		System.out.println(RmvPunct(s));	
		input.close();
		
		R_1_8 r1 = new R_1_9();
		System.out.println(r1 instanceof R_1_8);//true
		System.out.println(r1 instanceof R_1_9);//true
    }
}
