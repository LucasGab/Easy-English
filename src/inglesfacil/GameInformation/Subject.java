package inglesfacil.GameInformation;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;

/**
 * Structure to create a dictionary(using a Map)
 * to have a portuguese word and its translation
 * in english. Also for every word added to the
 * dictionary, an image of the representation of
 * this word will be linked to the word using a Map
 *
 * @author Lucas Gabriel Silva
 * @author Tainá Andrello Piai
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
