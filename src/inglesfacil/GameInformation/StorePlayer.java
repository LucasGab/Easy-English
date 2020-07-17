package inglesfacil.GameInformation;

/**
 * Holds the data to the player that is current playing
 */
public class StorePlayer {
    private static boolean guest = false;
    private static Profile player;
    private static final int LVL_INCREMENT = 5;

    private StorePlayer() {
    }

    public static void setPlayer(Profile profile) {
        player = profile;
    }

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

    public static boolean getGuest() {
        return guest;
    }

    public static void setGuest(boolean isGuest) {
        guest = isGuest;
    }
}
