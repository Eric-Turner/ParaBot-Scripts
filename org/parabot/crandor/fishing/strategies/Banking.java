package org.parabot.crandor.fishing.strategies;


import org.parabot.crandor.fishing.resources.Constants;
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


/**
 * Created by Eric on 4/6/2016.
 */
public class Banking implements Strategy {


    @Override
    public boolean activate() {
        return Inventory.isFull();
    }

    @Override
    public void execute() {
        if (Constants.getToBank().getTiles()[2].distanceTo() > 5) {
            Constants.getToBank().traverse();
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Constants.getToBank().hasReached();
                }
            }, 1500);
        }
        SceneObject bank = SceneObjects.getClosest(Constants.getBankBoothId());
        if (bank != null) {
            if (bank.distanceTo() <= 5) {
                if (Game.getOpenInterfaceId() != Constants.getBankInterfaceId()) {
                    bank.interact(SceneObjects.Option.USE_QUICKLY);
                    Time.sleep(new SleepCondition() {
                        @Override
                        public boolean isValid() {
                            return Game.getOpenInterfaceId() == Constants.getBankInterfaceId();
                        }
                    }, 5000);
                } else {
                    if (Game.getOpenInterfaceId() == Constants.getBankInterfaceId()) {
                        if (Inventory.isFull()) {
                            for (Item x : Inventory.getItems()) {
                                if (x != null) {
                                    if (x.getId() != Constants.getFishingToolId()) {
                                        Menu.sendAction(78, x.getId() - 1, x.getSlot(), 5064);
                                        Time.sleep(100);
                                    }
                                }
                            }
                        }
                        if (!Inventory.isFull()) {
                            if (Game.getOpenInterfaceId() == Constants.getBankInterfaceId()) {
                                Methods.closeBank();
                            }
                        }
                    }
                }
            }
        }
    }
}
