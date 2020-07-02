/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 *
 */
public class LearnPathObjectController extends LearnPathController {

    @FXML
    Button btEscola;
    @FXML
    Button btTecnologia;
    @FXML
    Button btMoveis;
    @FXML
    Button btCozinha;

    public LearnPathObjectController(){
        super();
    }

    public void setSceneCategory(String sub){
        if(sub.equals("Escola")){
            scene = btEscola.getScene();
        } else if(sub.equals("Tecnologia")){
            scene = btTecnologia.getScene();
        } else if(sub.equals("Móveis")){
            scene = btMoveis.getScene();
        } else if(sub.equals("Cozinha")){
            scene = btCozinha.getScene();
        }
    }

}

