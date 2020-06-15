/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import sun.plugin.javascript.navig.Anchor;

/**
 *
 * @author Lucas Gabriel Silva
 */
public class ProfileListCell extends ListCell<Profile>{
   
    @Override
    protected void updateItem(Profile item, boolean empty) {
        super.updateItem(item, empty);

        if (!empty) {
             
            try{
                FXMLLoader mLLoader = new FXMLLoader(getClass().getResource("/fxml/ProfileCell.fxml"));
                HBox panel = (HBox) mLLoader.load();
                ProfileCellController controller = mLLoader.getController();
                controller.cellSetup(item);
                setGraphic(panel);
            }catch(IOException e){
                e.printStackTrace();
            }
            
        }else{
            setGraphic(null);
        }
    }
}
