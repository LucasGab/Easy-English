/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Lucas Gabriel Silva
 */
public class ProfileCellController implements Initializable {

    @FXML
    private Label lbName;
    @FXML
    private Label lbLevel;
    @FXML
    private ImageView imgProfile;

    public void cellSetup(Profile item){
        lbName.setText(item.getName());
        lbLevel.setText(Integer.toString(item.getLvl()));
        imgProfile.setImage(item.getImg());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
