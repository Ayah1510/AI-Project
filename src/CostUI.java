
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.controlsfx.control.CheckComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CostUI implements Initializable{
	

	  	@FXML
	    private Button GreedyMap;

	    @FXML
	    private CheckComboBox<String> goalCities;

	    @FXML
	    private CheckComboBox<String> startCities;
	    
	    @FXML
	    private Button cal;
	    	    
	    @FXML
	    private CheckBox greedyCheck;

	    @FXML
	    private CheckBox breadthCheck;

	    @FXML
	    private CheckBox GoptimalCheck;
	    @FXML
	    private CheckBox BoptimalCheck;

	    public static List<ArrayList<Node2>> list =new ArrayList<ArrayList<Node2> >(30);
		public static List<ArrayList<String>> GCities =new ArrayList<ArrayList<String> >(30);
	    public static List<Double> Gcost =new ArrayList<Double>(30);
	    public static List<ArrayList<String>> BCities =new ArrayList<ArrayList<String> >(30);
	    public static List<Double> Bcost =new ArrayList<Double>(30);
		public static List<ArrayList<String>> OptimalGCities =new ArrayList<ArrayList<String> >(30);
	    public static List<Double> OptimalGcost =new ArrayList<Double>(30);
	    public static List<ArrayList<String>> OptimalBCities =new ArrayList<ArrayList<String> >(30);
	    public static List<Double> OptimalBcost =new ArrayList<Double>(30);
	    

	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	    	ReadData();
	    	ObservableList<String> cities = FXCollections.observableArrayList();
	    	for (int i = 0; i < list.size(); i++) 
			    cities.add(list.get(i).get(0).city);
	    	startCities.getItems().addAll(cities);
	    	goalCities.getItems().addAll(cities);

	    }
	    
		public void ReadData(){
			try{
				Scanner sc = new Scanner(new File("input2.txt"));
				while (sc.hasNextLine()) {
					List<Node2> list2 = new ArrayList<Node2>();
					String s[]= sc.nextLine().split(":|,");        //split by : and ,
					list2.add(new Node2(s[0],0));
					for(int i=1;i<s.length;i+=2){
						String city=s[i];
						double cost=Double.parseDouble(s[i+1]);
						list2.add(new Node2(city,cost));
					}
					list.add((ArrayList<Node2>) list2);
				}
				List<Node2> temp = new ArrayList<Node2>();
				for(int i=0; i<list.size();i++){     
			    	  for(int l=1;l<list.get(i).size()-1;l++) {
		               for(int j=1; j <((list.get(i).size())-l-1); j++){  
							  if((list.get(i).get(j).getCity()).compareTo(list.get(i).get(j+1).getCity())>0) {
							  //swap elements
							  Collections.swap(list.get(i),j,j+1);
		       
		                       }                          
		               } 	    	  
		       }
		 }

				sc.close();
			} catch (FileNotFoundException ex) {
			    ex.printStackTrace();
			}
			for (int i = 0; i < list.size(); i++) {
		    for (int j = 0; j < list.get(i).size(); j++) {
		        System.out.print(list.get(i).get(j).toString() + " ");
		   }
		    System.out.println();
		}
	
		}
	    
	    @FXML
	    public void calc(ActionEvent event) throws IOException{
	    	GCities.clear();
	    	Gcost.clear();
	    	BCities.clear();
	    	Bcost.clear();
	    	OptimalGCities.clear();
	    	OptimalGcost.clear();
	    	if(greedyCheck.isSelected()==false && breadthCheck.isSelected()==false&& GoptimalCheck.isSelected()==false && BoptimalCheck.isSelected()==false ){
		 	    Stage stage= new Stage();
		 	    Label label =new Label("Please choose at least one search algorithm");
		 	    label.relocate(50, 40);
		 	    label.setFont(new Font("Arial", 16));
		 	    Pane pane = new Pane(label);
		 	    Scene scene = new Scene(pane);
		 	    stage.setScene(scene);
		 	    stage.setWidth(420);
		 	    stage.setHeight(150);
		 	    stage.show(); 
	    	}	
	    	else if(goalCities.getCheckModel().isEmpty()==true){
	    		Stage stage= new Stage();
		 	    Label label =new Label("Please choose at least one Goal City");
		 	    label.relocate(50, 40);
		 	    label.setFont(new Font("Arial", 16));
		 	    Pane pane = new Pane(label);
		 	    Scene scene = new Scene(pane);
		 	    stage.setScene(scene);
		 	    stage.setWidth(370);
		 	    stage.setHeight(150);
		 	    stage.show(); 
	    	}
	    	else if(startCities.getCheckModel().isEmpty()==true){
	    		Stage stage= new Stage();
		 	    Label label =new Label("Please choose at least one Start City");
		 	    label.relocate(50, 40);
		 	    label.setFont(new Font("Arial", 16));
		 	    Pane pane = new Pane(label);
		 	    Scene scene = new Scene(pane);
		 	    stage.setScene(scene);
		 	    stage.setWidth(370);
		 	    stage.setHeight(150);
		 	    stage.show(); 
	    	}
	    	if(greedyCheck.isSelected()==true){
	    		List<String> goals = goalCities.getCheckModel().getCheckedItems();
	    		List<String> start = startCities.getCheckModel().getCheckedItems();
	    		for(int i=0;i<start.size();++i){
	    			CostGreedy gd= new CostGreedy(startCities.getCheckModel().getCheckedItems().get(i),goals);
		    		double sum=gd.fun();
		    		List<String> vc= new ArrayList<String>();
		    		for (int k = 0; k < CostGreedy.visitedCities.size(); k++) 
		    			vc.add(CostGreedy.visitedCities.get(k));
		    		GCities.add((ArrayList<String>) vc);
		    	
		    		Gcost.add(sum);
		    		for(int m=0;m<vc.size();++m)
		    		System.out.println(vc.get(m));
	}
	    	}
	    	if(breadthCheck.isSelected()==true){
		    		List<String> goals = goalCities.getCheckModel().getCheckedItems();
		    		List<String> start = startCities.getCheckModel().getCheckedItems();
		    		for(int i=0;i<start.size();++i){
			    		CostBreadth bd= new CostBreadth(startCities.getCheckModel().getCheckedItems().get(i),goals);
			    		bd.cost();
			    		List<Double> sum=CostBreadth.cost;
			    		List<String> vc= new ArrayList<String>();
			    		for (int k = 0; k < CostBreadth.finalPath.size(); k++) 
			    			vc.add(CostBreadth.finalPath.get(k));
			    		BCities.add((ArrayList<String>) vc);
			    		double costR=sum.get(0);
			    		//double costA=sum.get(1);
			    		Bcost.add(costR);
		    		}
	    		
	    	}
	    	if(BoptimalCheck.isSelected()==true){
		    		List<String> goals = goalCities.getCheckModel().getCheckedItems();
		    		List<String> start = startCities.getCheckModel().getCheckedItems();
		    		for(int i=0;i<start.size();++i){
		    			CostOptimalB gd= new CostOptimalB(startCities.getCheckModel().getCheckedItems().get(i),goals);
			    		gd.cost();
			    		List<Double> sum=CostOptimalB.cost;
			    		List<String> vc= new ArrayList<String>();
			    		for (int k = 0; k < CostOptimalB.finalPath.size(); k++) 
			    			vc.add(CostOptimalB.finalPath.get(k));
			    		OptimalBCities.add((ArrayList<String>) vc);
			    	
			    		double costR=sum.get(0);
			    		OptimalBcost.add(costR);
			    	
		    		}
		    	}
	    	if(GoptimalCheck.isSelected()==true){
	    		List<String> goals = goalCities.getCheckModel().getCheckedItems();
	    		List<String> start = startCities.getCheckModel().getCheckedItems();
	    		for(int i=0;i<start.size();++i){
	    			CostOptimalG gd= new CostOptimalG(startCities.getCheckModel().getCheckedItems().get(i),goals);
		    		double sum=gd.fun();
		    		List<String> vc= new ArrayList<String>();
		    		for (int k = 0; k < CostOptimalG.visitedCities.size(); k++) 
		    			vc.add(CostOptimalG.visitedCities.get(k));
		    		OptimalGCities.add((ArrayList<String>) vc);
		    	
		    		OptimalGcost.add(sum);
		    		
	    		}
	    	}
	    	
	    	 Stage stage =(Stage) cal.getScene().getWindow();
				Parent root= FXMLLoader.load(getClass().getResource("CostResult.fxml"));
				Scene scene= new Scene(root);
				stage.setScene(scene);
				stage.show();
	    	
	    }

}
