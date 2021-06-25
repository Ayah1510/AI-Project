
import java.util.ArrayList;
import java.util.List;


public class CostGreedy {
	String start;
	List<String> goals;
	
	public CostGreedy(String start, List<String> goals){
		this.start=start;
		this.goals=goals;
	}
	public static List<String> visitedCities =new ArrayList<String>();
	public double fun(){
		visitedCities.clear();
		List<ArrayList<Node2>> list=CostUI.list;
		//List<String> visitedCities = new ArrayList<String>();
		visitedCities.add(start);
		String city=start;
		double least=0,cost=0;
		for(int i=0;i<list.size();++i){
			int i2=i;
			int j;
			if(city.equals(list.get(i).get(0).city)){
				for(j=1;j<list.get(i).size();++j){
					if(!visitedCities.contains(list.get(i).get(j).city)){
						least=list.get(i).get(j).getCost();
						visitedCities.add(list.get(i).get(j).city);
						city=list.get(i).get(j).city;
						i=-1;
						break;
					}
				}
				for(int k=j+1;k<list.get(i2).size();++k){
					if(least>list.get(i2).get(k).getCost()&&!visitedCities.contains(list.get(i2).get(k).city)){
						least=list.get(i2).get(k).getCost();

						visitedCities.remove(visitedCities.size()-1);
						visitedCities.add(list.get(i2).get(k).city);
						city=list.get(i2).get(k).city;
				}
				}
				cost+=least;
				if(goals.contains(city))
						return cost;
			}
		}
		return 0;
	}
}
