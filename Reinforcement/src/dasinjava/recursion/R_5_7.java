package dasinjava.recursion;

public class R_5_7 {
    public static double harmNum(int n){
    	if (n<=0) return 0;
    	else return(harmNum(n-1) +1/(double)n) ;
    }
    public static void main(String[] args) {
    	System.out.println(harmNum(5));
    }
}
