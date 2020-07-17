/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil.LearnPages;

import inglesfacil.PageAction;
import inglesfacil.GameInformation.Subject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
        PageAction.backScene(scene,panel);
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
            PageAction.backScene(scene,panel);
        }else{
            setView();
        }
    }
    
    /**
     * Initializes the controller class.
     * @param url
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
