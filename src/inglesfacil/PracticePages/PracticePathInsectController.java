package inglesfacil.PracticePages;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Daniel Suzumura
 */
public class PracticePathInsectController extends PracticePathPageController {

    @FXML
    Button btInsetos1;
    @FXML
    Button btInsetos2;
    @FXML
    Button btVoadores;
    @FXML
    private AnchorPane panel;
    @FXML
    private Button btBack;

    public PracticePathInsectController(){
        super();
    }

    @Override
    public void setSceneCategory(String sub){
        if(sub.equals("Insetos 1")){
            scene = btInsetos1.getScene();
        } else if(sub.equals("Insetos 2")){
            scene = btInsetos2.getScene();
        } else if(sub.equals("Voadores")){
            scene = btVoadores.getScene();
        }
    }
    
}
