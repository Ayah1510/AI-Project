import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Result implements Initializable{
	
    @FXML
    private Button GMap;

    @FXML
    private Button OMap;

    @FXML
    private Button BMap;
    
    @FXML
    private Button btnBack;
    
    @FXML
    private ScrollPane GPane;
    
    @FXML
    private ScrollPane BPane;

    @FXML
    private ScrollPane GOPane;
    @FXML
    private ScrollPane BOPane;
    @FXML
    public static int Gindex;
    public static int Bindex;
    public static int OptimalGindex;
    public static int OptimalBindex;
    double Gmin,Bmin,OptimalGmin,OptimalBmin;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String Gtext="";
		String Btext="";
		String OptimalGtext="";
		String OptimalBtext="";
		Gmin=0;Bmin=0;OptimalGmin=0;OptimalBmin=0;
		if(UIController.Gcost.isEmpty()==false)
			 Gmin=UIController.Gcost.get(0);
		if(UIController.Bcost.isEmpty()==false)
			Bmin=UIController.Bcost.get(0);
		if(UIController.OptimalGcost.isEmpty()==false)
			OptimalGmin=UIController.OptimalGcost.get(0);
		if(UIController.OptimalBcost.isEmpty()==false)
			OptimalBmin=UIController.OptimalBcost.get(0);
		Gindex=0;
		Bindex=0;
		OptimalGindex=0;
		OptimalBindex=0;
		if(UIController.GCities.isEmpty()==false){
		for(int j=0;j<UIController.GCities.size();++j){
			String start=UIController.GCities.get(j).get(0);
			String end=UIController.GCities.get(j).get(UIController.GCities.get(j).size()-1);
			if(UIController.Gcost.get(j)!=0)
				Gtext+="From "+start+" to "+end+": ";
			else
				Gtext+="From "+start+": ";
			if(UIController.Gcost.get(j)!=0){
				for(int i=0;i<UIController.GCities.get(j).size();i++){
					Gtext+=UIController.GCities.get(j).get(i);
					if(i!=UIController.GCities.get(j).size()-1)
						Gtext+=" -> ";
				}
				Gtext+="\n"+"The road cost is: "+UIController.Gcost.get(j);
				Gtext+="\n";
				if(UIController.Gcost.get(j)<Gmin){
					Gmin=UIController.Gcost.get(j);
					Gindex=j;
				}
				
			}
			else
				Gtext+="Can't Reach the city\n";
			}
		String start=UIController.GCities.get(Gindex).get(0);
		String end=UIController.GCities.get(Gindex).get(UIController.GCities.get(Gindex).size()-1);
		if(Gmin!=0)
			Gtext+="\n"+"The least road cost is: "+Gmin+" ,from "+start+" to "+end;
		try{
		Text tx = new Text(Gtext);
		GPane.setContent(new TextFlow(tx));
		}
		catch (Exception e) {
			  
            System.out.println(e.getMessage());
        }
		}
		
		if(UIController.BCities.isEmpty()==false){
		for(int j=0;j<UIController.BCities.size();++j){
			String Bstart=UIController.BCities.get(j).get(0);
			String Bend=UIController.BCities.get(j).get(UIController.BCities.get(j).size()-1);
			if(UIController.Bcost.get(j)!=0)
				Btext+="From "+Bstart+" to "+Bend+": ";
			else
				Btext+="From "+Bstart+": ";
			if(UIController.Bcost.get(j)!=0){
				for(int i=0;i<UIController.BCities.get(j).size();i++){
					Btext+=UIController.BCities.get(j).get(i);
					if(i!=UIController.BCities.get(j).size()-1)
						Btext+=" -> ";
				}
				Btext+="\n"+"The road cost is: "+UIController.Bcost.get(j);
				Btext+="\n";
				if(UIController.Bcost.get(j)<Bmin){
					Bmin=UIController.Bcost.get(j);
					Bindex=j;
				}
				
			}
			else
				Btext+="Can't Reach the city\n";
			}
		String Bstart=UIController.BCities.get(Bindex).get(0);
		String Bend=UIController.BCities.get(Bindex).get(UIController.BCities.get(Bindex).size()-1);
		if(Bmin!=0)
		Btext+="\n"+"The least road cost is: "+Bmin+" ,from "+Bstart+" to "+Bend;
		try{
		Text tx = new Text(Btext);
		BPane.setContent(new TextFlow(tx));
		}
		catch (Exception e) {
			  
            System.out.println(e.getMessage());
        }
		}
		if(UIController.OptimalGCities.isEmpty()==false){
		
		for(int j=0;j<UIController.OptimalGCities.size();++j){
			String OptimalGstart=UIController.OptimalGCities.get(j).get(0);
			String OptimalGend=UIController.OptimalGCities.get(j).get(UIController.OptimalGCities.get(j).size()-1);
			if(UIController.OptimalGcost.get(j)!=0)
				OptimalGtext+="From "+OptimalGstart+" to "+OptimalGend+": ";
			else
				OptimalGtext+="From "+OptimalGstart+": ";
			if(UIController.OptimalGcost.get(j)!=0){
				for(int i=0;i<UIController.OptimalGCities.get(j).size();i++){
					OptimalGtext+=UIController.OptimalGCities.get(j).get(i);
					if(i!=UIController.OptimalGCities.get(j).size()-1)
						OptimalGtext+=" -> ";
				}
				OptimalGtext+="\n"+"The road cost is:"+UIController.OptimalGcost.get(j);
				OptimalGtext+="\n";
				if(UIController.OptimalGcost.get(j)<OptimalGmin){
					OptimalGmin=UIController.OptimalGcost.get(j);
					OptimalGindex=j;
				}
				
			}
			else
				OptimalGtext+="Can't Reach the city\n";
			}
		String OptimalGstart=UIController.OptimalGCities.get(OptimalGindex).get(0);
		String OptimalGend=UIController.OptimalGCities.get(OptimalGindex).get(UIController.OptimalGCities.get(OptimalGindex).size()-1);
		if(OptimalGmin!=0)
		OptimalGtext+="\n"+"The least road cost is: "+OptimalGmin+" ,from "+OptimalGstart+" to "+OptimalGend;
		try{
		Text tx = new Text(OptimalGtext);
		GOPane.setContent(new TextFlow(tx));
		}
		catch (Exception e) {
			  
            System.out.println(e.getMessage());
        }
		}
		
		
		if(UIController.OptimalBCities.isEmpty()==false ){
			
			for(int j=0;j<UIController.OptimalBCities.size();++j){
				String OptimalBstart=UIController.OptimalBCities.get(j).get(0);
				String OptimalBend=UIController.OptimalBCities.get(j).get(UIController.OptimalBCities.get(j).size()-1);
				if(UIController.OptimalBcost.get(j)!=0)
					OptimalBtext+="From "+OptimalBstart+" to "+OptimalBend+": ";
				else
					OptimalBtext+="From "+OptimalBstart+": ";
				if(UIController.OptimalBcost.get(j)!=0){
					for(int i=0;i<UIController.OptimalBCities.get(j).size();i++){
						OptimalBtext+=UIController.OptimalBCities.get(j).get(i);
						if(i!=UIController.OptimalBCities.get(j).size()-1)
							OptimalBtext+=" -> ";
					}
					OptimalBtext+="\n"+"The road cost is:"+UIController.OptimalBcost.get(j);
					OptimalBtext+="\n";
					if(UIController.OptimalBcost.get(j)<OptimalBmin){
						OptimalBmin=UIController.OptimalBcost.get(j);
						OptimalBindex=j;
					}
					
				}
				else
					OptimalBtext+="Can't Reach the city\n";
				}
			String OptimalBstart=UIController.OptimalBCities.get(OptimalBindex).get(0);
			String OptimalBend=UIController.OptimalBCities.get(OptimalBindex).get(UIController.OptimalBCities.get(OptimalBindex).size()-1);
			if(OptimalBmin!=0){
						OptimalBtext+="\n"+"The least road cost is: "+OptimalBmin+" ,from "+OptimalBstart+" to "+OptimalBend;
			}
			try{
			Text tx = new Text(OptimalBtext);
			BOPane.setContent(new TextFlow(tx));
			}
			catch (Exception e) {
				  
	            System.out.println(e.getMessage());
	        }
			}
	}
	
	@FXML
	private void GoBack(ActionEvent e) throws IOException {
		Stage stage =(Stage) btnBack.getScene().getWindow();
		Parent root= FXMLLoader.load(getClass().getResource("UI.fxml"));
		Scene scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	public void greedyMap (ActionEvent event) throws IOException { 
		if(Gmin!=0){
 		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("ResultMap.fxml"));
 		AnchorPane root= (AnchorPane)fxmlloader.load();
 	    Stage stage= new Stage();
 	    stage.setScene(new Scene(root));
 	    stage.show(); 	
		}
 	}
	@FXML
	public void BMap (ActionEvent event) throws IOException { 
		if(Bmin!=0){
 		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("BResultMap.fxml"));
 		AnchorPane root= (AnchorPane)fxmlloader.load();
 	    Stage stage= new Stage();
 	    stage.setScene(new Scene(root));
 	    stage.show(); 	
		}
 	}
	@FXML
	public void OGMap (ActionEvent event) throws IOException { 
		if(OptimalGmin!=0){
 		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("OGResultMap.fxml"));
 		AnchorPane root= (AnchorPane)fxmlloader.load();
 	    Stage stage= new Stage();
 	    stage.setScene(new Scene(root));
 	    stage.show(); 	}
 	}
	@FXML
	public void OBMap (ActionEvent event) throws IOException { 
		if(OptimalBmin!=0){
 		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("OBResultMap.fxml"));
 		AnchorPane root= (AnchorPane)fxmlloader.load();
 	    Stage stage= new Stage();
 	    stage.setScene(new Scene(root));
 	    stage.show(); 	
		}
 	}
	

}
