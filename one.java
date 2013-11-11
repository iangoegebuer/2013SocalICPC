
import java.io.*;
import java.util.*;

class one { 
	public static void main(String[] args) throws Exception { 
		String line;
		ArrayList<Integer> values = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while((line=reader.readLine())!=null) {

			if(values.size()<27) {
				String[] tokens = line.split(" ");
				for(String numStr:tokens)
					values.add(Integer.parseInt(numStr));
			}
			else {
				String line2 = reader.readLine();
				int wordMultiplier=1, wordValue=0;
				char[] multipliers = line.toCharArray();
				char[] letters = line2.toCharArray();
				int lineValue = 0;
				for(int i=0; i<multipliers.length;i++) {
					


						int letterValue =0;
			if((letters[i]>='A' && letters[i] <= 'Z')) letterValue = values.get(letters[i]-'A');
			else letterValue = values.get(26);
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


