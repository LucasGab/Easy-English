package inglesfacil.GameInformation;

/**
 * Holds the data to the player that is current playing
 *
 * @author Daniel Suzumura
 * @author Mateus Zanetti Camargo Penteado
 * @author Tainá Andrello Piai
 */
public class StorePlayer {
    /** Value defined to be the default increment of the level */
    private static final int LVL_INCREMENT = 5;

    /** Indicates if the user decided to play without an account */
    private static boolean guest = false;
    /** Holds the profile of the player */
    private static Profile player;

    private StorePlayer() {
    }

    /**
     * Set which player is current playing
     * @param profile The profile of the player that is current playing
     */
    public static void setPlayer(Profile profile) {
        player = profile;
    }

    /**
     * Get the Profile of the player
     * @return Profile - The player that is current playing
     */
    public static Profile getPlayer() {
        return player;
    }

    /**
     * Increases the level of the player by the default value
     */
    public static void incrementLVL() {
        int currentLvl = player.getLvl();
        player.setLvl(currentLvl + LVL_INCREMENT);
        return;
    }

    /**
     * Increases the level of the player
     * @param increment Amount to be added
     */
    public static void incrementLVL(int increment) {
        int currentLvl = player.getLvl();
        player.setLvl(currentLvl + increment);
        return;
    }

    /**
     * If the player choose to play as guest
     * @return Boolean - If player is guest or not
     */
    public static boolean getGuest() {
        return guest;
    }

    /**
     * Set the guest status
     * @param isGuest If the player is playing as guest or not
     */
    public static void setGuest(boolean isGuest) {
        guest = isGuest;
    }
}
