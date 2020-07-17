package inglesfacil.InitialPage;

import inglesfacil.*;
import inglesfacil.GameInformation.Level;
import inglesfacil.GameInformation.Profile;
import inglesfacil.GameInformation.StorePlayer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuPageController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button btLearn;
    @FXML
    private Button btPractice;
    @FXML
    private ImageView imageView;
    @FXML
    private Label rankName;
    @FXML
    private Button btExit;
    @FXML
    private Button btCredit;
    @FXML
    private Label levelProgress;
    @FXML
    private Button btPlacar;
    @FXML
    private Button btRefresh;

    private Profile player;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayRank();
    }

    private void displayRank() {
        player = StorePlayer.getPlayer();
        String levelProgressString = "";
        Level l = new Level();
        int level = l.getLevel(player.getLvl());
        double progress;
        if(level > 10) {       //max level is 10
            level = 10;
            rankName.setStyle("-fx-background-color: GOLD");
            progressBar.setProgress(1);
            progressBar.setStyle("-fx-box-border: GOLD");
            progressBar.setStyle("-fx-accent: GOLD");
            levelProgressString = "" + l.getXPNeeded(10) + " / " + l.getXPNeeded(10);
        } else {
            progress = ((double) (player.getLvl() - l.getXPNeeded(level-1)))/l.getXPNeeded(level);
            //display level progress in progressBar
            progressBar.setProgress(progress);
            //display numeric value of the level progress
            levelProgressString = "" + (player.getLvl() - l.getXPNeeded(level-1)) + " / " + l.getXPNeeded(level);
        }
        levelProgress.setText(levelProgressString);

        //display rank
        Pair<String, Image> rank = l.getRank(level);
        rankName.setText(rank.getKey());
        imageView.setImage(rank.getValue());
    }

    @FXML
    private void handleButtonLearnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LearnPages/LearnPathSubject.fxml"));
        Scene scene = btLearn.getScene();
        PageAction.transitionScene(root,scene,anchorPane);
    }

    @FXML
    private void handleButtonPracticeAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/PracticePages/PracticePathSubject.fxml"));
        Scene scene = btPractice.getScene();
        PageAction.transitionScene(root,scene,anchorPane);
    }
    @FXML
    private void handleButtonCreditsAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CreditPage/CreditsPage.fxml"));
        Scene scene = btCredit.getScene();
        PageAction.transitionScene(root,scene,anchorPane);
    }

    @FXML
    private void handleButtonPlacarAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/InitialPage/LeaderBoardPage.fxml"));
        Scene scene = btPlacar.getScene();
        PageAction.transitionScene(root,scene,anchorPane);
    }

    @FXML
    private void handleButtonManualAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/InitialPage/ManualPage.fxml"));
        Scene scene = btPlacar.getScene();
        PageAction.transitionScene(root,scene,anchorPane);
    }

    @FXML
    private void handleButtonExitAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void handleButtonRefreshAction(ActionEvent event) {
        displayRank();
    }
}
