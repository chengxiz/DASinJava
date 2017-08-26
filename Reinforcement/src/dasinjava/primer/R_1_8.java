package dasinjava.primer;
import java.util.Scanner;
public class R_1_8 {
    static int CountVowels(String s){
    	int l=0;
    	int n=0;
    	while (l<s.length())
    	{    		
	    	switch (Character.toString(s.charAt(l)).toUpperCase()){	    		
	    		case "A":
	    			n+= 1;
	    			break;
				case "E":
	    			n+= 1;
	    			break;
	    		case "I":
	    			n+= 1;
	    			break;
	    		case "O":
	    			n+= 1;
	    			break;
	    		case "U":
	    			n+= 1;
	    			break;
	    		default:
	    			n+= 0;
    		}
	    	l++;
    	}   
    	return n;    	
    }
  	public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter String: ");
    	while (!input.hasNext()){
    		input.nextLine();
    		System.out.println("Invalid String, Try Again!");
    	} 
    	String s = input.next();    	
		System.out.println(CountVowels(s));	
		input.close();
  	}
}
