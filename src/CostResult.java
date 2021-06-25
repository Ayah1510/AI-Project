
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

public class CostResult implements Initializable{
	
  
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
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println("JJJJ");

		// TODO Auto-generated method stub
		String Gtext="";
		String Btext="";
		String OptimalGtext="";
		String OptimalBtext="";
		double Gmin=0,Bmin=0,OptimalGmin=0,OptimalBmin=0;
		if(CostUI.Gcost.isEmpty()==false)
			 Gmin=CostUI.Gcost.get(0);
		if(CostUI.Bcost.isEmpty()==false)
			Bmin=CostUI.Bcost.get(0);
		if(CostUI.OptimalGcost.isEmpty()==false)
			OptimalGmin=CostUI.OptimalGcost.get(0);
		if(CostUI.OptimalBcost.isEmpty()==false)
			OptimalBmin=CostUI.OptimalBcost.get(0);
		Gindex=0;
		Bindex=0;
		OptimalGindex=0;
		if(CostUI.GCities.isEmpty()==false){
		for(int j=0;j<CostUI.GCities.size();++j){
			String start=CostUI.GCities.get(j).get(0);
			String end=CostUI.GCities.get(j).get(CostUI.GCities.get(j).size()-1);
			if(CostUI.Gcost.get(j)!=0)
				Gtext+="From "+start+" to "+end+": ";
			else
				Gtext+="From "+start+": ";
			if(CostUI.Gcost.get(j)!=0){
				for(int i=0;i<CostUI.GCities.get(j).size();i++){
					Gtext+=CostUI.GCities.get(j).get(i);
					if(i!=CostUI.GCities.get(j).size()-1)
						Gtext+=" -> ";
				}
				Gtext+="\n"+"The road cost is: "+CostUI.Gcost.get(j);
				Gtext+="\n";
				if(CostUI.Gcost.get(j)<Gmin){
					Gmin=CostUI.Gcost.get(j);
					Gindex=j;
				}
				
			}
			else
				Gtext+="Can't Reach the city\n";
			}
		
		String start=CostUI.GCities.get(Gindex).get(0);
		String end=CostUI.GCities.get(Gindex).get(CostUI.GCities.get(Gindex).size()-1);
		Gtext+="\n"+"The least road cost is: "+Gmin+" ,from "+start+" to "+end;
		System.out.println(Gtext);

		try{
		Text tx = new Text(Gtext);
		GPane.setContent(new TextFlow(tx));
		}
		catch (Exception e) {
			  
            System.out.println(e.getMessage());
        }
		}
		if(CostUI.BCities.isEmpty()==false){
		for(int j=0;j<CostUI.BCities.size();++j){
			String Bstart=CostUI.BCities.get(j).get(0);
			String Bend=CostUI.BCities.get(j).get(CostUI.BCities.get(j).size()-1);
			if(CostUI.Bcost.get(j)!=0)
				Btext+="From "+Bstart+" to "+Bend+": ";
			else
				Btext+="From "+Bstart+": ";
			if(CostUI.Bcost.get(j)!=0){
				for(int i=0;i<CostUI.BCities.get(j).size();i++){
					Btext+=CostUI.BCities.get(j).get(i);
					if(i!=CostUI.BCities.get(j).size()-1)
						Btext+=" -> ";
				}
				Btext+="\n"+"The road cost is: "+CostUI.Bcost.get(j);
				Btext+="\n";
				if(CostUI.Bcost.get(j)<Bmin){
					Bmin=CostUI.Bcost.get(j);
					Bindex=j;
				}
				
			}
			else
				Btext+="Can't Reach the city\n";
			}
		String Bstart=CostUI.BCities.get(Bindex).get(0);
		String Bend=CostUI.BCities.get(Bindex).get(CostUI.BCities.get(Bindex).size()-1);
		Btext+="\n"+"The least road cost is: "+Bmin+" ,from "+Bstart+" to "+Bend;
		try{
		Text tx = new Text(Btext);
		BPane.setContent(new TextFlow(tx));
		}
		catch (Exception e) {
			  
            System.out.println(e.getMessage());
        }
		}
		if(CostUI.OptimalGCities.isEmpty()==false){
		
		for(int j=0;j<CostUI.OptimalGCities.size();++j){
			String OptimalGstart=CostUI.OptimalGCities.get(j).get(0);
			String OptimalGend=CostUI.OptimalGCities.get(j).get(CostUI.OptimalGCities.get(j).size()-1);
			if(CostUI.OptimalGcost.get(j)!=0)
				OptimalGtext+="From "+OptimalGstart+" to "+OptimalGend+": ";
			else
				OptimalGtext+="From "+OptimalGstart+": ";
			if(CostUI.OptimalGcost.get(j)!=0){
				for(int i=0;i<CostUI.OptimalGCities.get(j).size();i++){
					OptimalGtext+=CostUI.OptimalGCities.get(j).get(i);
					if(i!=CostUI.OptimalGCities.get(j).size()-1)
						OptimalGtext+=" -> ";
				}
				OptimalGtext+="\n"+"The road cost is:"+CostUI.OptimalGcost.get(j);
				OptimalGtext+="\n";
				if(CostUI.OptimalGcost.get(j)<OptimalGmin){
					OptimalGmin=CostUI.OptimalGcost.get(j);
					OptimalGindex=j;
				}
				
			}
			else
				OptimalGtext+="Can't Reach the city\n";
			}
		String OptimalGstart=CostUI.OptimalGCities.get(OptimalGindex).get(0);
		String OptimalGend=CostUI.OptimalGCities.get(OptimalGindex).get(CostUI.OptimalGCities.get(OptimalGindex).size()-1);
		OptimalGtext+="\n"+"The least road cost is: "+OptimalGmin+" ,from "+OptimalGstart+" to "+OptimalGend;
		try{
		Text tx = new Text(OptimalGtext);
		GOPane.setContent(new TextFlow(tx));
		}
		catch (Exception e) {
			  
            System.out.println(e.getMessage());
        }
		}
		
		
		if(CostUI.OptimalBCities.isEmpty()==false){
			
			for(int j=0;j<CostUI.OptimalBCities.size();++j){
				String OptimalBstart=CostUI.OptimalBCities.get(j).get(0);
				String OptimalBend=CostUI.OptimalBCities.get(j).get(CostUI.OptimalBCities.get(j).size()-1);
				if(CostUI.OptimalBcost.get(j)!=0)
					OptimalBtext+="From "+OptimalBstart+" to "+OptimalBend+": ";
				else
					OptimalBtext+="From "+OptimalBstart+": ";
				if(CostUI.OptimalBcost.get(j)!=0){
					for(int i=0;i<CostUI.OptimalBCities.get(j).size();i++){
						OptimalBtext+=CostUI.OptimalBCities.get(j).get(i);
						if(i!=CostUI.OptimalBCities.get(j).size()-1)
							OptimalBtext+=" -> ";
					}
					OptimalBtext+="\n"+"The road cost is:"+CostUI.OptimalBcost.get(j);
					OptimalBtext+="\n";
					if(CostUI.OptimalBcost.get(j)<OptimalBmin){
						OptimalBmin=CostUI.OptimalBcost.get(j);
						OptimalBindex=j;
					}
					
				}
				else
					OptimalBtext+="Can't Reach the city\n";
				}
			String OptimalBstart=CostUI.OptimalBCities.get(OptimalBindex).get(0);
			String OptimalBend=CostUI.OptimalBCities.get(OptimalBindex).get(CostUI.OptimalBCities.get(OptimalBindex).size()-1);
			OptimalBtext+="\n"+"The least road cost is: "+OptimalBmin+" ,from "+OptimalBstart+" to "+OptimalBend;
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

	

}
