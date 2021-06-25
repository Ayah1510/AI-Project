import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class city {
	public static List<ArrayList<Node>> list =new ArrayList<ArrayList<Node> >(30);
	public static void main(String[] args){
		try{
			Scanner sc = new Scanner(new File("input.txt"));
			while (sc.hasNextLine()) {
				List<Node> list2 = new ArrayList<Node>();
				String s[]= sc.nextLine().split(":|,");        //split by : and ,
				list2.add(new Node(s[0],0,0));
				for(int i=1;i<s.length;i+=3){
					String city=s[i];
					double areal=Double.parseDouble(s[i+1]);
					double street=Double.parseDouble(s[i+2]);
					list2.add(new Node(city,areal,street));
				}
				list.add((ArrayList<Node>) list2);
			}
			sc.close();
		} catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		}
		/*for (int i = 0; i < list.size(); i++) {
		    for (int j = 0; j < list.get(i).size(); j++) {
		        System.out.print(list.get(i).get(j).toString() + " ");
		   }
		    System.out.println();
		}*/
		List<String> goals = new ArrayList<String>();
		//goals.add("Bethlehem");
		goals.add("Akko");
		Greedy gd= new Greedy("Gaza",goals);
		double sum=gd.fun();
		if(sum==0)
			System.out.println("Can't reach the city");
		else{
		DecimalFormat df = new DecimalFormat("#.0");
		System.out.println(df.format(sum));
		}
		List<String> vc=Greedy.visitedCities;
		for (int l = 0; l < vc.size(); l++) 
	        System.out.print(vc.get(l) + " ");
		
}
}
