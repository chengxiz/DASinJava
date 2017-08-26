package dasinjava.ss;

import java.util.Comparator;

import dasinjava.sqd.LinkedQueue;
import dasinjava.sqd.Queue;

public class quickSortQueue {
	/** Quick-sort contents of a queue. */
	public static <K> void quickSort(Queue<K> S, Comparator<K> comp) {
		int n = S.size();
		if (n<2) return;				// queue is trivially sorted
		// divide
		K pivot = S.first();			// using first as arbitary pivot
		Queue<K> L = new LinkedQueue<>();
		Queue<K> E = new LinkedQueue<>();
		Queue<K> G = new LinkedQueue<>();
		while (!S.isEmpty()) {			// divide orignial into L,E, and G
			K element = S.dequeue();
			int c = comp.compare(element, pivot);
			if (c<0)					// element is less than pivot
				L.enqueue(element);
			else if (c==0)				// element is equal to pivot
				E.enqueue(element);
			else
				G.enqueue(element);
		}
		// conquer
		quickSort(L, comp);				// sort elements less than pivot
		quickSort(G, comp);				// sort elements greater than pivot
		// concatenate results
		while (!L.isEmpty())
			S.enqueue(L.dequeue());
		while (!E.isEmpty())
			S.enqueue(E.dequeue());
		while (!G.isEmpty())
			S.enqueue(G.dequeue());
	}
}
