import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StreetMapCon implements Initializable{
	  @FXML
	    private ImageView map;
	  
	  @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			Image greedy = new Image("/pic/map.png");
			map.setImage(greedy);
		}
}
