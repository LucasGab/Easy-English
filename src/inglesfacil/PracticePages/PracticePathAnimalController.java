/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil.PracticePages;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Lucas Gabriel Silva
 */
public class PracticePathAnimalController extends PracticePathPageController {

    @FXML
    private AnchorPane panel;
    @FXML
    private Button btBack;
    @FXML
    private Button btSelvagem;
    @FXML
    private Button btAquatico;
    @FXML
    private Button btMamifero;
    
    public PracticePathAnimalController(){
        super();
    }

    @Override
    public void setSceneCategory(String sub) {
        if(sub.equals("Mamíferos")){
            scene = btMamifero.getScene();
        } else if(sub.equals("Aquáticos")){
            scene = btAquatico.getScene();
        } else if(sub.equals("Selvagens")){
            scene = btSelvagem.getScene();
        }
    }
    
}
