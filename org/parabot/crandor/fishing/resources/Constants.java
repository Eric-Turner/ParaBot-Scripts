package org.parabot.crandor.fishing.resources;

import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.wrappers.Tile;
import org.rev317.min.api.wrappers.TilePath;

/**
 * Created by Eric on 5/2/2016.
 */
public class Constants {


    private final static int BANK_BOOTH_ID = 2213;
    private final static int BANK_INTERFACE_ID = 5292;
    private final static int WITHDRAW_ONE = 632;
    private final static int WITHDRAW_FIVE = 78;
    private final static int WITHDRAW_TEN = 867;
    private final static int WITHDRAW_X = 431;
    private final static int WITHDRAW_ALL = 53;
    private final static int WITHDRAW_ALL_BUT_ONE = 432;
    private static int fishingAnim;
    private static int fishingSpotId;
    private static int fishingToolId;
    private static boolean netFishing = false;
    private static boolean harpoonFishing = false;
    private static boolean cageFishing = false;
    private static boolean rocktailFishing = false;
    private static boolean banking = false;
    private static boolean dropping = false;
    private static boolean running = false;
    private static boolean autoProgression = false;
    private static Npcs.Option interactOption;
    private static Tile[] WALKING_PATH_TO_BANK = {
            new Tile(2601, 3406, 0),
            new Tile(2593, 3415, 0),
            new Tile(2586, 3421, 0)
    };
    private static Tile[] WALKING_PATH_TO_DOCK_1 = { //Net fishing dock
            new Tile(2586, 3421, 0),
            new Tile(2593, 3415, 0),
            new Tile(2601, 3406, 0),
            new Tile(2604, 3414, 0)
    };
    private static Tile[] WALKING_PATH_TO_DOCK_2 = { // Rocktail, cage, harpoon dock
            new Tile(2594, 3418, 0),
            new Tile(2600, 3422, 0)
    };
    private static TilePath toBank = new TilePath(WALKING_PATH_TO_BANK);
    private static TilePath toDockOne = new TilePath(WALKING_PATH_TO_DOCK_1);
    private static TilePath toDockTwo = new TilePath(WALKING_PATH_TO_DOCK_2);
    private static TilePath toSpot;

    public static TilePath getToSpot() {
        return toSpot;
    }

    public static void setToSpot(TilePath toSpot) {
        Constants.toSpot = toSpot;
    }

    public static TilePath getToDockOne() {
        return toDockOne;
    }


    public static TilePath getToDockTwo() {
        return toDockTwo;
    }

    public static boolean isHarpoonFishing() {
        return harpoonFishing;
    }

    public static void setHarpoonFishing(boolean harpoonFishing) {
        Constants.harpoonFishing = harpoonFishing;
    }

    public static boolean isCageFishing() {
        return cageFishing;
    }

    public static void setCageFishing(boolean rocktailFishing) {
        Constants.rocktailFishing = rocktailFishing;
    }

    public static boolean isRocktailFishing() {
        return cageFishing;
    }

    public static void setRocktailFishing(boolean rocktailFishing) {
        Constants.rocktailFishing = rocktailFishing;
    }

    public static boolean AutoProgression() {
        return autoProgression;
    }

    public static void setAutoProgression(boolean autoProgression) {
        Constants.autoProgression = autoProgression;
    }

    public static int getFishingSpotId() {
        return fishingSpotId;
    }

    public static void setFishingSpotId(int fishingSpotId) {
        Constants.fishingSpotId = fishingSpotId;
    }

    public static int getFishingAnim() {
        return fishingAnim;
    }

    public static void setFishingAnim(int fishingAnim) {
        Constants.fishingAnim = fishingAnim;
    }

    public static Npcs.Option getInteractOption() {
        return interactOption;
    }

    public static void setInteractOption(Npcs.Option interactOption) {
        Constants.interactOption = interactOption;
    }

    public static Tile[] getWalkingPathToDock1() {
        return WALKING_PATH_TO_DOCK_1;
    }

    public static Tile[] getWalkingPathToDock2() {
        return WALKING_PATH_TO_DOCK_2;
    }

    public static boolean isNetFishing() {
        return netFishing;
    }

    public static void setNetFishing(boolean netFishing) {
        Constants.netFishing = netFishing;
    }

    public static int getFishingToolId() {
        return fishingToolId;
    }

    public static void setFishingToolId(int fishingToolId) {
        Constants.fishingToolId = fishingToolId;
    }

    public static boolean isRunning() {
        return running;
    }

    public static void setRunning(boolean running) {
        Constants.running = running;
    }

    public static boolean isDropping() {
        return dropping;
    }

    public static void setDropping(boolean dropping) {
        Constants.dropping = dropping;
    }

    public static boolean isBanking() {
        return banking;
    }

    public static void setBanking(boolean banking) {
        Constants.banking = banking;
    }

    public static TilePath getToBank() {
        return toBank;
    }

    public static int getBankInterfaceId() {
        return BANK_INTERFACE_ID;
    }

    public static int getBankBoothId() {
        return BANK_BOOTH_ID;
    }

    public static int getWithdrawFive() {
        return WITHDRAW_FIVE;
    }

    public static int getWithdrawOne() {
        return WITHDRAW_ONE;
    }

    public static int getWithdrawTen() {
        return WITHDRAW_TEN;
    }

    public static int getWithdrawX() {
        return WITHDRAW_X;
    }

    public static int getWithdrawAll() {
        return WITHDRAW_ALL;
    }

    public static int getWithdrawAllButOne() {
        return WITHDRAW_ALL_BUT_ONE;
    }

    public enum FishingTypes {
        SHRIMP(304, 621, 316, Npcs.Option.NET), LOBSTER(302, 619, 312, Npcs.Option.CAGE), TUNASWORDFISH(312, 618, 312, Npcs.Option.HARPOON), ROCKTAIL(304, 621, 313, Npcs.Option.NET);

        private final int toolId;
        private final int animId;
        private final int spotId;
        private final Npcs.Option option;

        FishingTypes(int toolId, int animId, int spotId, Npcs.Option option) {
            this.toolId = toolId;
            this.animId = animId;
            this.spotId = spotId;
            this.option = option;
        }

        public int getToolId() {
            return toolId;
        }

        public int getAnimId() {
            return animId;
        }

        public int getSpotId() {
            return spotId;
        }

        public Npcs.Option getOption() {
            return option;
        }
    }
}
