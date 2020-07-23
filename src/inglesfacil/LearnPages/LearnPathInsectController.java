package inglesfacil.LearnPages;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class.
 * Inherits LearnPathPageController class.
 * Stores the scene from the button clicked.
 * Controls the insect subject scene.
 *
 * @author Daniel Suzumura
 */
public class LearnPathInsectController extends LearnPathPageController {

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

    public LearnPathInsectController(){
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
