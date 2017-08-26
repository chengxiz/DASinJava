package dasinjava.sqd;

@SuppressWarnings("rawtypes")
public class ArrayStackExample extends ArrayStack{
    public static void main(String[] args) {
    	Stack<Integer> S = new ArrayStack<>();		// contents: ()
    	S.push(5);									// contents: (5)
    	S.push(3);									// contents: (5,3)
    	System.out.println(S.size());				// contents: (5,3)		output: 2
    	System.out.println(S.pop());				// contents: (5)		output: 3
    	System.out.println(S.isEmpty());			// contents: (5)		output: false
    	System.out.println(S.pop());				// contents: ()			output: 5
    	System.out.println(S.isEmpty());			// contents: ()			output: true
    	System.out.println(S.pop());				// contents: ()			output: null
    	S.push(7);									// contents: (7)
    	S.push(9);									// contents: (7,9)
    	System.out.println(S.top());				// contents: (7,9)		output: 9
    	S.push(4);									// contents: (7,9,4)
    	System.out.println(S.size());				// contents: (7,9,4)	output: 3
    	System.out.println(S.pop());				// contents: (7,9)		output: 4
    	S.push(6);									// contents: (7,9,6)
    	S.push(8);									// contents: (7,9,6,8)    	
    	System.out.println(S.pop());				// contents: (7,9,6)	output: 8
    }
}
