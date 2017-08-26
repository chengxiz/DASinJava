package dasinjava.trees;
import java.util.Iterator;

import dasinjava.list.ArrayList;
import dasinjava.list.List;
import dasinjava.list.Position;
import dasinjava.sqd.LinkedQueue;
import dasinjava.sqd.Queue;

/** An abstract base class providing some functionality of the Tree interface. */
public abstract class AbstractTree<E> implements Tree<E> {
	//------------ nested ElementIterator class ----------------
	/* This class adapts the iteration produced by positions() to return elements. */
	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> posIterator = positions().iterator();
		public boolean hasNext() { return posIterator.hasNext(); }
		public E next() { return posIterator.next().getElement(); }
		public void remove() { posIterator.remove(); }
	}
    public boolean isInternal(Position<E> p) { return numChildren(p) > 0; }
    public boolean isExternal(Position<E> p) { return numChildren(p) == 0; }
    public boolean isRoot(Position<E> p) { return root() == p; }
    public boolean isEmpty() {return size() ==0; }
    /** Returns the number of levels separating Position p from the root. */
    public int depth(Position<E> p) {
    	if (isRoot(p)){
    		return 0;
    	}
    	else {
    		return (1 + depth(parent(p)));
    	}
    }
    /** Returns the height of the tree. */
    @SuppressWarnings("unused")
	private int heightBad() {		// works, but quadratic worst-case  time
    	int h = 0;
    	for (Position<E> p: positions())
    		if (isExternal(p))
    			h = Math.max(h,depth(p));
    	return h;
    }

    public int height(Position<E> p) {
    	int h = 0;
    	for (Position<E> c: children(p))
    		h = Math.max(h,1 + height(c));
    	return h;
    }

	public Iterator<E> iterator() {
		return new ElementIterator();
	}
    
    /** Adds positions of the subtree rooted at Position p to the given snapshot. */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
    	snapshot.add(0,p);				// for preorder, we add position p before exploring subtrees
    	for (Position<E> c:children(p))
    		preorderSubtree(c,snapshot);
    }

    /** Returns an iterable collection of positions of the tree, reported in postorder. */
    @SuppressWarnings("unchecked")
	public Iterable<Position<E>> preorder() {
    	List<Position<E>> snapshot = new ArrayList<>();
    	if (!isEmpty())
    		preorderSubtree(root(), snapshot);
    	return (Iterable<Position<E>>) snapshot;
    }

    /** Adds positions of the subtree rooted at Position p to the given snapshot. */
    @SuppressWarnings("unused")
	private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
    	for (Position<E> c: children(p))
    		postorderSubtree(c,snapshot);
    	snapshot.add(0,p);
    }

    /** Returns an iterable collection of positions of the tree in breadth-first order. */
	@SuppressWarnings("unchecked")
	public Iterable<Position<E>> breadthfirst() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			Queue<Position<E>> fringe = new LinkedQueue<>();
			fringe.enqueue(root());
			while(!fringe.isEmpty()){
				Position<E> p = fringe.dequeue();
				snapshot.add(0,p);
				for(Position<E> c:children(p))
					fringe.enqueue(c);
			}
		}
		return (Iterable<Position<E>>) snapshot;
	}    


}
