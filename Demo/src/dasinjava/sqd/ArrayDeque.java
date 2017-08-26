package dasinjava.sqd;

public class ArrayDeque<E> {
	// instance variables
	private E[] data;
	private static int CAPACITY=1000;
	private int f = 0;
	private int sz = 0;
	private int l;

	// constructors
	public ArrayDeque(){this(CAPACITY);}
	@SuppressWarnings("unchecked")
	public ArrayDeque(int capacity){
		data = (E[]) new Object[capacity];
		l = data.length;
	};    
    // methods
   	/** Returns the number of elements in the deque. */
   	int size(){ return sz;}
   	/** Tests whether the deque is empty. */
   	boolean isEmpty(){ return (sz==0);}
   	/** Returns, but does not remove, the first element of the deque (null if empty). */
	E first(){ return data[f];}
   	/** Returns, but does not remove, the last element of the deque (null if empty). */
   	E last(){ return data[(f+sz-1)%l];}
   	/** Inserts an element at the front of the deque. */
   	void addFirst(E e){
   		if (isEmpty()){
   			data[0] = e; 
   			f = 0;  				// In case the the size of deque in decreased to 0 whose former f is not 0			
   		} else{
			data[(f+l-1)%l] = e;
			f = (f+l-1)%l;
   		}
   		sz++;
   	}
   	/** Inserts an element at the end of the deque. */
   	void addLast(E e){
   		if (isEmpty()){
   			data[0] = e; 
   			f = 0;   				// In case the the size of deque in decreased to 0 whose former f is not 0			
   		} else{   		
   			data[(f+sz-1)%l] = e;
   		}
   		sz++;
   	}
   	/** Removes and returns the first element of the deque (null if empty). */
   	E removeFirst(){
   		if (isEmpty()) return null;
   		E answer = data[f];
   		data[f] = null;
   		f = (f+1)%l;
   		sz--;
   		return answer;
   	}
   	/** Removes and returns the last element of the deque (null if empty). */
   	E removeLast(){
   		if (isEmpty()) return null;
   		E answer = data[(f+sz-1)%l];
   		data[(f+sz-1)%l] = null;
   		sz--;
   		return answer;
   	}   
   	public static void main(String[] args) {
   		ArrayDeque<Integer> deque = new ArrayDeque<Integer>(10);
   		deque.addLast(5);
   		deque.addFirst(3);
   		deque.addFirst(7);
   		System.out.println(deque.first());
   		System.out.println(deque.removeLast());
   		System.out.println(deque.size());
   		System.out.println(deque.removeLast());
   		System.out.println(deque.removeFirst());
   		deque.addFirst(6);
   		System.out.println(deque.last());
   		deque.addFirst(8);
   		System.out.println(deque.isEmpty());
   		System.out.println(deque.last());

   	}
}
