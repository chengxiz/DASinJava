package dasinjava.ood;
/**Generate an abstract progression */
public abstract class AbstractProgression {
    protected long current;
    public AbstractProgression() {this(0);}
    public AbstractProgression(long start) { current = start;}

    public long nextValue() {
    	long answer = current;					// this is a concrete method
    	advance();					
    	return answer;
    }

    public void printProgression(int n) {		// this is a concrete method
    	System.out.print(nextValue());			// print the first value 
    	for (int j=1;j<n;j++){
    		System.out.print(" "+nextValue());	// print leading space before others
    	}
    	System.out.println(" ");				// print the end 
    }
    protected abstract void advance();			// this is an abstract method which is common for all its subclasses, notice the lack of a method body
}
