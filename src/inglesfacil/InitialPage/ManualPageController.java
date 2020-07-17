
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil.InitialPage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import inglesfacil.*;
import inglesfacil.GameInformation.Profile;
import inglesfacil.GameInformation.StorePlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * Control login request from database
 * @author
 */
public class ManualPageController {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label lbMessage;
    @FXML
    private Button btBack;

    @FXML
    private void handleButtonBackAction(ActionEvent event) throws IOException {
        Scene scene = btBack.getScene();
        PageAction.backScene(scene,anchorPane);
    }

}

