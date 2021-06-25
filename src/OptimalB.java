import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

 
public class OptimalB {
	static String start;
	static List<String> goals=new ArrayList<String>();
	static List<String> goals2=new ArrayList<String>();
	static List<String> goals3=new ArrayList<String>();
	
	public OptimalB(String start, List<String> goals){
		this.start=start;
		setGoals(goals);
	}
	
	public void setGoals(List<String> g) {
		for(int i=0;i<g.size();++i){
			goals.add(g.get(i));
			goals2.add(g.get(i));
			goals3.add(g.get(i));
	}}

	public static List<Double> cost =new ArrayList<Double>();
	public static List<Node> path =new ArrayList< Node>();
	public static List<String> finalPath =new ArrayList< String>();

	public void cost() throws FileNotFoundException {
		//List<String> goals2 = goals; 
		path.clear();
		cost.clear();
		finalPath.clear();
		   List<ArrayList<Node>> list=UIController.list;
		   //System.out.println(list.size());
		   Node s= new Node(start,0,0);
	       Queue<Node> q= new LinkedList<Node>();
	       
	       boolean found=false;
	       for(int i=0; i<list.size();i++) {
	    	   
	    	   if(list.get(i).get(0).getCity().equals(start)) {
	    		   path.add(s);
				   System.out.println("start--"+start+path);
	    		 addToQueue(q,start,list,path);	 
	    		 while( !goals.isEmpty() && q.size() != 0) {  			 
	    			 System.out.println("---"+q.toString());
	    			 if (goals.contains(q.peek().getCity())) {
	    				   System.out.println("CITYYY--"+q.peek().getCity());
	    				   goals.remove(q.peek().getCity());
	    				 path.add(q.peek());
	    				 Node n=q.peek();
	    				 q.clear();
	    				 q.add(n);
	    			 }
	    			 
	    			 else {
	    				   System.out.println("OIUHYG----"+q.peek().getCity());
	    				 path.add(q.peek());
	    				 addToQueue(q,q.peek().getCity(),list,path);
	    				 q.poll();
	    			 }
	    		// q.poll();
	    			// if(index<goals.)
	    		 }    		  
	    		   }
	    		   
	    	   }
		   System.out.println(path);

	      
	    	     
	   if(goals.isEmpty()){
		   findPath(path);
	   }
	   cost.add(0.0);


}
public static void addToQueue(Queue<Node> q,String S, List<ArrayList<Node>> l, List<Node> visited) {
	 Node temp ;
		 for(int i=0; i<l.size();i++) {	 
	    	   if(l.get(i).get(0).getCity().equals(S)) {
	    		   for(int j=1; j<l.get(i).size();j++) {
	    			 temp =l.get(i).get(j);
	    			 temp.setParent(S);
	    			 String s=temp.getCity();
	    		   if ((!q.stream().anyMatch(p->p.getCity().equals(s)))&& !visited.stream().anyMatch(p->p.getCity().equals(s))){
	    			   q.add(temp);
	    			   }
	    		   }
	}
		 }
}

public void findPath(List<Node> p){
	double co=0;
    Stack<Node> st= new Stack<Node>();
	st.add(0, p.get(p.size()-1));
	
	System.out.println("---"+st.peek().toString());
	while(!st.peek().getCity().equals(start) && !goals2.isEmpty() ){
		//System.out.println(p.size());
	for(int i=0;i<p.size();++i){
		if(p.get(i).getCity().equals(st.peek().getParent()))
		{
			st.push(p.get(i));
			System.out.println(start+"----- "+st.peek());
			if( goals2.contains(p.get(i).getCity()))
				goals2.remove(p.get(i).getCity());
		}		
		
		
	}
	}
	
	String preCity=null;
	while(st.size()>0){
		Node o=st.pop();
		//if(!preCity.equals(o.city)){
		co+=o.getStreetDis();
		finalPath.add(o.getCity());
		//}
	}
	
	cost.add(co);
	System.out.println(finalPath);
}

}