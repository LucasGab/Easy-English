/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil.LearnPages;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 *
 */
public class LearnPathAnimalController extends LearnPathPageController {

    @FXML
    Button btMamifero;
    @FXML
    Button btAquatico;
    @FXML
    Button btSelvagem;

    public LearnPathAnimalController(){
        super();
    }

    @Override
    public void setSceneCategory(String sub){
        if(sub.equals("Mamíferos")){
            scene = btMamifero.getScene();
        } else if(sub.equals("Aquáticos")){
            scene = btAquatico.getScene();
        } else if(sub.equals("Selvagens")){
            scene = btSelvagem.getScene();
        }
    }

}
