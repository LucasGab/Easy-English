/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil.ProfilePage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
//import javafx.stage.PopupBuilder;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Lucas Gabriel Silva
 */
public class ProfileController implements Initializable {

    @FXML
    private ListView<Profile> lvProfiles;
    
    private ObservableList<Profile> profileObservableList;
    @FXML
    private Button btBack;
    @FXML
    private AnchorPane panel;
    @FXML
    private Label labelAdd;
    @FXML
    private TextField etName;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/InitialPage/InitialPage.fxml"));
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
    private void handleButtonAdd(ActionEvent event) throws IOException {
        Image image = new Image("/resources/img.jpg");
        String name = etName.getText();
        
    
        if(!name.isEmpty()){
            profileObservableList.add(new Profile(name,0,image));
        }
        
        
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        profileObservableList = FXCollections.observableArrayList();

        
        lvProfiles.setItems(profileObservableList);
        lvProfiles.setCellFactory(profileListView -> new ProfileListCell());
    }    
    
}
