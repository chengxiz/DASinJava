package dasinjava.fundds;

public class ScoreboardExample {
	public static void main(String[] args) {
	    	Scoreboard s = new Scoreboard(8);
	    	s.add(new GameEntry("Barry",89));
	    	s.add(new GameEntry("Tom",83));
	    	s.add(new GameEntry("Jared",85));
	    	for (int i=0; i<s.board.length;i++){System.out.println(s.board[i]);}
	    	s.remove(2);
	    	for (int i=0; i<s.board.length;i++){System.out.println(s.board[i]);}	    	

	    }    
}
