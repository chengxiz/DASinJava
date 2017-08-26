package dasinjava.sqd;

public class Josephus {
    /** Computes the winner of the Josephus problem using a circular queue. */
    public static <E> E JosephusConstruction(CircularQueue<E> queue, int k) {
    	if (queue.isEmpty()) return null;
    	while (queue.size() > 1) {
    		for (int i=0;i<k+1;i++)
    			queue.rotate();
    		E e = queue.dequeue();
    		System.out.println(" "+e+" is out");
    	}
    	return(queue.dequeue());				// the winner
    }
    
    /** Builds a circular from an array of objects. */
    public static <E> CircularQueue<E> buildQueue(E a[]) {
    	CircularQueue<E> queue = new LinkedCircularQueue<>();
        for (int i=0;i<a.length;i++)
            queue.enqueue(a[i]);
        return queue;
    }

    /** Tester method */
    public static void main(String[] args) {
        String[] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        String[] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
        String[] a3 = {"Mike", "Roberto"};
        System.out.println("First winner is " + JosephusConstruction(buildQueue(a1),3));
        System.out.println("Second winner is " + JosephusConstruction(buildQueue(a2),10));
        System.out.println("Third winner is " + JosephusConstruction(buildQueue(a3),7));

    }
}
