import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptimalGNew {
	String start;
	List<String> goals=new ArrayList<String>();

	//for()
	HashMap<String, ArrayList<ArrayList<Node>>> Glist = new HashMap<String,  ArrayList<ArrayList<Node>>>();


	public OptimalGNew(String start, List<String> goals){
		this.start=start;
		setGoals(goals);
	}
	public void setGoals(List<String> g) {
		for(int i=0;i<g.size();++i)
			goals.add(g.get(i));
	}
	public void ReadData(){
		try{
			Scanner sc = new Scanner(new File("greedyInput.txt"));
			List<String> goals2=new ArrayList<String>();
			for(int i=0;i<goals.size();++i)
				goals2.add(goals.get(i));

			while (sc.hasNextLine() && goals2.isEmpty()==false) {
			    ArrayList<ArrayList<Node>> Dlist =new ArrayList<ArrayList<Node> >(30);

				String key=sc.nextLine().toString();
			
				if(goals2.contains(key)){
				for (int j=0;j<19;j++){
					ArrayList<Node> list2 = new ArrayList<Node>();

					String s[]= sc.nextLine().split(","); //split by : and ,
					list2.add(new Node(s[0],0,0));
					double he=Double.parseDouble(s[1]);
					list2.get(0).setHeuristic(he);
					for(int i=2;i<s.length;i+=2){
						String city=s[i];
						double areal=Double.parseDouble(s[i+1]);
						list2.add(new Node(city,areal,0.0));
					}

					Dlist.add((ArrayList<Node>) list2);

				}
				Glist.put(key ,Dlist);
				
				ArrayList<ArrayList<Node>> list = Glist.get(key);
				}
			
			else{
				for (int j=0;j<19;j++){
					String m;
					if(sc.hasNextLine())
						 m = sc.nextLine().toString(); //split by : and ,
				}
			}
			if(goals2.contains(key))
					goals2.remove(key);

				}		
			sc.close();

			
		} catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		}
	}
	public static List<String> visitedCities =new ArrayList<String>();
	public double fun(){		
		visitedCities.clear();
		visitedCities.add(start);
		String city=start;
		double least=0,cost=0;
		List<ArrayList<Node>> orgList=UIController.list;
		//	for (Map.Entry<String, ArrayList<ArrayList<Node>>> g : Glist.entrySet()) {
			for(String keyCity : Glist.keySet()){
				System.out.println("/////");
				ArrayList<ArrayList<Node>> list=(ArrayList<ArrayList<Node>>) Glist.get(keyCity);
						//g.getValue();
	            for(int i=0;i<list.size();++i){
					int i2=i;
					int j;
	            if(city.equals(list.get(i).get(0).city)){
				for(j=1;j<list.get(i).size();++j){
					if(!visitedCities.contains(list.get(i).get(j).city)){
						least=list.get(i).get(j).arealDis;
						visitedCities.add(list.get(i).get(j).city);
						city=list.get(i).get(j).city;
						i=-1;
						break;
					}
				}
				for(int k=j+1;k<list.get(i2).size();++k){
					if(least>list.get(i2).get(k).arealDis&&!visitedCities.contains(list.get(i2).get(k).city)){
						least=list.get(i2).get(k).arealDis;

						visitedCities.remove(visitedCities.size()-1);
						visitedCities.add(list.get(i2).get(k).city);
						city=list.get(i2).get(k).city;
				}
				}
				//cost+=least;
				System.out.println(visitedCities);
				System.out.println(goals);

				if(goals.contains(city))
					goals.remove(city);
				System.out.println(goals.size()+"---");

				if(goals.isEmpty()==true){
					System.out.println(goals.size()+"---");
					for(int m=0;m<visitedCities.size()-1;m++){
						for(int l=0;l<orgList.size();++l){
							if(visitedCities.get(m).equals(orgList.get(l).get(0).city)){
								List<Node> listA=orgList.get(l);
								for(int p=1;p<listA.size();++p){
									if(listA.get(p).city.equals(visitedCities.get(m+1))){
										cost+=listA.get(p).getStreetDis();
									}
								}
							}
						}
					}
					return cost;
				}
					
			}
		}
			}
		return 0;
	}
	
}
