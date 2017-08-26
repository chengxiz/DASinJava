package dasinjava.primer;
import java.util.Scanner;
public class R_1_1 {
    static void AllBaseTypes(){
    	Scanner input = new Scanner(System.in);
    	System.out.println("Input any data:");
    	Object o = input.next();
    	System.out.println("Print it out:");
    	System.out.print(o);
    	input.close();
    }
    public static void main(String[] args) {
    	AllBaseTypes();	
    }
}
