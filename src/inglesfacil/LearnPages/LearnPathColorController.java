/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil.LearnPages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 *
 */
public class LearnPathColorController extends LearnPathPageController {

    @FXML
    Button btCores1;
    @FXML
    Button btCores2;
    @FXML
    Button btCores3;
    @FXML
    private AnchorPane panel;
    @FXML
    private Button btBack;

    public LearnPathColorController(){
        super();
    }

    @Override
    public void setSceneCategory(String sub){
        if(sub.equals("Cores 1")){
            scene = btCores1.getScene();
        } else if(sub.equals("Cores 2")){
            scene = btCores2.getScene();
        } else if(sub.equals("Cores 3")){
            scene = btCores3.getScene();
        }
    }

}
