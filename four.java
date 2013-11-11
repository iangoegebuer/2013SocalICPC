import java.io.*;
import java.util.*;

/**
 * Collatz conjecture tester. Counts how many iterations it takes before
 * collatz conjecture holds true. From wikipedia, collatz conjecture is 
 * described below.
 * <p>
 * Take any natural number n. If n is even, divide it by 2 to get n / 2. 
 * If n is odd, multiply it by 3 and add 1 to obtain 3n + 1. 
 * Repeat the process indefinitely. The conjecture is that no matter what 
 * number you start with, you shall always eventually reach 1.
 * <p>
 * I wrote algorithms for String arithmetic because I had never
 * heard of BigInteger. 
 *  
 * @author 	Michael Vartan
 */

class four { 
	
	/**
	 * Takes in arbitrarily large numbers and outputs how many steps it took to
	 * verify collatz conjecture
	 */
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
	/**
	 * Checks if a string contains an even integer of arbitrary size.
	 * 
	 * @param numStr	String containing the number in question.
	 * 
	 * @return		<code>true</code> if the string contains
	 * 			an even number.
	 */
	public static boolean isEven(String numStr) {
		char[] cs = numStr.toCharArray();
		return cs[cs.length-1]%2==0;
	}

	/**
	 * Divides an integer of arbitrary size by two.
	 * 
	 * @param numStr	String containing the number in question.
	 * 
	 * @return		numStr/2
	 */
	public static String divideByTwo(String numStr) {
		String newNum = "";
		char[] nums = numStr.toCharArray();
		int carry = 0;
		for(char numChar:nums) {
			int num = numChar - '0' + carry;

			if(num%2==1) {		
				// If a digit n is odd, the resulting digit will be
				// (n-1)/2. 10 should carry over to next calculation 
				// Ex. 126/2 = (1-1)/2, (2+10)/2, 6/2 = 0,6,3

				carry=10;	
			} else {
				// If the digit is even, there will be no carry.
				carry=0;
			}
			num/=2;
			
			// don't add a leading zero
			if(!newNum.isEmpty() || num!=0)
				newNum = newNum+num;
		}
		return newNum;
	}
	
	/**
	 * Multiplies an integer of arbitrary size by three.
	 * 
	 * @param numStr	String containing the number in question.
	 * 
	 * @return		numStr*3
	 */		
	public static String multiplyByThree(String numStr) {
		String newString = "";
		char[] numChars = numStr.toCharArray();
		int carry=0;
		
		// multiplication goes from right to left
		for(int i=numChars.length-1;i>=0;i--) {
			// perform character operation
			int charVal = (numChars[i]&0x0F)*3+carry;
			// carry the next decimal place.
			carry = charVal/10;
			// only add the last digit
			charVal%=10;
			newString=charVal+newString;

		}
		// don't add a leading zero.
		if(carry>0)
			newString=carry+newString;
		return newString;
	}
	/*
	 * Increments an integer of arbitrary size.
	 * 
	 * @param numStr	String containing the number in question.
	 * 
	 * @return		++numStr
	 */		
	public static String increment(String numStr) {
		String newNum = "";
		char[] numChars = numStr.toCharArray();
		
		boolean keepIncrementing=true;
		
		// addition goes from right to left
		for(int i=numChars.length-1;i>=0;i--) {
			int charVal = numChars[i]&0x0F;
			if(keepIncrementing) {
				// only keep incrementing when there is no carry.
				// ex. ++129999 = 130000
				charVal = (charVal+1)%10;
				keepIncrementing = charVal==0;
			}	// if no increment, number stays the same.
			
			newNum = charVal+newNum;
		}
		
		// if keepIncrementing is still true (ex. 9999999), add leading 1
		if(keepIncrementing)
			newNum = "1" + newNum;
		return newNum;
	}
}


