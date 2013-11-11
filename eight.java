import java.util.*;
import java.lang.*;
import java.io.*;
class eight { 
	
	public static void main(String[] args) throws Exception { 
		String line = "";

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String [] token = input.readLine().trim().split(" ");
		int n = Integer.parseInt(token[0]);
		int m = Integer.parseInt(token[1]);
		
		HashMap<Integer,PriorityQueue<Node>> list = new HashMap<Integer, PriorityQueue<Node>>();	
		while((line=input.readLine()) != null) {
			String [] t = line.trim().split(" ");
						
			PriorityQueue<Node> pq = list.get(Integer.parseInt(t[0]));
			if(pq == null){
				pq = new PriorityQueue<Node>();
				pq.add(new Node(t[1], Integer.parseInt(t[2])));
				list.put(Integer.parseInt(t[0]), pq);
			}else{
				pq.add(new Node(t[1], Integer.parseInt(t[2])));
				list.put(Integer.parseInt(t[0]), pq);	
			}
			
						
		}
		int counter = 0;
		int index = 1;
		HashSet<String> hs = new HashSet<String>();
		String [] problems = new String[n+1];
		for(int i = 1; i <= n; i++){
			PriorityQueue<Node> p = list.get(i);
			if(p == null || p.size() == 0){
				problems[i] = "Not Solved";
				counter++;
			}
		}
		
		/*for(int i = 1; i <= 5; i++){
			System.out.println(list.get(i));
		}*/ 
		while(!isFilled(problems)){
			//System.out.println(Arrays.toString(problems));
			if(index == n+1) index =1;
			if(problems[index] != null){ index++; continue;}
			PriorityQueue<Node> p = list.get(index);
			if(p.size() == 0){
				problems[index] = "No Award";
				index++; counter++;
				
			}else{
				Iterator<Node> itr = p.iterator();
				Node first = itr.next();
				if(!hs.contains(first.team)){
					problems[index] = first.team;
					counter++; index++;
					itr.remove();
					hs.add(first.team);
					//System.out.println(Arrays.toString(problems));
				}else{
					itr.remove(); index++;
				}
				
			}
			
			
			
		}
		for(int i = 1; i <= n; i++){
			System.out.println(i + ": " + problems[i]);
		}
		
		
	}
	static boolean isFilled(String [] problems){
		for(int i = 1; i < problems.length; i++){
			if(problems[i] == null) return false;
		}	
		return true;
	}	

	static class Node implements Comparable<Node>{
		String team;
		int time;
		public Node(String s,int i){
			team = s; 
			time = i;	
		}
		public int compareTo(Node n){
			if(this.time == n.time) return 0;
			return this.time < n.time ? -1 : 1;
		}
		public String toString(){ return team;}
	}
}
