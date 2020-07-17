package inglesfacil.GameInformation;

/**
 * Represents a profile that contains information
 * about the player
 */
public class Profile {

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