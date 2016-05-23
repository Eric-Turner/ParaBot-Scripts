package org.parabot.crandor.fishing.strategies;


import org.parabot.crandor.fishing.resources.Constants;
import org.parabot.crandor.fishing.resources.Methods;
import org.parabot.crandor.fishing.resources.Variables;
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
 * @author EricTurner
 */
public class Banking implements Strategy {

    @Override
    public boolean activate() {
        return Inventory.isFull();
    }

    @Override
    public void execute() {
        if (Constants.toBank.getTiles()[2].distanceTo() > 5) {
            Constants.toBank.traverse();
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Constants.toBank.hasReached();
                }
            }, 1500);
        }
        SceneObject bank = SceneObjects.getClosest(Constants.BANK_BOOTH_ID);
        if (bank != null) {
            if (bank.distanceTo() <= 5) {
                if (Game.getOpenInterfaceId() != Constants.BANK_INTERFACE_ID) {
                    bank.interact(SceneObjects.Option.USE_QUICKLY);
                    Time.sleep(new SleepCondition() {
                        @Override
                        public boolean isValid() {
                            return Game.getOpenInterfaceId() == Constants.BANK_INTERFACE_ID;
                        }
                    }, 5000);
                } else {
                    if (Game.getOpenInterfaceId() == Constants.BANK_INTERFACE_ID) {
                        if (Inventory.isFull()) {
                            for (Item x : Inventory.getItems()) {
                                if (x != null) {
                                    if (x.getId() != Variables.getFish().getToolId()) {
                                        Menu.sendAction(78, x.getId() - 1, x.getSlot(), 5064);
                                        Time.sleep(100);
                                    }
                                }
                            }
                        }
                        if (!Inventory.isFull()) {
                            if (Game.getOpenInterfaceId() == Constants.BANK_INTERFACE_ID) {
                                Methods.closeBank();
                            }
                        }
                    }
                }
            }
        }
    }
}