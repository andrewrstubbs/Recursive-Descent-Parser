import java.util.ArrayList;
/**
 * @author Andrew Stubbs
 * @version 3/22/15
 * The definition of the Slump rule of the ENBF
 */

public class Slump {
	
	protected int nextToken;
	protected char lexeme;
	protected ArrayList<Character> chars;
	protected Slurpy slurpy;
	protected final Character D = 'D';
	protected final Character E = 'E';
	protected final Character F = 'F';
	protected final Character G = 'G';
	
	public Slump(int curToken, Character lxm, ArrayList<Character> charList, Slurpy x){
		System.out.println("Enter <slump>");
		
		nextToken = curToken;
		lexeme = lxm;
		chars = charList;
		slurpy = x;
		
		try {
			//Evaluates the Slump rule of the ENBF, calling the Slump class when appropriate
			if(lexeme == D || lexeme == E ){
				System.out.println("Next token is: " + nextToken +" Next lexeme is: " + lexeme );
				nextToken++;
				lexeme = chars.get(nextToken);
				while(lexeme == 'F'){
					System.out.println("Next token is: " + nextToken +" Next lexeme is: " + lexeme );
					nextToken++;
					lexeme = chars.get(nextToken);
				}
				if(lexeme == G){
					System.out.println("Next token is: " + nextToken +" Next lexeme is: " + lexeme );
					if(chars.size() > nextToken+1){
						nextToken++;
						lexeme = chars.get(nextToken);
					}
					
					
				}
				else{
					Slump slump3 = new Slump(nextToken, lexeme, chars, slurpy);
					lexeme = slump3.getLexeme();
					nextToken = slump3.getNextToken();
				}
			}
			else{
				slurpy.setStatus(false);
			}
		} catch (Exception e) {
			slurpy.setStatus(false);
		}
		System.out.println("Exit <slump>");
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

