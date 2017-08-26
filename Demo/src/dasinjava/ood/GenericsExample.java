package dasinjava.ood;

public class GenericsExample {
    public static class Pair<A,B>{
    	A first;
    	B second;
    	public Pair(A a, B b){
    		first = a;
    		second = b;
    	}
    	public A getFirst() {return first;}
    	public B getSecond() {return second;}
    }
    public static <T> void reverse(T[] data){
    	int low = 0, high=data.length -1;
    	while (low<high){
    		T temp=data[low];
    		data[low++]=data[high];
    		data[high--]=temp;
    	}
    }
    public static void main(String[] args) {
    	Pair<String,Double> bid = new Pair<String,Double>("ORCL", 32.07);  //give explicit types
    	System.out.println(bid.getFirst());
    	System.out.println(bid.getSecond());
    }
}
