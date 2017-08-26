package dasinjava.recursion;

public class R_5_8 {
    public static StringBuilder int2str(String s, int index){
    	int l =s.length()-1;
    	StringBuilder str = new StringBuilder();
    	if (index<0) return new StringBuilder();
    	else {
    		StringBuilder letter = new StringBuilder().append(s.charAt(index));
    		if ((l-index+1)%3==0&&index!=0){letter.insert(0, ",");}
			str.append(int2str(s, index-1)).append(letter);
    	}
    	return str;
    }
    public static StringBuilder int2str(String s){
    	return int2str(s,s.length()-1);
    }
    public static void main(String[] args) {
    	int i1 =23245267;
    	int i2 =3245267;
    	int i3 =245267;
    	System.out.println(int2str(Integer.toString(i1)));
    	System.out.println(int2str(Integer.toString(i2)));
    	System.out.println(int2str(Integer.toString(i3)));
    }
}
