package dasinjava.ood;

public class ProgressionTest {
    public static void main(String[] args) {
    	Progression p = new Progression(5);
    	p.printProgression(8);
    	Progression p2 = new FibonacciProgression(0,2);
    	p2.printProgression(8);
    	Progression p3 = new ArithmeticProgression(128);
    	//try{
    		
    	//}catch
    	p3.printProgression(10);
    }
}
