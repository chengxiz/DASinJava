package dasinjava.fundds;
import java.util.Arrays;
import java.util.Random;
/** Program showing some array uses. */
public class RandomExample {
    public static void main(String[] args) {
    	int data[] = new int[10];
    	Random rand = new Random(); 				// a pseudo-random number generator
    	rand.setSeed(System.currentTimeMillis());	// use current time as a seed
    	//int seed = 92;
    	// fill the data array with pseudo-random numbers from 0 to 99, inclusive
    	for (int i = 0; i<data.length;i++){
    		data[i] = rand.nextInt(100);			// the next pseudo-random number
    		//data[i] = (3*seed+5)%100;
    		//seed = data[i];
    	}
    	int[] orig = Arrays.copyOf(data, data.length); // make a copy of the data array
    	System.out.println("arrays equal before sort: "+Arrays.equals(data, orig));
    	Arrays.sort(data); 							// soring the data array (orig is unchanged)
    	System.out.println("arrays equal after sort: "+Arrays.equals(data, orig));
    	System.out.println("orig = "+Arrays.toString(orig));
    	System.out.println("data = "+Arrays.toString(data));
    }
}
