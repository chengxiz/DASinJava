package dasinjava.sqd;
import dasinjava.fundds.DoublyLinkedList;;
public class LinkedDeque<E> implements Deque<E>{

    DoublyLinkedList<E> list = new DoublyLinkedList<E>();
    // constructor
    public LinkedDeque(){};

    //methods
   	/** Returns the number of elements in the deque. */
   	public int size(){ return list.size(); }
   	/** Tests whether the deque is empty. */
   	public boolean isEmpty(){return list.isEmpty();}
   	/** Returns, but does not remove, the first element of the deque (null if empty). */
	public E first(){return list.first();}
   	/** Returns, but does not remove, the last element of the deque (null if empty). */
   	public E last(){return list.last();}
   	/** Inserts an element at the front of the deque. */
   	public void addFirst(E e){list.addFirst(e);}
   	/** Inserts an element at the end of the deque. */
   	public void addLast(E e){list.addLast(e);}
   	/** Removes and returns the first element of the deque (null if empty). */
   	public E removeFirst(){return list.removeFirst();}
   	/** Removes and returns the last element of the deque (null if empty). */
   	public E removeLast(){return list.removeLast();}
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
