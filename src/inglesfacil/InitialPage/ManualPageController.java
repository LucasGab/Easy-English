package inglesfacil.InitialPage;

import inglesfacil.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * @author Lucas Gabriel Silva
 */
public class ManualPageController {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btBack;

    @FXML
    private void handleButtonBackAction(ActionEvent event) {
        Scene scene = btBack.getScene();
        PageAction.backScene(scene,anchorPane);
    }

}

