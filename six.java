
import java.io.*;
import java.util.*;

class six { 
	public static void main(String[] args) throws Exception { 
		String line;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while((line=reader.readLine()) != null) {

			String [] token = line.trim().split(" ");			
			long n = Long.parseLong(token[0]);			
			long t = Long.parseLong(token[1]);			
			long b = Long.parseLong(token[2]);
			
			boolean on = false;
			
			
			//while(t > n) t -= n+1;
			t %= (n+1);
			if(t >= b) on = true;
			for(long i = 1; i <= t && i <= b/2;i++) {
				//System.out.println(i + " " + b%i);
				if((b%i)==0) on = !on;
				
			}	

		System.out.println(b + ": " + (on?"On":"Off"));
			

		}
	}



}


