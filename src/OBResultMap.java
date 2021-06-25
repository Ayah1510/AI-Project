import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.javafx.collections.MappingChange.Map;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Line;

public class OBResultMap implements Initializable{
	
    @FXML
    private Line YafoGaza;

    @FXML
    private Line JerichoTib;

    @FXML
    private Line YafoHaifa;

    @FXML
    private Line HebBeth;

    @FXML
    private Line GazaBir;

    @FXML
    private Line GazaHebron;

    @FXML
    private Line BirHebron;

    @FXML
    private Line BethJer;

    @FXML
    private Line JerichoRam;

    @FXML
    private Line JerichoJer;

    @FXML
    private Line YafoJer;

    @FXML
    private Line JerRam;

    @FXML
    private Line NablusSalf;

    @FXML
    private Line RamNablus;

    @FXML
    private Line RamSalf;

    @FXML
    private Line JerichoNab;

    @FXML
    private Line YafoQalq;

    @FXML
    private Line YafoTulk;

    @FXML
    private Line QalqTulk;

    @FXML
    private Line SalfQalq;

    @FXML
    private Line NablusTubas;

    @FXML
    private Line YafoSalf;

    @FXML
    private Line NablusTulk;

    @FXML
    private Line JeninTulk;

    @FXML
    private Line NazTib;

    @FXML
    private Line KarmNah;

    @FXML
    private Line AkkoNah;

    @FXML
    private Line AkkoHiafa;

    @FXML
    private Line KarmTib;

    @FXML
    private Line AkkoKarm;

    @FXML
    private Line NazAkko;

    @FXML
    private Line JeninNaz;

    @FXML
    private Line JeninTib;

    @FXML
    private Line NablusJenin;

    @FXML
    private Line NablusQalq;

    @FXML
    private Line NazKerm;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		SetMap();
	
		
	
	}
	public void SetMap(){
		List<String> vc=new ArrayList<String>();
		for(int i=0;i<UIController.OptimalBCities.get(Result.OptimalBindex).size();++i)
			vc.add(UIController.OptimalBCities.get(Result.OptimalBindex).get(i));
		for(int i=0;i<vc.size();++i){
		if(i+1!=vc.size()){
		if(vc.get(i).equals("Akko")&&vc.get(i+1).equals("Nahariya") ||vc.get(i).equals("Nahariya")&&vc.get(i+1).equals("Akko") )
			AkkoNah.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Akko")&&vc.get(i+1).equals("Karmiel") ||vc.get(i).equals("Karmiel")&&vc.get(i+1).equals("Akko") )
			AkkoKarm.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Karmiel")&&vc.get(i+1).equals("Nahariya") ||vc.get(i).equals("Nahariya")&&vc.get(i+1).equals("Karmiel") )
			KarmNah.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Yafo")&&vc.get(i+1).equals("Haifa") ||vc.get(i).equals("Haifa")&&vc.get(i+1).equals("Yafo") )
			YafoHaifa.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Gaza")&&vc.get(i+1).equals("Yafo") ||vc.get(i).equals("Yafo")&&vc.get(i+1).equals("Gaza") )
			YafoGaza.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Bir-sabae")&&vc.get(i+1).equals("Gaza") ||vc.get(i).equals("Gaza")&&vc.get(i+1).equals("Bir-sabae") )
			GazaBir.setStroke(javafx.scene.paint.Color.RED);	
		else if(vc.get(i).equals("Akko")&&vc.get(i+1).equals("Haifa") ||vc.get(i).equals("Haifa")&&vc.get(i+1).equals("Akko") )
			AkkoHiafa.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Hebron")&&vc.get(i+1).equals("Gaza") ||vc.get(i).equals("Gaza")&&vc.get(i+1).equals("Hebron") )
			GazaHebron.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Hebron")&&vc.get(i+1).equals("Bir-sabae") ||vc.get(i).equals("Bir-sabae")&&vc.get(i+1).equals("Hebron") )
			BirHebron.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Bethlehem")&&vc.get(i+1).equals("Hebron") ||vc.get(i).equals("Hebron")&&vc.get(i+1).equals("Bethlehem") )
			HebBeth.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Bethlehem")&&vc.get(i+1).equals("Jerusalem") ||vc.get(i).equals("Jerusalem")&&vc.get(i+1).equals("Bethlehem") )
			BethJer.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Jerusalem")&&vc.get(i+1).equals("Jericho") ||vc.get(i).equals("Jericho")&&vc.get(i+1).equals("Jerusalem") )
			JerichoJer.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Jerusalem")&&vc.get(i+1).equals("Yafo") ||vc.get(i).equals("Yafo")&&vc.get(i+1).equals("Jerusalem") )
			YafoJer.setStroke(javafx.scene.paint.Color.RED);	
		else if(vc.get(i).equals("Jerusalem")&&vc.get(i+1).equals("Ramallah") ||vc.get(i).equals("Ramallah")&&vc.get(i+1).equals("Jerusalem") )
			JerRam.setStroke(javafx.scene.paint.Color.RED);	
		else if(vc.get(i).equals("Ramallah")&&vc.get(i+1).equals("Jericho") ||vc.get(i).equals("Jericho")&&vc.get(i+1).equals("Ramallah") )
			JerichoRam.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Ramallah")&&vc.get(i+1).equals("Nablus") ||vc.get(i).equals("Nablus")&&vc.get(i+1).equals("Ramallah") )
			RamNablus.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Ramallah")&&vc.get(i+1).equals("Salfit") ||vc.get(i).equals("Salfit")&&vc.get(i+1).equals("Ramallah") )
			RamSalf.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Jericho")&&vc.get(i+1).equals("Nablus") ||vc.get(i).equals("Nablus")&&vc.get(i+1).equals("Jericho") )
			JerichoNab.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Jericho")&&vc.get(i+1).equals("Tiberias") ||vc.get(i).equals("Tiberias")&&vc.get(i+1).equals("Jericho") )
			JerichoTib.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Nablus")&&vc.get(i+1).equals("Tulkarm") ||vc.get(i).equals("Tulkarm")&&vc.get(i+1).equals("Nablus") )
			NablusTulk.setStroke(javafx.scene.paint.Color.RED);	
		else if(vc.get(i).equals("Nablus")&&vc.get(i+1).equals("Tubas") ||vc.get(i).equals("Tubas")&&vc.get(i+1).equals("Nablus") )
			NablusTubas.setStroke(javafx.scene.paint.Color.RED);	
		else if(vc.get(i).equals("Nablus")&&vc.get(i+1).equals("Jenin") ||vc.get(i).equals("Jenin")&&vc.get(i+1).equals("Nablus") )
			NablusJenin.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Nablus")&&vc.get(i+1).equals("Qalqilia") ||vc.get(i).equals("Qalqilia")&&vc.get(i+1).equals("Nablus") )
			NablusQalq.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Nablus")&&vc.get(i+1).equals("Salfit") ||vc.get(i).equals("Salfit")&&vc.get(i+1).equals("Nablus") )
			NablusSalf.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Yafo")&&vc.get(i+1).equals("Salfit") ||vc.get(i).equals("Salfit")&&vc.get(i+1).equals("Yafo") )
			YafoSalf.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Qalqilia")&&vc.get(i+1).equals("Salfit") ||vc.get(i).equals("Salfit")&&vc.get(i+1).equals("Qalqilia") )
			SalfQalq.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Qalqilia")&&vc.get(i+1).equals("Yafo") ||vc.get(i).equals("Yafo")&&vc.get(i+1).equals("Qalqilia") )
			YafoQalq.setStroke(javafx.scene.paint.Color.RED);	
		else if(vc.get(i).equals("Qalqilia")&&vc.get(i+1).equals("Tulkarm") ||vc.get(i).equals("Tulkarm")&&vc.get(i+1).equals("Qalqilia") )
			QalqTulk.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Tulkarm")&&vc.get(i+1).equals("Yafo") ||vc.get(i).equals("Yafo")&&vc.get(i+1).equals("Tulkarm") )
			YafoTulk.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Tulkarm")&&vc.get(i+1).equals("Jenin") ||vc.get(i).equals("Jenin")&&vc.get(i+1).equals("Tulkarm") )
			JeninTulk.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Jenin")&&vc.get(i+1).equals("Tiberias") ||vc.get(i).equals("Tiberias")&&vc.get(i+1).equals("Jenin") )
			JeninTib.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Jenin")&&vc.get(i+1).equals("Nazareth") ||vc.get(i).equals("Nazareth")&&vc.get(i+1).equals("Jenin") )
			JeninNaz.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Nazareth")&&vc.get(i+1).equals("Tiberias") ||vc.get(i).equals("Tiberias")&&vc.get(i+1).equals("Nazareth") )
			NazTib.setStroke(javafx.scene.paint.Color.RED);	
		else if(vc.get(i).equals("Nazareth")&&vc.get(i+1).equals("Karmiel") ||vc.get(i).equals("Karmiel")&&vc.get(i+1).equals("Nazareth") )
			NazKerm.setStroke(javafx.scene.paint.Color.RED);				
		else if(vc.get(i).equals("Nazareth")&&vc.get(i+1).equals("Akko") ||vc.get(i).equals("Akko")&&vc.get(i+1).equals("Nazareth") )
			NazAkko.setStroke(javafx.scene.paint.Color.RED);
		else if(vc.get(i).equals("Karmiel")&&vc.get(i+1).equals("Tiberias") ||vc.get(i).equals("Tiberias")&&vc.get(i+1).equals("Karmiel") )
			KarmTib.setStroke(javafx.scene.paint.Color.RED);
		
		}
		}

	}

}

