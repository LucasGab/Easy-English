/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Lucas Gabriel Silva
 */
public class LearnPageController implements Initializable {

    private Subject subject = new Subject();
    int totalWords;
    int contWord;
    
    @FXML
    private ImageView ivImage;
    @FXML
    private Label lbNameTrad;
    @FXML
    private Label lbName;
    @FXML
    private Button btNext;
    @FXML
    private Button btBack;
    @FXML
    private AnchorPane panel;
    @FXML
    private Button btLast;
    
    public void setSubject(Subject subject){
        this.subject = subject;
        totalWords = subject.getDictionary().size();
        setView();
    }
    
    @FXML
    private void handleButtonBackAction(ActionEvent event) throws IOException {
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
    
    @FXML
    private void handleButtonLastAction(ActionEvent event) throws IOException {
        contWord-=1;
        if(contWord < 0)
            contWord=0;
        setView();
    }
    
    @FXML
    private void handleButtonNextAction(ActionEvent event) throws IOException {
        contWord+=1;
        if(contWord >= totalWords){
            Scene scene = btBack.getScene();

            StackPane stackpane = (StackPane) scene.getRoot();

            TranslateTransition trans = new TranslateTransition(Duration.seconds(1), panel);
            trans.setFromY(0);
            trans.setToY(-scene.getHeight());
            trans.play();

            trans.setOnFinished(event1 -> {
                stackpane.getChildren().remove(panel);
            });
        }else{
            setView();
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        totalWords = subject.getDictionary().size();
        contWord = 0;
    }    
    
    
    private void setView(){
        String name = (String)subject.getDictionary().keySet().toArray()[contWord];
        lbName.setText(name);
        lbNameTrad.setText(subject.getNameTraduction(name));
        ivImage.setImage(subject.getImage(name));
    }
        
}
