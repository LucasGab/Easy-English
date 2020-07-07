/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil.PracticePages;

import inglesfacil.SetupSubject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Lucas Gabriel Silva
 */
public class PracticePathSubjectController implements Initializable {

    @FXML
    private AnchorPane panel;
    @FXML
    private Button btObjects;
    @FXML
    private Button btColors;
    @FXML
    private Button btAnimals;
    @FXML
    private Button btBack;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

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
        }
        
        Parent root = loader.load();
        StackPane stackpane = (StackPane) scene.getRoot();
        
        root.translateYProperty().set(scene.getHeight());
        stackpane.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 ->{
           //stackpane.getChildren().remove(panel);
        });
        timeline.play();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        Scene scene = btBack.getScene();
        
        StackPane stackpane = (StackPane) scene.getRoot();
        
        TranslateTransition trans = new TranslateTransition(Duration.seconds(1), panel);
        trans.setFromY(0);
        trans.setToY(-scene.getHeight());
        trans.play();
        
        trans.setOnFinished(event1 -> {
            stackpane.getChildren().remove(panel);
        });
        
    }
    
}
