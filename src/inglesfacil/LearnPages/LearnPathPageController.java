/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil.LearnPages;

import inglesfacil.SetupSubject;
import inglesfacil.Subject;
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
public abstract class LearnPathPageController implements Initializable {

    @FXML
    private Button btBack;
    @FXML
    private AnchorPane panel;

    protected Scene scene;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Scene actualScene = btBack.getScene();
        
        StackPane stackpane = (StackPane) actualScene.getRoot();
        
        TranslateTransition trans = new TranslateTransition(Duration.seconds(1), panel);
        trans.setFromY(0);
        trans.setToY(-actualScene.getHeight());
        trans.play();
        
        trans.setOnFinished(event1 -> {
            stackpane.getChildren().remove(panel);
        });
    
    }
    
    @FXML
    private void handleButtonLearnAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LearnPages/LearnPage.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/LearnPage.fxml"));
        Parent root = (Parent) loader.load();
        LearnPageController controller = loader.<LearnPageController>getController();

        String sub = ((Button)event.getSource()).getText();
        Subject dictionary = SetupSubject.fillSubject(sub);
        controller.setSubject(dictionary);
        setSceneCategory(sub);

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

    /**
     * scene receives btXXXX.getScene()
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
