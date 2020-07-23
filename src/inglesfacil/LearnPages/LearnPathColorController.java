package inglesfacil.LearnPages;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class.
 * Inherits LearnPathPageController class.
 * Stores the scene from the button clicked.
 * Controls the color subject scene.
 *
 * @author Daniel Suzumura
 */
public class LearnPathColorController extends LearnPathPageController {

    @FXML
    Button btCores1;
    @FXML
    Button btCores2;
    @FXML
    Button btCores3;
    @FXML
    private AnchorPane panel;
    @FXML
    private Button btBack;

    public LearnPathColorController(){
        super();
    }

    @Override
    public void setSceneCategory(String sub){
        if(sub.equals("Cores 1")){
            scene = btCores1.getScene();
        } else if(sub.equals("Cores 2")){
            scene = btCores2.getScene();
        } else if(sub.equals("Cores 3")){
            scene = btCores3.getScene();
        }
    }
}
