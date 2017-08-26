package dasinjava.recursion;

public class FibonacciExample {
    public static long[] fibonacciGood(int n) {
    	if (n<=1) {
    		long[] answer = {n,0};
    		return answer;
    	} else {
    		long[] temp = fibonacciGood(n-1);					// returns {Fn-1,Fn-2}
    		long[] answer = {temp[0]+temp[1], temp[0]};			// gets {Fn-1, Fn-2}
    		return answer;
    	}
    }
    public static void main(String[] args) {
    	for (long l:fibonacciGood(5)){
    		System.out.println(l);
    	}
    	
    }
}
