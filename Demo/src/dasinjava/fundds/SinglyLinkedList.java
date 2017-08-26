package dasinjava.fundds;

public class SinglyLinkedList<E> {
	//------------------- nested Node class-----------------
	private static class Node<E> {
		private E element;			// reference to the element stored at this node
		private Node<E> next;		// reference to the subsequent node in the list
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		public E getElement() { return element; }
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> n) { next = n; }
	}// ------------------- end of nested Node class-----------------
	
	// instance variables of the SinglyLinkedList
	private Node<E> head = null;				// head node of the list (or null if empty)
	private Node<E> tail = null;				// tail node of the list (or null if empty)
	private int size = 0;						// number of nodes in the list
	public SinglyLinkedList() {}				// constructs an initially empty list
	// access methods
	public int size() { return size; }
	public boolean isEmpty() { return size==0; }
	public E first() {					// returns (but does not remove) the first element
		if(isEmpty()) return null;
		return head.getElement();
	}
	public E last() {					// returns (but does not remove) the last element
		if(isEmpty()) return null;
		return tail.getElement();
	}
	public void addFirst(E e) {			// adds element e to the front of the list
		head = new Node<E>(e,head);		// create and link a new node
		if (size==0){
			tail = head;				// special case: no elements and new node becomes tail also
		}
		size++;
	}
	public void addLast(E e) {
		Node<E> newest = new Node<E>(e,null);
		if (size==0){
			head = newest;				// special case: previous empty list
		} else{
			tail.setNext(newest);
		}
		tail = newest;
		size++;		
	}
	public E  removeFirst() {
		if (isEmpty()) return null;
		E  answer = head.getElement();
		head = head.getNext();
		size--;
		if (size==0)
			tail = null;
		return answer;
	}
}