package inglesfacil.PracticePages;

import inglesfacil.PageAction;
import inglesfacil.GameInformation.SetupSubject;
import inglesfacil.GameInformation.Subject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Lucas Gabriel Silva
 */
public abstract class PracticePathPageController {

    @FXML
    private Button btColors;
    @FXML
    private Button btAnimals;
    @FXML
    private Button btBack;
    @FXML
    private AnchorPane panel;
    @FXML
    private Button btObjects;
    @FXML
    private Button btInsects;
    
    protected Scene scene;

    @FXML
    private void handleButtonPracticeAction(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PracticePages/PracticePage.fxml"));
        Parent root = loader.load();
        PracticePageController controller = loader.<PracticePageController>getController();
        
        String sub = ((Button)event.getSource()).getText();
        Subject dictionary = SetupSubject.fillSubject(sub);
        controller.setSubject(dictionary);
        setSceneCategory(sub);
        
        AnchorPane anchorPane = (AnchorPane) scene.getRoot();

        PageAction.transitionScene(root,scene,anchorPane);
    }

    /**
     * scene receives scene of the button clicked
     * @param sub Indicates which subject will be created
     */
    public abstract void setSceneCategory(String sub);

    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        Scene scene = btBack.getScene();

        PageAction.backScene(scene,panel);
        
    }
}
