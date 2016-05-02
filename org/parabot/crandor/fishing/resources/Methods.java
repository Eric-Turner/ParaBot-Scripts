package org.parabot.crandor.fishing.resources;

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

    public static int getBankSlot(int itemId) {
        return Bank.getItem(itemId).getSlot();
    }

    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }
}
