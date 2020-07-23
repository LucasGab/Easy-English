package inglesfacil.InitialPage;

import inglesfacil.PageAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Lucas Gabriel Silva
 */
public class CreditsController {

    @FXML
    private Button btBack;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Scene scene = btBack.getScene();
        PageAction.backScene(scene,anchorPane);
    }
    
}
