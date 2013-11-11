import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;
class five { 
	public static void main(String[] args) throws Exception { 
		String line;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


HashMap<String, Double> dec = new HashMap<>();
HashMap<String, Double> bin = new HashMap<>();
dec.put("KB", Math.pow(10,3));
dec.put("MB", Math.pow(10,6));
dec.put("GB", Math.pow(10,9));
dec.put("TB", Math.pow(10,12));
dec.put("PB", Math.pow(10,15));
dec.put("EB", Math.pow(10,18));

bin.put("KiB", Math.pow(2,10));
bin.put("MiB", Math.pow(2,20));
bin.put("GiB", Math.pow(2,30));
bin.put("TiB", Math.pow(2,40));
bin.put("PiB", Math.pow(2,50));
bin.put("EiB", Math.pow(2,60));

	


		while((line=reader.readLine()) != null) {
			String[] tokens = line.split(" ");
			double num = Double.parseDouble(tokens[0]);
			double numVal = 0;
			if(dec.containsKey(tokens[1])) // convert from dec
				numVal = num*dec.get(tokens[1]);
			else
				numVal = num*bin.get(tokens[1]);
			DecimalFormat fm = new DecimalFormat("0.###");
			if(dec.containsKey(tokens[2])) // convert to dec	
				System.out.println(fm.format(numVal/dec.get(tokens[2]))+" "+tokens[2]);
			else
				System.out.println(fm.format(numVal/bin.get(tokens[2]))+" "+tokens[2]);

		}
	}
}
