/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil.PracticePages;

import inglesfacil.*;
import inglesfacil.GameInformation.StorePlayer;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import inglesfacil.GameInformation.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Lucas Gabriel Silva
 */
public class PracticePageController implements Initializable {

    private final char[] consoantes = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
    private final char[] vogais = {'a','e','i','o','u'};
    
    private Subject subject = new Subject();
    int totalWords;
    int contWord;
    int rightOption;
    int totalPoints;

    private Connection connection;
    private PreparedStatement preparedStatement;
    
    @FXML
    private ImageView ivImage;
    @FXML
    private Button btOption1;
    @FXML
    private Button btOption2;
    @FXML
    private Button btOption3;
    @FXML
    private Button btOption4;
    @FXML
    private AnchorPane panel;
    @FXML
    private Button btBack;
    @FXML
    private Label lbRigth;
    @FXML
    private Label lbTotal;
    @FXML
    private Label slashBar;
    @FXML
    private Label finalScore;
    @FXML
    private Label xpEarned;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connection = ConnectionDB.conector();
        totalWords = subject.getDictionary().size();
        contWord = 0;
        totalPoints = 0;
        finalScore.setVisible(false);
        xpEarned.setVisible(false);
    }

    public void setSubject(Subject subject){
        this.subject = subject;
        totalWords = subject.getDictionary().size();
        setView();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Scene scene = btBack.getScene();
        PageAction.backScene(scene,panel);
    }

    @FXML
    private void handleButtonOptionAction(ActionEvent event) throws IOException {
        String sub = ((Button)event.getSource()).getText();
        String name = (String)subject.getDictionary().keySet().toArray()[contWord];
        if(sub.equals(name)){
            totalPoints++;
        }
        contWord++;
        if(contWord < totalWords){
            setView();
        }else{
            if(!StorePlayer.getGuest()) {       //player logged in
                //give the player xp for completing the lesson
                StorePlayer.incrementLVL (totalPoints);
                //update lvl in database
                updateProfileDataBase();
            }
            //show performance on lesson
            displayScore();
        }
    }

    private void updateProfileDataBase(){
        try {
            String query = "update tbPlayer set level = ? where username = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, StorePlayer.getPlayer().getLvl());
            preparedStatement.setString(2, StorePlayer.getPlayer().getName());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void displayScore() {
        String finalScoreString = "";

        //makes everything invisible in scene
        btOption1.setVisible(false);
        btOption2.setVisible(false);
        btOption3.setVisible(false);
        btOption4.setVisible(false);
        ivImage.setVisible(false);
        lbRigth.setVisible(false);
        lbTotal.setVisible(false);
        slashBar.setVisible(false);

        //display score
        finalScoreString = "PONTUAÇÃO: " + totalPoints + " / " + totalWords;
        xpEarned.setText("XP ganho: " + totalPoints);
        xpEarned.setVisible(true);
        finalScore.setText(finalScoreString);
        finalScore.setVisible(true);
    }
    private void setView(){
        String name = (String)subject.getDictionary().keySet().toArray()[contWord];
        
        Random rand = new Random();
        int[] op = {1,1,1,1};
        int total = 0;
        
        while(total < 4){
            int pos = rand.getIntRand(4);
            if(total == 0){
                populateOption(pos-1, name);
                rightOption = pos-1;
                op[pos-1] = 0;
                total++;
            }else{
                if(op[pos-1]==1){
                    int index = rand.getIntRand(name.length());
                    String name1;
                    index--;
                    if(find(vogais, Character.toLowerCase(name.charAt(index)))){
                        char substitute = vogais[rand.getIntRand(vogais.length)-1];
                        while(substitute == Character.toLowerCase(name.charAt(index))){
                            substitute = vogais[rand.getIntRand(vogais.length)-1];
                        }
                        if(index == 0){
                            name1 = Character.toUpperCase(substitute) + name.substring(index+1);
                        }else if(index == name.length()-1){
                            name1 = name.substring(0,index) + substitute;
                        }else{
                            name1 = name.substring(0,index) + substitute + name.substring(index+1);
                        }
                      
                    }else{
                        char substitute = consoantes[rand.getIntRand(consoantes.length)-1];
                        while(substitute == Character.toLowerCase(name.charAt(index))){
                            substitute = consoantes[rand.getIntRand(consoantes.length)-1];
                        }
                        if(index == 0){
                            name1 = Character.toUpperCase(substitute) + name.substring(index+1);
                        }else if(index == name.length()-1){
                            name1 = name.substring(0,index) + substitute;
                        }else{
                            name1 = name.substring(0,index) + substitute + name.substring(index+1);
                        }
                        
                    }
                    
                    populateOption(pos-1, name1);
                    op[pos-1] = 0;
                    total++;
                }
            }
        }
        
        ivImage.setImage(subject.getImage(name));
        lbRigth.setText(Integer.toString(totalPoints));
        lbTotal.setText(Integer.toString(contWord));
    }
    
    private void populateOption(int op,String name){
        if(op==0)
            btOption1.setText(name);
        if(op==1)
            btOption2.setText(name);
        if(op==2)
            btOption3.setText(name);
        if(op==3)
            btOption4.setText(name);
    }
    
    private boolean find(char arr[],char value){
        for(int i = 0;i < arr.length;i++){
            if(arr[i]==value)
                return true;
        }
        return false;
    }
}
