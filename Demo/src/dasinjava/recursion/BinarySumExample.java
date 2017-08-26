package dasinjava.recursion;

public class BinarySumExample {
    /** Returns the sum of subarray data[low] through data[high] inclusive. */
    public static int binarySum(int[] data, int low, int high) {
    	if(low>high) return 0; 
		else if(low==high) return data[low];
		else {
			int mid = (low+high)/2;
			return (binarySum(data, low, mid) + binarySum(data, mid+1, high));
		}
    }
    public static void main(String[] args) {
    	System.out.println(binarySum(new int[] {3,5,6,7,8,2,4,7},0,7));	
    }
}
