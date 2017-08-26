package dasinjava.list;
import java.lang.Iterable;
import java.util.*;

public class LinkedPositionalList<E> implements PositionalList<E>{
	//-------nested Node class-----------
    private static class Node<E> implements Position<E>{
    	// instance variable
    	private E element;
    	private Node<E> prev;
    	private Node<E> next;   	
    	
    	// constructor
    	public Node(E e, Node<E> p, Node<E> n){
    		element = e;
    		prev = p;
    		next = n;
    	}
    	public E getElement(){
    		if (next==null){
    			throw new IllegalStateException("Position no longer valid");
    		}
    		return element;
    	}
    	public void setElement(E e){
    		element = e;
    	}
    	public Node<E> getPrev(){
    		return prev;
    	}
    	public Node<E> getNext(){
    		return next;
    	}
    	public void setPrev(Node<E> p){
    		prev = p;
    	}
    	public void setNext(Node<E> n){
    		next = n;
    	}
    }//-------end of nested Node class--------

    //-------nested PositionIterator class---
    private class PositionIterator implements Iterator<Position<E>>{
    	private Position<E> cursor = first();
    	private Position<E> recent = null;    	

		@Override
    	/** Tests whether the iterator has a next object. */
		public boolean hasNext() {
			return (cursor!=null);
		}

		@Override
		public Position<E> next() throws NoSuchElementException {
			if (cursor==null) throw new NoSuchElementException("nothing to remove");
			recent = cursor;				// element at this position might later be removed
			cursor = after(cursor);			
			return recent;
		}
		/** Removes the element returned by most recent call to next. */
		public void remove() throws NoSuchElementException {
			if (recent == null) throw new IllegalStateException("nothing to remove");
			LinkedPositionalList.this.remove(recent);			// remove from outer list
			recent = null;				// do not allow remove again until next is called
		}    	
    }
    //-------end of nested PositionIterator class---

    //-------nested PositionIterable class-----------
    private class PositionIterable implements Iterable<Position<E>> {
    	public Iterator<Position<E>> iterator() {
    		return new PositionIterator();
    	}
    }
    //-------end of nested PositionIterable class------

    /** Returns an iterable representation of the list's positions. */
    public Iterable<Position<E>> positions() {
    	return new PositionIterable(); 			// create a new instance of the inner class
    }

    //-------nested ElementIterator class------------
    /* This class adapts the interation produced by positions() to return elements. */
    private class ElementIterator implements Iterator<E> {
    	Iterator<Position<E>> posIterator = new PositionIterator();
    	public boolean hasNext() { return posIterator.hasNext(); }
    	public E next() { return posIterator.next().getElement();}		//return element!
    	public void remove() { posIterator.remove(); }
    }

    /** Returns an iterator of the elements stored in the list. */
    public Iterator<E> iterator() { return new ElementIterator(); }

    // instance variables
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    // constructor
    public LinkedPositionalList(){
    	header = new Node<E>(null,null,null);
    	trailer = new Node<E>(null,header,null);
    	header.setNext(trailer);
    }

    // methods
    // private utilities
    /** Validates the position and returns it as a node. */
    private Node<E>  validate(Position<E> p) throws IllegalArgumentException {
    	if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
    	Node<E> node = (Node<E>) p;		//safe cast
    	if (node.getNext()==null)		// convention for defunct node
    		throw new IllegalArgumentException("p is no longer in the list");
		return node;
    }

    /** Returns the given node as a Position (or null, if it is a sentinel). */
    private Position<E> position(Node<E> node){
    	if (node==header||node==trailer)
    		return null; //do not expose user to the sentinels
    	return node;
    }

    // public accessor methods

    /** Returns the number of elements in the list. */
    public int size(){return size;}

    /** Tests whether the list is empty. */
    public boolean isEmpty(){return size==0;}

    /** Returns the first Position in the list (or null if empty) */
	public Position<E> first(){ 
		return position(header.getNext());
	}

	/** Returns the last Position in the list (or null, if empty) */
	public Position<E> last(){ 
		return position(trailer.getPrev()); 
	}

	/** Returns the Position immediately before Position p (or null, if p is first). */
	public Position<E> before(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return position(node.getPrev());
	}

	/** Returns the Position immediately after Position p (or null, if p is first). */
	public Position<E> after(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return position(node.getNext());
	}	

	//private utilities
	/** Adds element e to the linked list between the given nodes. */
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest = new Node<E>(e,pred,succ);
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
		return newest;
	}

	//public update methods
	/** Inserts element e at the front of the list and returns its new Position. */
	public Position<E> addFirst(E e){
		return addBetween(e, header, header.getNext());
	}

	/** Inserts element e at the back of the list and returns its new Position. */
	public Position<E> addLast(E e){
		return addBetween(e, trailer.getPrev(), trailer);
	}

	/** Inserts element e immediately before Position p and returns its new Position. */
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	/** Inserts element e immediately after Position p and returns its new Position. */
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());	
	}

	/** Replace the element stored at Position p and returns the replaced element. */
	public E set(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}

	/** Removes the element stored at Position p and returns it (invalidating p). */
	public E remove(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setPrev(null);
		node.setNext(null);
		return answer;
	}    
	public static void main(String[] args) {
		LinkedPositionalList<String> lplist = new LinkedPositionalList<String>();
		Position<String> o1 = lplist.addFirst("Barry");	
		lplist.addAfter(o1, "Smith");
		lplist.addAfter(o1, "Ontology");
		System.out.println(lplist.size());
		Iterator<String> iter = lplist.iterator();
		while (iter.hasNext()){				
			String s = iter.next();
			System.out.println(s);			
		}
		
		for (Position<String> s: lplist.positions()){			
			System.out.println(s.getElement());			
		}
				
	}
}
