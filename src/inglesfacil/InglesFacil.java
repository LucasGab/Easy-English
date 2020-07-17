/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Lucas Gabriel Silva
 */
public class InglesFacil extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/InitialPage/LoginPage.fxml"));

        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    //TODO: Criar banco de dados para salvar resposta, perfil e níveis

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Represents a profile that contains information
     * about the player
     */
    public static class Profile {

        private String name;
        private int lvl;
        private int position;

        public Profile() {
        }

        public Profile(String name, int lvl) {
            this.name = name;
            this.lvl = lvl;
        }
        public Profile(int position,String name, int lvl) {
            this.name = name;
            this.lvl = lvl;
            this.position = position;
        }

        public void setLvl(int lvl) {
            this.lvl = lvl;
        }

        public int getLvl() {
            return lvl;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
