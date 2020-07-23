package inglesfacil.LearnPages;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * FXML Controller class.
 * Inherits LearnPathPageController class.
 * Stores the scene from the button clicked.
 * Controls the animal subject scene.
 *
 * @author Daniel Suzumura
 */
public class LearnPathAnimalController extends LearnPathPageController {

    @FXML
    Button btMamifero;
    @FXML
    Button btAquatico;
    @FXML
    Button btSelvagem;

    public LearnPathAnimalController(){
        super();
    }

    @Override
    public void setSceneCategory(String sub){
        if(sub.equals("Mamíferos")){
            scene = btMamifero.getScene();
        } else if(sub.equals("Aquáticos")){
            scene = btAquatico.getScene();
        } else if(sub.equals("Selvagens")){
            scene = btSelvagem.getScene();
        }
    }

}
