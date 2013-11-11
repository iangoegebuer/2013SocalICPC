
import java.io.*;
import java.util.*;

class four { 
	public static void main(String[] args) throws Exception { 
		String line;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


		while((line=reader.readLine()) != null) {
		int n=0;
			String numStr = line;
			
			while(!numStr.equals("1")) {
				n++;
				if(isEven(numStr))
					numStr = divideByTwo(numStr);
				else
					numStr = increment(multiplyByThree(numStr));
			}
			System.out.println(n);
		}
	}
	public static boolean isEven(String numStr) {
		char[] cs = numStr.toCharArray();
		return cs[cs.length-1]%2==0;
	}
	public static String divideByTwo(String numStr) {
		String newNum = "";
		char[] nums = numStr.toCharArray();
		int carry = 0;
		for(char numChar:nums) {
			int num = numChar - '0' + carry;

			if(num%2==1) {
				num--;
				carry=10;
			} else {
				carry=0;
			}
			num/=2;
			if(!newNum.isEmpty() || num!=0)
				newNum = newNum+num;
		}
		return newNum;
	}
			
	public static String multiplyByThree(String numStr) {
		String newString = "";
		char[] numChars = numStr.toCharArray();
		int carry=0;
		for(int i=numChars.length-1;i>=0;i--) {
			int charVal = (numChars[i]&0x0F)*3+carry;
			carry = charVal/10;
			charVal%=10;
			newString=charVal+newString;

		}		int n=0;
		if(carry>0)
			newString=carry+newString;
		return newString;
	}
	public static String increment(String numStr) {
		String newNum = "";
		char[] numChars = numStr.toCharArray();
		boolean keepIncrementing=true;
		for(int i=numChars.length-1;i>=0;i--) {
			int charVal = numChars[i]&0x0F;
			if(keepIncrementing) {
				charVal = (charVal+1)%10;
				keepIncrementing = charVal==0;
			}
			newNum = charVal+newNum;
		}
		if(keepIncrementing)
			newNum = "1" + newNum;
		return newNum;
	}
}


