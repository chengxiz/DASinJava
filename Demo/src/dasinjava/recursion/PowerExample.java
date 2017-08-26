package dasinjava.recursion;

public class PowerExample {
    public static double power(double d, int p){
    	if(p==0) return 1;
    	else {
    		double partial = power(d,p/2);
    		double result = partial*partial;
    		if (p%2==1){
    			result*=d;
    		}
    		return result;
    	}
    }
    public static void main(String[] args) {
    	System.out.println(power(2,3));
    }
}
