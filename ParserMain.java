import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Andrew Stubbs
 * @version 3/23/15
 * Prompts the user to enter Strings and determines if the fit the ENBF describing Slurpy
 * by calling the various methods which describe its transitions
 * 
 * EBNF
 * <slurpy> -> <slimp> <slump>
 * 
 * <slimp> -> AH | A (B <slimp> | <slump>) C
 * 
 * <slump> -> (D|E) {F} (<slump> | G)
 *
 */

public class ParserMain {

		public static void main(String[] args){
			
			//Prompt for input
			Scanner sc = new Scanner(System.in);
			while(true){
			System.out
					.println("Please enter a String to be determined or \"Quit\" to exit: ");
			String input = sc.nextLine();
			//Quit on "Quit" command
			if (input.equals("Quit")) {
				break;
			} else {
				//Break the input String into an ArrayList and call the Slurpy class
				ArrayList<Character> inputChars = new ArrayList<Character>();
				for (int i = 0; i < input.length(); i++) {
					inputChars.add(input.charAt(i));
				}
				//If the status of the Slurpy class has been set to false, print that the String
				//is a Slurpy. Otherwise, print that it is not.
				Slurpy slurpy = new Slurpy(inputChars);
				if (slurpy.getStatus()) {
					System.out.println("The input String is a slurpy");
				} else {
					System.out.println("The input String is not a slurpy");
				}
			}
		}

	}
}
