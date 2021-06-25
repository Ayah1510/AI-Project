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

public class UIController implements Initializable{
	

	  @FXML
	    private Button GreedyMap;

	    @FXML
	    private CheckComboBox<String> goalCities;

	    @FXML
	    private CheckComboBox<String> startCities;
	    
	    @FXML
	    private Button cal;
	    @FXML
	    private Button cost;
	    	    
	    @FXML
	    private CheckBox greedyCheck;

	    @FXML
	    private CheckBox breadthCheck;

	    @FXML
	    private CheckBox GoptimalCheck;
	    @FXML
	    private CheckBox BoptimalCheck;

	    public static List<ArrayList<Node>> list =new ArrayList<ArrayList<Node> >(30);
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
	    	list.clear();
	    	ReadData();
	    	ObservableList<String> cities = FXCollections.observableArrayList();
	    	for (int i = 0; i < list.size(); i++) 
			    cities.add(list.get(i).get(0).city);
	    	startCities.getItems().addAll(cities);
	    	goalCities.getItems().addAll(cities);

	    }
	    
		public void ReadData(){
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
				List<Node> temp = new ArrayList<Node>();
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
			/*List<String> goals = new ArrayList<String>();
			goals.add("Gaza");
			goals.add("Akko");
			Greedy gd= new Greedy("Ramallah",goals);
			double sum=gd.fun();
			if(sum==0)
				System.out.println("Can't reach the city");
			else{
			DecimalFormat df = new DecimalFormat("#.0");
			System.out.println(df.format(sum));
			}
			List<String> vc=Greedy.visitedCities;
			for (int l = 0; l < vc.size(); l++) 
		        System.out.print(vc.get(l) + " ");*/
		}
	    
	    @FXML
	    public void calc(ActionEvent event) throws IOException{
	    	GCities.clear();
	    	Gcost.clear();
	    	BCities.clear();
	    	Bcost.clear();
	    	OptimalGCities.clear();
	    	OptimalGcost.clear();
	    	OptimalBCities.clear();
	    	OptimalBcost.clear();
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
		    		GreedyRead gd= new GreedyRead(startCities.getCheckModel().getCheckedItems().get(i),goals);
		    		gd.ReadData();
		    		double sum=gd.fun();
		    		List<String> vc= new ArrayList<String>();
		    		for (int k = 0; k < GreedyRead.visitedCities.size(); k++) 
		    			vc.add(GreedyRead.visitedCities.get(k));
		    		GCities.add((ArrayList<String>) vc);
		    	
		    		Gcost.add(sum);
		    		
	    		}
	    	}
	    	if(breadthCheck.isSelected()==true){
		    		List<String> goals = goalCities.getCheckModel().getCheckedItems();
		    		List<String> start = startCities.getCheckModel().getCheckedItems();
		    		for(int i=0;i<start.size();++i){
			    		Breadth bd= new Breadth(startCities.getCheckModel().getCheckedItems().get(i),goals);
			    		bd.cost();
			    		List<Double> sum=Breadth.cost;
			    		List<String> vc= new ArrayList<String>();
			    		for (int k = 0; k < Breadth.finalPath.size(); k++) 
			    			vc.add(Breadth.finalPath.get(k));
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
			    		OptimalB gd= new OptimalB(startCities.getCheckModel().getCheckedItems().get(i),goals);
			    		gd.cost();
			    		List<Double> sum=OptimalB.cost;
			    		List<String> vc= new ArrayList<String>();
			    		for (int k = 0; k < OptimalB.finalPath.size(); k++) 
			    			vc.add(OptimalB.finalPath.get(k));
			    		if(!vc.isEmpty())
			    		OptimalBCities.add((ArrayList<String>) vc);
			    	
			    		double costR=sum.get(0);
			    		//double costA=sum.get(1);
			    		OptimalBcost.add(costR);
			    	
		    		}
		    	}
	    	if(GoptimalCheck.isSelected()==true){
	    		List<String> goals = goalCities.getCheckModel().getCheckedItems();
	    		List<String> start = startCities.getCheckModel().getCheckedItems();
	    		for(int i=0;i<start.size();++i){
	    			OptimalGNew gd= new OptimalGNew(startCities.getCheckModel().getCheckedItems().get(i),goals);
		    		gd.ReadData();
		    		double sum=gd.fun();
		    		List<String> vc= new ArrayList<String>();
		    		for (int k = 0; k < OptimalGNew.visitedCities.size(); k++) 
		    			vc.add(OptimalGNew.visitedCities.get(k));
		    		OptimalGCities.add((ArrayList<String>) vc);
		    	
		    		OptimalGcost.add(sum);
		    		
	    		}
	    	}
	    	
	    	 Stage stage =(Stage) cal.getScene().getWindow();
				Parent root= FXMLLoader.load(getClass().getResource("Result.fxml"));
				Scene scene= new Scene(root);
				stage.setScene(scene);
				stage.show();
	    	
	    }
	    @FXML
	 	public void greedyMap (ActionEvent event) throws IOException { 
	 		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("map.fxml"));
	 		AnchorPane root= (AnchorPane)fxmlloader.load();
	 	    Stage stage= new Stage();
	 	    stage.setScene(new Scene(root));
	 	    stage.show(); 	
	 	}
	    @FXML
	 	public void streetMap (ActionEvent event) throws IOException { 
	 		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("StreetMap.fxml"));
	 		AnchorPane root= (AnchorPane)fxmlloader.load();
	 	    Stage stage= new Stage();
	 	    stage.setScene(new Scene(root));
	 	    stage.show(); 	
	 	}
	    @FXML
	 	public void cost (ActionEvent event) throws IOException { 
	 		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("CostUI.fxml"));
	 		AnchorPane root= (AnchorPane)fxmlloader.load();
	 	    Stage stage= new Stage();
	 	    stage.setScene(new Scene(root));
	 	    stage.show(); 	
	 	}
}
