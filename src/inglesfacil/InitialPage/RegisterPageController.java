package inglesfacil.InitialPage;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 * Inserts new users in database
 *
 * @author Daniel Suzumura
 */
public class RegisterPageController  implements Initializable{
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btBack;
    @FXML
    private Button btRegister;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label duplicateUsername;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        duplicateUsername.setVisible(false);
        //connection to database
        try {
            connection = ConnectionDB.conector();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleButtonBackAction(ActionEvent event) throws IOException {
        Scene scene = btBack.getScene();
        PageAction.backScene(scene,anchorPane);
    }

    @FXML
    private void handleButtonRegisterAction(ActionEvent event) throws IOException {
        try {
            String query = " insert into tbPlayer (username, password, level)"
                            + " values (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usernameField.getText());
            preparedStatement.setString(2, passwordField.getText());
            preparedStatement.setInt(3, 0);
            int add = preparedStatement.executeUpdate();
            if(add > 0) {      //indicates that the profile was inserted

                //stores the profile
                Profile player = new Profile(usernameField.getText(),0);
                StorePlayer.setPlayer(player);

                //go to Menu scene
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/InitialPage/MenuPage.fxml"));
                Scene scene = btRegister.getScene();
                PageAction.transitionScene(root,scene,anchorPane);
            }
        }catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException duplicate) {
            // username already exists
            duplicateUsername.setVisible(true);     //set error message visible
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
