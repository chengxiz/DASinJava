package dasinjava.ood;

public class Maryland extends State { 
	Maryland() { /* null constructor */ } 
	public void printMe() { 
		System.out.println("Read it."); 
	} 
	public static void main(String[] args) { 
		Region east = new State();
		State md = new Maryland();
		Object obj = new Place();
		Place usa = new Region();
		
		md.printMe();		
		east.printMe();
		System.out.println(((Place) obj).getClass().getName());
		System.out.println(obj.getClass().getName());
		((Place) obj).printMe();
		obj = md;
		System.out.println(((Maryland) obj).getClass().getName());
		System.out.println(obj.getClass().getName());
		((Maryland) obj).printMe();
		obj = usa;
		System.out.println(((Place) obj).getClass().getName());
		System.out.println(obj.getClass().getName());
		((Place) obj).printMe();
		usa = md;
		System.out.println(((Region) usa).getClass().getName());
		System.out.println(usa.getClass().getName());
		((Region) usa).printMe();
	}
}
class State extends Region { 
	State() { /* null constructor */ } 
	public void printMe() { 
		System.out.println("Ship it."); 
	}
}
class Region extends Place { 
	Region() { /* null constructor */ } 
	public void printMe() { 
		System.out.println("Box it."); }
}
class Place extends Object {
	 Place() { /* null constructor */ } 
	 public void printMe() { 
	 	System.out.println("Buy it."); }
}