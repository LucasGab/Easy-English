/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Lucas Gabriel Silva
 */
public class Profile {
    
    private String name;
    private int lvl;
    private Image img;

    public Profile() {
    }

    public Profile(String name, int lvl, Image img) {
        this.name = name;
        this.lvl = lvl;
        this.img = img;
    }
    
    public void setImg(Image img) {
        this.img = img;
    }

    public Image getImg() {
        return img;
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
    
}
