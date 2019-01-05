import java.util.ArrayList;

public class Test {
	
	
	
	
	
	public static void main (String [] args) {
		
		String [] tokenString = {"1","2"};
		ArrayList <String> tokenList = new ArrayList<>();
		tokenList.add("1");
		tokenList.add("2");
		tokenList.add("3");
		ArrayList<String> subTokenList = new ArrayList <>();
		subTokenList.add("4");
		subTokenList.add("5");
		
		ArrayList<ArrayList<String>> grammars = new ArrayList<>();
		
		ArrayList<String> g1 = new ArrayList<>();
		ArrayList<String> g2 = new ArrayList<>();
		ArrayList<String> g3 = new ArrayList<>();
		
		g1.add("1");
		g2.add("2");
		g3.add("3");
		
		grammars.add(g1);
		grammars.add(g2);
		grammars.add(g3);
		
		System.out.println(grammars);
 		
		
		
		
		//System.out.println(tokenList.contains("5"));
	}

}
