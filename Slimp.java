import java.util.ArrayList;
/**
 * @author Andrew Stubbs
 * @version 3/22/15
 * The definition of the Slimp rule of the ENBF
 */

public class Slimp {

	protected int nextToken;
	protected char lexeme;
	protected ArrayList<Character> chars;
	protected final Character A = 'A';
	protected final Character H = 'H';
	protected final Character B = 'B';
	protected final Character C = 'C';
	
	public Slimp(int curToken, Character lxm, ArrayList<Character> charList, Slurpy x){
		Slurpy slurpy = x;
		nextToken = curToken;
		lexeme = lxm;
		chars = charList;
		System.out.println("Enter <slimp>");
		
		try {
			//Evaluates the Slimp rule of the ENBF, calling Slump when appropriate
			if(lexeme == A && chars.get(nextToken+1) == H){
				System.out.println("Next token is: " + nextToken +" Next lexeme is: " + lexeme );
				System.out.println("Next token is: " + (nextToken+1) +" Next lexeme is: " + chars.get(nextToken+1));
				nextToken += 2;
				lexeme = chars.get(nextToken);
			}

			else if(lexeme == A){
				System.out.println("Next token is: " + nextToken +" Next lexeme is: " + lexeme );
				nextToken++;
				lexeme = chars.get(nextToken);
				if(lexeme == B){
						System.out.println("Next token is: " + nextToken +" Next lexeme is: " + lexeme );
						nextToken++;
						lexeme = chars.get(nextToken);

					Slimp slimp2 = new Slimp(nextToken, lexeme, chars, slurpy);
					nextToken = slimp2.getNextToken();
					lexeme = slimp2.getLexeme();
					if(lexeme == C){
						System.out.println("Next token is: " + nextToken +" Next lexeme is: " + lexeme );
						nextToken++;
						lexeme = chars.get(nextToken);
					}
					else{
						slurpy.setStatus(false);
					}
				}
				else{
					Slump slump2 = new Slump(nextToken, lexeme, chars, slurpy);
					nextToken = slump2.getNextToken();
					lexeme = slump2.getLexeme();
					if(lexeme == C){
						System.out.println("Next token is: " + nextToken +" Next lexeme is: " + lexeme );
						nextToken++;
						lexeme = chars.get(nextToken);
					}
					else{
						slurpy.setStatus(false);
					}
				}
			}
			else{
				slurpy.setStatus(false);
			}
		} catch (Exception e) {
			slurpy.setStatus(false);
		}
	System.out.println("Exit <slimp>");
	}
	/**
	 * 
	 * @return the next lexeme to be evaluated
	 */
	public Character getLexeme(){
		return lexeme;
	}
	/**
	 * 
	 * @return the token of the next lexeme to be evaluated
	 */
	public int getNextToken(){
		return nextToken;
	}
}
