import java.io.*;
import java.util.*;
/**
 * Word Game (scrabblesque) points calculator
 *  
 * @author         Michael Vartan
 * @author	   Ian Goegebuer
 */

class one { 
	public static void main(String[] args) throws Exception { 
		String line;
		ArrayList<Integer> values = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while((line=reader.readLine())!=null) {

			if(values.size()<27) {
				// first 27 digits  transmitted are scores for A-Z, wildcard
				String[] tokens = line.split(" ");
				for(String numStr:tokens)
					values.add(Integer.parseInt(numStr));
			}
			else {
				// after that, lines should be sent in pairs
				String line2 = reader.readLine(); // get second half of pair
				int wordMultiplier=1, wordValue=0;
				//line 1 is the multipliers. "...3.." would have a 3x char multiplier
				char[] multipliers = line.toCharArray();
				//line 2 is the actual letters of the word
				char[] letters = line2.toCharArray();
				int lineValue = 0;
				for(int i=0; i<multipliers.length;i++) {
					


				int letterValue =0;
				if((letters[i]>='A' && letters[i] <= 'Z')) 
					letterValue = values.get(letters[i]-'A');
				else 
					letterValue = values.get(26); // wildcard
						switch(multipliers[i]) {
							case '2':
								letterValue*=2;
							break;
							case '3':
								letterValue*=3;
							break;
							case 'd':
								wordMultiplier*=2;
							break;
							case 't':
								wordMultiplier*=3;
							break;
						}
						wordValue+=letterValue;

				}
				System.out.println(lineValue+wordValue*wordMultiplier);
			}			
			
		}
	}
}


