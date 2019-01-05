/**
 * 
 * @author jiajianou
 * 
 * Basic tokenizer; it identifies whether or not a set of strings to be legal tokens.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Tokenize {
	
	private String tokenList = "";
	private String original = "";
	private ArrayList<String> tokenArray = new ArrayList<>();
	
	private String letters = "abcdefghijklmnopqrstuvwxyz";
	private String numbers = "0123456789";
	private String operators = "+-*/";
	
	private int currentState = 0;


	public Tokenize(String s) {
		
		String strippedString = s.replace(" ", "");		//stripes white spaces
		original = s;
		
		for (int i = 0; i < strippedString.length(); i++) {							//loop each string character
			
			String currentString = String.valueOf(strippedString.charAt(i));
			
			
			//____________________________________Start state
			if (currentState == 0) {
				
				
				
				if (letters.contains(currentString)) {
					currentState = 1;
					i--;										//reset  the state, re do the previous loop.
					tokenList += " Ident";
					tokenArray.add("Ident");
					
				} else if (numbers.contains(currentString)) {
					currentState = 2;
					i--;
					tokenList += " Number";
					tokenArray.add("Number");
					
				} else if (operators.contains(currentString)) {
					currentState = 3;
					tokenList += " Operator";
					tokenArray.add("Operator");
					
				} else if (currentString.equals("=")) {
					currentState = 0;
					tokenList += " Assignment";
					tokenArray.add("Assignment");
				
					
				} else {
					
					tokenList += " Error";
					tokenArray.add("Error");
					break;
				}


				
			//_______________________________________Identifier state	
			} else if (currentState == 1) {

				
				if (letters.contains(currentString) || numbers.contains(currentString)) {
					currentState = 1;
				} else {
					currentState = 0;
					i--;
				}
				
			
			//___________________________________________Numbers state
			} else if (currentState == 2) {
				
				
				
				if (numbers.contains(currentString)) {
					currentState = 2;
				} else {
					currentState = 0;
					i--;
				}
				
			//___________________________________________Operators state
			} else if (currentState == 3) {
				
				
				if (operators.contains(currentString)) {
					currentState = 0;
					tokenList += " Error";
					tokenArray.add("Error");
					break;
					
					
				} else {
					currentState = 0;
					i--;
				}			
			}
		}		
	}
	
	public String toString() {
		
		String output = String.format("%-40s %s",original,"tokenizes as \t" + tokenList);
		
		return output;		
	}
	
	public ArrayList<String> tokenArray() {
		
		return tokenArray;
	}
	

	
	
	
//main	
public static void main (String [] args) {
		
		File textFile = new File("Resources/Examples.txt");
		
		try {
			Scanner reader = new Scanner(textFile);
			
			while (reader.hasNext()) {
				//System.out.println(reader.nextLine());
				
				System.out.println(new Tokenize(reader.nextLine()));
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
}
