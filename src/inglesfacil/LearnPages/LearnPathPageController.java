package inglesfacil.LearnPages;

import inglesfacil.PageAction;
import inglesfacil.GameInformation.SetupSubject;
import inglesfacil.GameInformation.Subject;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * Abstract class to be used to create
 * controllers scenes that represents
 * different game stages
 *
 * @author Daniel Suzumura
 * @author Lucas Gabriel Silva
 *
 */
public abstract class LearnPathPageController {

    @FXML
    private Button btBack;
    @FXML
    private AnchorPane panel;

    protected Scene scene;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Scene scene = btBack.getScene();
        PageAction.backScene(scene,panel);
    }
    
    @FXML
    private void handleButtonLearnAction(ActionEvent event) throws IOException {
        //go to learn page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LearnPages/LearnPage.fxml"));
        Parent root = loader.load();
        LearnPageController controller = loader.getController();

        //load the subject selected
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

}
