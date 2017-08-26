package dasinjava.recursion;

public class R_5_2 {
	public static int binarySearch(int[] data, int target, int low, int high) {
    	if (low > high)
            return -1;
    	else {
    		int mid = (low+high) / 2;
    		if (target == data[mid])
                return mid;										// found a match
    		else if (target > data[mid])
    			return (binarySearch(data, target, mid +1, high));	// recur left of the middle
    		else
    			return (binarySearch(data, target, low, mid - 1));  // recur right of the middle
    	}
    }

    public static void main(String[] args) {
    	int[] d = {3,7,8,9,12,15,23};
    	int target1 = 12;
    	int target2 = 13;
    	int low = 1;
    	int high = d.length;
    	System.out.println(binarySearch(d, target1, low, high));
    	System.out.println(binarySearch(d, target2, low, high));
    }
}
