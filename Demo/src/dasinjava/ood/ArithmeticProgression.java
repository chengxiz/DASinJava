
package dasinjava.ood;

public class ArithmeticProgression extends Progression {

	protected long increment;

    /** Construct progression 0,1,2,...*/
    public ArithmeticProgression() {
    	this(1,0);			// start at 0 with increment of 1
    }

    /** Construct progression 0, stepsize, 2*stepsize, ... */
    public ArithmeticProgression(long stepsize) {
    	this(stepsize, 0);	// start at 0
    }

    /** Construct arithmetic progression with arbitrary start and increment. */
    public ArithmeticProgression(long stepsize, long start) {
    	super(start);
    	this. increment = stepsize;
    }

    @Override
    /** Adds the arithmetic increment to the current value. */
    protected void advance() {
    	this.current += increment;
    } 
}
