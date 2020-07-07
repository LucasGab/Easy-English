/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil.InitialPage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author Lucas Gabriel Silva
 */
public class InitialPageController implements Initializable {
    
    @FXML
    private BorderPane panel;
    @FXML
    private Button btCredits;
    @FXML
    private StackPane stackpane;
    @FXML
    private Button btOptions;
    @FXML
    private Button btProfile;
    @FXML
    private Button btLearn;
    @FXML
    private Button btPractice;
    
    @FXML
    private void handleButtonCreditsAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CreditPage/CreditsPage.fxml"));
        Scene scene = btCredits.getScene();
        
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
    private void handleButtonProfileAction(ActionEvent event) throws IOException {

        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ProfilePage/ProfilePage.fxml"));
        Scene scene = btProfile.getScene();
        
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
    private void handleButtonLearnAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LearnPages/LearnPathSubject.fxml"));
        Scene scene = btProfile.getScene();
        
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
    private void handleButtonPracticeAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/PracticePages/PracticePathSubject.fxml"));
        Scene scene = btPractice.getScene();
        
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    

 
}
