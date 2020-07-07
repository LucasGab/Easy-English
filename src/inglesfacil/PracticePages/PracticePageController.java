/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil.PracticePages;

import inglesfacil.Random;
import inglesfacil.Subject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

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

    public void setSubject(Subject subject){
        this.subject = subject;
        totalWords = subject.getDictionary().size();
        setView();
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        totalWords = subject.getDictionary().size();
        contWord = 0;
        totalPoints = 0;
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Scene scene = btBack.getScene();

        StackPane stackpane = (StackPane) scene.getRoot();

        TranslateTransition trans = new TranslateTransition(Duration.seconds(1), panel);
        trans.setFromY(0);
        trans.setToY(-scene.getHeight());
        trans.play();

        trans.setOnFinished(event1 -> {
            stackpane.getChildren().remove(panel);
        });
    }

    @FXML
    private void handleButtonOptionAction(ActionEvent event) {
        
        if(contWord < totalWords-1){
            String sub = ((Button)event.getSource()).getText();
            String name = (String)subject.getDictionary().keySet().toArray()[contWord];
            if(sub.equals(name)){
                totalPoints++;
            }
            contWord++;
            setView();
        }else{
            Scene scene = btBack.getScene();

            StackPane stackpane = (StackPane) scene.getRoot();

            TranslateTransition trans = new TranslateTransition(Duration.seconds(1), panel);
            trans.setFromY(0);
            trans.setToY(-scene.getHeight());
            trans.play();

            trans.setOnFinished(event1 -> {
                stackpane.getChildren().remove(panel);
            });
        }
        
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
