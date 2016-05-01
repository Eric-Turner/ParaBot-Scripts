package org.parabot.crandor.fishing.strategies;


import org.parabot.crandor.fishing.resources.Methods;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.Item;
import org.rev317.min.api.wrappers.SceneObject;
import org.rev317.min.api.wrappers.Tile;
import org.rev317.min.api.wrappers.TilePath;


/**
 * Created by Eric on 4/6/2016.
 */
public class Banking implements Strategy {


    static Tile[] WALKING_PATH = {
            new Tile(2601, 3406, 0),
            new Tile(2593, 3415, 0),
            new Tile(2586, 3421, 0)};
    public static TilePath toBank = new TilePath(WALKING_PATH);
    final int BANK_BOOTH_ID = 2213;
    final int BANK_INTERFACE_ID = 5292;
    final int[] FISHING_TOOL_IDS = {304, 312, 302};

    @Override
    public boolean activate() {
        return Inventory.isFull();
    }

    @Override
    public void execute() {
        if (toBank.getTiles()[2].distanceTo() > 7) {
            toBank.traverse();
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return toBank.hasReached();
                }
            }, 1500);
        }
        SceneObject bank = SceneObjects.getClosest(BANK_BOOTH_ID);
        if (bank.distanceTo() <= 5) {
            if (Game.getOpenInterfaceId() != BANK_INTERFACE_ID) {
                bank.interact(SceneObjects.Option.USE_QUICKLY);
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return Game.getOpenInterfaceId() == BANK_INTERFACE_ID;
                    }
                }, 5000);
            } else {
                if (Game.getOpenInterfaceId() == BANK_INTERFACE_ID) {
                    if (Inventory.isFull()) {
                        for (Item x : Inventory.getItems()) {
                            if (x != null) {
                                if (x.getId() != FISHING_TOOL_IDS[0] && x.getId() != FISHING_TOOL_IDS[1] && x.getId() != FISHING_TOOL_IDS[2]) {
                                    Menu.sendAction(78, x.getId() - 1, x.getSlot(), 5064);
                                    Time.sleep(100);
                                }
                            }
                        }
                    }
                    if (!Inventory.isFull()) {
                        if (Game.getOpenInterfaceId() == BANK_INTERFACE_ID) {
                            Methods.closeBank();
                        }
                    }
                }
            }
        }
    }
}
