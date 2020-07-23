package inglesfacil.PracticePages;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Lucas Gabriel Silva
 */
public class PracticePathColorController extends PracticePathPageController {

    @FXML
    private AnchorPane panel;
    @FXML
    private Button btCores1;
    @FXML
    private Button btCores2;
    @FXML
    private Button btCores3;
    @FXML
    private Button btBack;

    public PracticePathColorController(){
        super();
    }

    @Override
    public void setSceneCategory(String sub) {
        if(sub.equals("Cores 1")){
            scene = btCores1.getScene();
        } else if(sub.equals("Cores 2")){
            scene = btCores2.getScene();
        } else if(sub.equals("Cores 3")){
            scene = btCores3.getScene();
        }
    }
    
}
