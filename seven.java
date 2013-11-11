import java.io.*;
import java.util.*;

class one { 
	static int counter = 0;
	HashMap<String, Integer> codename = new HashMap<String, Integer>();
	public static void main(String[] args) throws Exception { 
		String line;
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Hashmap<Integer, Vertex> hm = new HashMap<Integer, Vertex>();
		while((line=reader.readLine())!=null) {
			String [] token = line.split(" ");
			
			if(token[0].equals("add")){	
			 int n = getId(Integer.parseInt(token[1]));				
			 int m = getId(Integer.parseInt(token[2]));
			 Vertex v, u;				 
			if(hm.get(n) == null && hm.get(m) == null){
			    v = new Vertex(n);		
			    u = new Vertex(m);
		            v.addneighbor(new pair(u, 1));
		            u.addneighbor(new pair(v, 1));
			 }
			}
			
		}
	}
	public static int getId(String name){

		if(hm.get(name) == null){
			hm.put(name, counter);
			int save = counter;
			counter++;	
			return save;
		}
		return hm.get(name);
	}
	

	static class pair<V,E>{
		V vertex;
		E edge;
		public pair(V v, E e){
			vertex = v;
			edge = e;
		}
	}

	static class Vertex implements Comparable<Vertex>{
		int id;
		ArrayList<pair<Vertex, Integer>> neighbor = new ArrayList<pair<Vertex, Integer>>();
		int dist = Integer.MAX_VALUE;
		boolean visit = false;
		Vertex from;
		Vertex to;		
		public Vertex(int i){ id = i; }
		public void reset() { dist = Integer.MAX_VALUE; visit = false; from = null; }
		public void addNeighbor(pair<Vertex, Integer> p) {neighbor.add(p);}
	}
}


