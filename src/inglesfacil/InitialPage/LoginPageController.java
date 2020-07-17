
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
public class LoginPageController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btLogin;
    @FXML
    private Button btRegister;
    @FXML
    private Button btGuest;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Label loginError;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set login error message invisible
        loginError.setVisible(false);

        //connection to database
        try {
            connection = ConnectionDB.conector();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleButtonLoginAction(ActionEvent event) throws IOException {
        try {
            String sql = "select * from tbPlayer where username = ? and password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usernameField.getText());
            preparedStatement.setString(2, passwordField.getText());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){       //login successfully
                //read the information about the profile
                getProfileData(usernameField.getText());
                //load Menu scene
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/InitialPage/MenuPage.fxml"));
                Scene scene = btLogin.getScene();
                PageAction.transitionScene(root,scene,anchorPane);
                connection.close();
            } else {
                loginError.setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Read information about a profile in database
     * and stores it in a Profile holder
     * @param username Profile name
     */
    private void getProfileData(String username) {
        try {
            Profile player = new Profile();
            String querry = "select * from tbPlayer where username=?";

            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();

            //set values in object
            player.setName(username);
            resultSet.next();
            player.setLvl(resultSet.getInt("level"));

            //stores the values
            StorePlayer.setPlayer(player);
            //System.out.println(StorePlayer.getPlayer().getName());
            //System.out.println(StorePlayer.getPlayer().getLvl());
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a guest profile (play without login)
     */
    private void getProfileData() {
        try {
            Profile player = new Profile();
            player.setLvl(0);

            //stores the values
            player.setName("Convidado");
            StorePlayer.setPlayer(player);
            StorePlayer.setGuest(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleButtonRegisterAction(ActionEvent event) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/InitialPage/RegisterUserPage.fxml"));
        Scene scene = btRegister.getScene();

        PageAction.transitionScene(root,scene,anchorPane);
    }

    @FXML
    private void handleButtonGuestAction(ActionEvent event) throws IOException  {
        //setup profile for guest player
        getProfileData();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/InitialPage/MenuPage.fxml"));
        Scene scene = btGuest.getScene();

        PageAction.transitionScene(root,scene,anchorPane);
    }
}

