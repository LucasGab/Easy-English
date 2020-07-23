package inglesfacil.LearnPages;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * FXML Controller class.
 * Inherits LearnPathPageController class.
 * Stores the scene from the button clicked.
 * Controls the object subject scene.
 *
 * @author Daniel Suzumura
 */
public class LearnPathObjectController extends LearnPathPageController {

    @FXML
    Button btEscola;
    @FXML
    Button btTecnologia;
    @FXML
    Button btMoveis;
    @FXML
    Button btCozinha;

    public LearnPathObjectController(){
        super();
    }

    @Override
    public void setSceneCategory(String sub){
        if(sub.equals("Escola")){
            scene = btEscola.getScene();
        } else if(sub.equals("Tecnologia")){
            scene = btTecnologia.getScene();
        } else if(sub.equals("Móveis")){
            scene = btMoveis.getScene();
        } else if(sub.equals("Cozinha")){
            scene = btCozinha.getScene();
        }
    }

}

