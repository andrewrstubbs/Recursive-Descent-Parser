import java.util.ArrayList;

/**
 * 
 * @author Andrew Stubbs
 * @version 3/22/15
 * The definition of the Slurpy rule of the ENBF
 *
 */
public class Slurpy {
	protected char lexeme;
	protected int nextToken;
	protected ArrayList<Character> chars;
	protected boolean status = true;
	
	public Slurpy(ArrayList<Character> charList){
		System.out.println("Enter <slurpy>");
		
		try {
			//Evaluates the slurpy rule, calling the Slimp and Slump classes as appropriate
			chars = charList;
			nextToken = 0;
			lexeme = chars.get(nextToken);
			
			Slimp slimp1 = new Slimp(nextToken, lexeme, chars, this);
			lexeme = slimp1.getLexeme();
			nextToken = slimp1.getNextToken();
			
			Slump slump1 = new Slump(nextToken, lexeme, chars, this);
			lexeme = slump1.getLexeme();
			nextToken = slump1.getNextToken();
			System.out.println(nextToken + "" + chars.size());
			if(chars.get(nextToken-1) == 'G'){
				if(chars.size() > nextToken){
					this.setStatus(false);
				}
			}

					
		} catch (Exception e) {
			this.setStatus(false);
		}

		System.out.println("Exit <slurpy>");
	}
	/**
	 * Sets the status of Slurpy to reflect whether or not the input String is a slurpy
	 * @param x the status to set
	 */
	public void setStatus(boolean x){
		status = x;
	}
	/**
	 * 
	 * @return the current status of Slurpy
	 */
	public boolean getStatus(){
		return status;
	}
}
