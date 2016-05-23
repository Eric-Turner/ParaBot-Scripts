package org.parabot.crandor.fishing.resources;

import org.rev317.min.api.wrappers.TilePath;

/**
 * @author EricTurner
 */
public class Variables {

    private static Fish fish;
    private static boolean banking;
    private static boolean dropping;
    private static boolean autoProgression;
    private static TilePath toSpot;

    public static Fish getFish() {
        return fish;
    }

    public static void setFish(Fish fish) {
        Variables.fish = fish;
    }

    public static boolean isBanking() {
        return banking;
    }

    public static void setBanking(boolean banking) {
        Variables.banking = banking;
    }

    public static boolean isDropping() {
        return dropping;
    }

    public static void setDropping(boolean dropping) {
        Variables.dropping = dropping;
    }

    public static boolean isAutoProgression() {
        return autoProgression;
    }

    public static void setAutoProgression(boolean autoProgression) {
        Variables.autoProgression = autoProgression;
    }

    public static TilePath getToSpot() {
        return toSpot;
    }

    public static void setToSpot(TilePath toSpot) {
        Variables.toSpot = toSpot;
    }
}
