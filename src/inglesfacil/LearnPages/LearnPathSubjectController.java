/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil.LearnPages;

import inglesfacil.PageAction;
import inglesfacil.GameInformation.SetupSubject;
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
public class LearnPathSubjectController implements Initializable {

    @FXML
    private Button btBack;
    @FXML
    private AnchorPane panel;
    @FXML
    private Button btAnimals;
    @FXML
    private Button btColors;
    @FXML
    private Button btObjects;
    @FXML
    private Button btInsects;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Scene scene = btBack.getScene();
        PageAction.backScene(scene,panel);
    }

    @FXML
    private void handleButtonLearnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = null;
        Scene scene = null;
        String sub = ((Button)event.getSource()).getText();
        SetupSubject.setCategory(sub);
        if (sub.equals("Animais")) {
            loader = new FXMLLoader(getClass().getResource("/fxml/LearnPages/LearnPathAnimal.fxml"));
            scene = btAnimals.getScene();
        } else if(sub.equals("Cores")) {
            loader = new FXMLLoader(getClass().getResource("/fxml/LearnPages/LearnPathColor.fxml"));
            scene = btColors.getScene();
        } else if (sub.equals("Objetos")) {
            loader = new FXMLLoader(getClass().getResource("/fxml/LearnPages/LearnPathObject.fxml"));
            scene = btObjects.getScene();
        } else if (sub.equals("Insetos")) {
            loader = new FXMLLoader(getClass().getResource("/fxml/LearnPages/LearnPathInsect.fxml"));
            scene = btInsects.getScene();
        }

        Parent root = loader.load();
        AnchorPane anchorPane = (AnchorPane) scene.getRoot();
        PageAction.transitionScene(root,scene,anchorPane);
    }

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