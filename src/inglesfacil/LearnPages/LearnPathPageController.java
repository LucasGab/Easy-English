/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil.LearnPages;

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
public abstract class LearnPathPageController implements Initializable {

    @FXML
    private Button btBack;
    @FXML
    private AnchorPane panel;

    protected Scene scene;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Scene scene = btBack.getScene();
        PageAction.backScene(scene,panel);
    }
    
    @FXML
    private void handleButtonLearnAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LearnPages/LearnPage.fxml"));
        Parent root = loader.load();
        LearnPageController controller = loader.getController();

        String sub = ((Button)event.getSource()).getText();
        Subject dictionary = SetupSubject.fillSubject(sub);
        controller.setSubject(dictionary);
        setSceneCategory(sub);

        AnchorPane anchorPane = (AnchorPane) scene.getRoot();
        
        PageAction.transitionScene(root,scene,anchorPane);
    }

    /**
     * scene receives bt______.getScene()
     * @param sub Indicates which subject will be created
     */
    public abstract void setSceneCategory(String sub);

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
