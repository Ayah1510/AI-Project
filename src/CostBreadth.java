import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

 
public class CostBreadth {
	static String start;
	static List<String> goals;
	
	public CostBreadth(String start, List<String> goals){
		this.start=start;
		this.goals=goals;
	}
	public static List<Double> cost =new ArrayList<Double>();
	public static List<Node2> path =new ArrayList< Node2>();
	public static List<String> finalPath =new ArrayList< String>();

	public void cost() throws FileNotFoundException {
		path.clear();
		cost.clear();
		finalPath.clear();
		   List<ArrayList<Node2>> list=CostUI.list;
		   //System.out.println(list.size());
		   Node2 s= new Node2(start,0);
	       Queue<Node2> q= new LinkedList<Node2>();
	       
	       boolean found=false;
	       for(int i=0; i<list.size();i++) {
	    	   
	    	   if(list.get(i).get(0).getCity().equals(start)) {
	    		   path.add(s);
				   System.out.println("start--"+start+path);
	    		 addToQueue(q,start,list,path);	 
	    		 while(found==false && q.size() != 0) {  			 
	    			 System.out.println("---"+q.toString());
	    			 if (goals.contains(q.peek().getCity())) {
	    				   System.out.println("CITYYY--"+q.peek().getCity());
	    				 path.add(q.peek());
	    				 found=true;

	    			 }
	    			 
	    			 else {
	    				   System.out.println("OIUHYG----"+q.peek().getCity());
	    				 path.add(q.peek());
	    				 addToQueue(q,q.peek().getCity(),list,path);

	    			 }
	    		 q.poll();
	    		 }    		  
	    		   }
	    		   
	    	   }
		   System.out.println(path);

	       findPath(path);
	    	     
	   if(found==true)
	       System.out.println("s:::::"+start+path+"\n"+goals);
	   else
		   System.out.println("There is no path!");

	   System.out.println();


}
public static void addToQueue(Queue<Node2> q,String S, List<ArrayList<Node2>> l, List<Node2> visited) {
	 Node2 temp ;
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

public void findPath(List<Node2> p){
	double co=0;
    Stack<Node2> st= new Stack<Node2>();
	st.add(0, p.get(p.size()-1));
	System.out.println(st.peek().toString());
	while(!st.peek().getCity().equals(start)){
		//System.out.println(p.size());
	for(int i=0;i<p.size();++i){
		if(p.get(i).getCity().equals(st.peek().getParent()))
		{
			st.push(p.get(i));
			//System.out.println(start+"----- "+st.peek());

		}		
	}
	}
	
	while(st.size()>0){
		Node2 o=st.pop();
		co+=o.getCost();
		finalPath.add(o.getCity());
		
	}
	
	cost.add(co);
	System.out.println(finalPath);
}

}