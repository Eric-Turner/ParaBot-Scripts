package Crandor.Resources;

import org.parabot.core.reflect.RefClass;
import org.parabot.core.reflect.RefMethod;
import org.rev317.min.Loader;
import org.rev317.min.api.methods.Bank;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Tile;

/**
 * Created by Eric on 4/28/2016.
 */
public class Methods {

    final static int WITHDRAW_ONE = 1;
    final static int WITHDRAW_FIVE = 5;
    final static int WITHDRAW_TEN = 10;
    final static int WITHDRAW_X = 29;
    final static int WITHDRAW_ALL = 99;
    final static int WITHDRAW_ALL_BUT_ONE = 98;

    public static void walkTo(Tile to) {
        RefClass refClass = new RefClass(Loader.getClient());
        RefMethod method = refClass.getMethod("walkTo");
        method.invoke(false, false, 0, 0, 0, 0, Players.getMyPlayer().getLocation().getRegionY(), 0, 0, to.getRegionY(), Players.getMyPlayer().getLocation().getRegionX(), true, to.getRegionX());
    }

    public static void depositAllBank() {
        Menu.sendAction(646, 1323, 6, 23412);
    }

    public static void closeBank() {
        Menu.sendAction(200, 1323, 6, 5384);
    }

    public static void withdrawFromBank(int withdrawActionNum, int itemId) {
        switch (withdrawActionNum) {
            case WITHDRAW_ONE:
                Menu.sendAction(632, itemId - 1, getBankSlot(itemId), 5382);
                break;
            case WITHDRAW_FIVE:
                Menu.sendAction(78, itemId - 1, getBankSlot(itemId), 5382);
                break;
            case WITHDRAW_TEN:
                Menu.sendAction(867, itemId - 1, getBankSlot(itemId), 5382);
                break;
            case WITHDRAW_X:
                Menu.sendAction(431, itemId - 1, getBankSlot(itemId), 5382);
                break;
            case WITHDRAW_ALL:
                Menu.sendAction(53, itemId - 1, getBankSlot(itemId), 5382);
                break;
            case WITHDRAW_ALL_BUT_ONE:
                Menu.sendAction(432, itemId - 1, getBankSlot(itemId), 5382);
                break;
            default:
                Menu.sendAction(632, itemId - 1, getBankSlot(itemId), 5382);
                break;
        }
    }

    public static int getBankSlot(int itemId) {
        return Bank.getItem(itemId).getSlot();
    }

    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }
}
