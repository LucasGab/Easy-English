/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil.PracticePages;

import inglesfacil.PageAction;
import inglesfacil.GameInformation.SetupSubject;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Lucas Gabriel Silva
 * @author Tainá Andrello Piai
 */
public class PracticePathSubjectController  {

    @FXML
    private AnchorPane panel;
    @FXML
    private Button btObjects;
    @FXML
    private Button btColors;
    @FXML
    private Button btAnimals;
    @FXML
    private Button btInsects;
    @FXML
    private Button btBack;

    @FXML
    private void handleButtonPracticeAction(ActionEvent event) throws IOException {
        
        FXMLLoader loader = null;
        Scene scene = null;
        String sub = ((Button)event.getSource()).getText();
        SetupSubject.setCategory(sub);
        if(sub.equals("Animais")){
            loader = new FXMLLoader(getClass().getResource("/fxml/PracticePages/PracticePathAnimal.fxml"));
            scene = btAnimals.getScene();
        }else if(sub.equals("Cores")){
            loader = new FXMLLoader(getClass().getResource("/fxml/PracticePages/PracticePathColor.fxml"));
            scene = btColors.getScene();
        }else if(sub.equals("Objetos")){
            loader = new FXMLLoader(getClass().getResource("/fxml/PracticePages/PracticePathObject.fxml"));
            scene = btObjects.getScene();
        } else if (sub.equals("Insetos")) {
            loader = new FXMLLoader(getClass().getResource("/fxml/PracticePages/PracticePathInsect.fxml"));
            scene = btInsects.getScene();
        }

        //go to game level selected
        Parent root = loader.load();
        AnchorPane anchorPane = (AnchorPane) scene.getRoot();
        PageAction.transitionScene(root,scene,anchorPane);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Scene scene = btBack.getScene();
        PageAction.backScene(scene,panel);
    }
    
}
