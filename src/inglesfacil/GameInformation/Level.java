package inglesfacil.GameInformation;

import javafx.scene.image.Image;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines the rank representation for the player`s level
 */
public class Level {
    /** Holds the image and name of rank for determined level */
    private Map<Integer, Pair<String, Image>> rank;
    /** Level and the amount of XP needed to upgrade*/
    private Map<Integer, Integer> levelUp;
    private int [] xpList = new int[] {5,10,25,20,25,30,40,60,80,110,150};
    /**
     * Cronstructor that sets up the rank`s information for each level
     */
    public Level () {
        rank = new HashMap<>();
        levelUp = new HashMap<>();

        rank.put(0,new Pair<String,Image>("ANT",new Image("/resources/insect/insetos1/ant.png")));
        rank.put(1,new Pair<String,Image>("BEE",new Image("/resources/insect/voadores/bee.png")));
        rank.put(2,new Pair<String,Image>("SPIDER",new Image("/resources/insect/insetos2/spider.png")));
        rank.put(3,new Pair<String,Image>("BEETLE",new Image("/resources/insect/insetos1/beetle.png")));
        rank.put(4,new Pair<String,Image>("FISH",new Image("/resources/animals/aquaticos/fish.png")));
        rank.put(5,new Pair<String,Image>("CAT",new Image("/resources/animals/mamiferos/cat.png")));
        rank.put(6,new Pair<String,Image>("DOG",new Image("/resources/animals/mamiferos/dog.png")));
        rank.put(7,new Pair<String,Image>("BEAR",new Image("/resources/animals/selvagens/bear.png")));
        rank.put(8,new Pair<String,Image>("LION",new Image("/resources/animals/selvagens/lion.png")));
        rank.put(9,new Pair<String,Image>("ELEPHANT",new Image("/resources/animals/selvagens/elephant.png")));
        rank.put(10,new Pair<String,Image>("WHALE",new Image("/resources/animals/aquaticos/whale.png")));

        for(int i = 0; i < xpList.length; ++i) {
            levelUp.put(i,xpList[i]);
        }
    }
    /**
     * Return the name and the image of the rank.
     * @param level Current level
     * @return Pair<String,Image> The name and image of the rank
     */
    public Pair<String,Image> getRank(int level) {
        return rank.get(level);
    }
    /**
     * Return the xp needed to be able to level up.
     * @param level Current level
     * @return Integer - xp needed to be able to level up
     */
    public int getXPNeeded(int level) {
        if(level < 0 || level > 10) {
            return 0;
        }
        return levelUp.get(level);
    }
    /**
     * Return the Player level.
     * @param xp Points that the player have
     * @return Integer - Player level
     */
    public int getLevel(int xp) {
        if (xp < xpList[0]) {
           return 0;
        } else if(xp > xpList[xpList.length - 1]) {
            return 11;
        } else {
            for(int i = 0; i < xpList.length - 1; ++i) {
                if (xpList[i] < xp && xp < xpList[i + 1]) {
                    return i + 1;
                }
            }
        }
        return -1;
    }
}
