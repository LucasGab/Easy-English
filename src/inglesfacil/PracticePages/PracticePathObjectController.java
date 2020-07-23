package inglesfacil.PracticePages;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Lucas Gabriel Silva
 */
public class PracticePathObjectController extends PracticePathPageController {

    @FXML
    private AnchorPane panel;
    @FXML
    private Button btEscola;
    @FXML
    private Button btMoveis;
    @FXML
    private Button btCozinha;
    @FXML
    private Button btBack;
    @FXML
    private Button btTecnologia;

    public PracticePathObjectController(){
        super();
    }
    
    @Override
    public void setSceneCategory(String sub) {
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
