/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;

/**
 *
 * @author Lucas Gabriel Silva
 */
public class Subject {
    
    private Map<String, Image>  images;
    private Map<String, String> dictionary;
    
    public Subject() {
        images = new HashMap<String, Image>();
        dictionary = new HashMap<String, String>();
    }

    public Subject(String name, String nameTraduction, Image img) {
        images = new HashMap<String, Image>();
        dictionary = new HashMap<String, String>();
        
        images.put(name, img);
        dictionary.put(name,nameTraduction);
        
    }
    
    public void setImage(String name,Image img){
        images.put(name, img);
    }

    public Image getImage(String name){
        return images.get(name);
    }
    
    public void setName(String name,String nameTraduction){
        dictionary.put(name, nameTraduction);
    }    
    
    public String getNameTraduction(String name){
        return dictionary.get(name);
    }
    
    public void setDictionary(Map<String,String> dictionary){
        this.dictionary.putAll(dictionary);
    }
    
    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void setImages(Map<String, Image> images) {
        this.images.putAll(images);
    }

    public Map<String, Image> getImages() {
        return images;
    }
    
    
    
}
