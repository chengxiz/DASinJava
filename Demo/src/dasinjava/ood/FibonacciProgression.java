package dasinjava.ood;

public class FibonacciProgression extends Progression{
    
    protected long prev;

    public FibonacciProgression() {
    	this(0,1);
    }
    /** Construct generalized Fibonacci starting 0,1,1,2,3,...*/
    public FibonacciProgression(long first, long second) {
    	super(first);
    	this.prev = second - first;
    	//System.out.println("current"+current);
    	//System.out.println("prev"+prev);
    }

    protected void advance(){
    	long temp = prev;
    	prev = current;
    	current += temp;
    	//System.out.println("current"+current);
    	//System.out.println("prev"+prev);
    }

}
