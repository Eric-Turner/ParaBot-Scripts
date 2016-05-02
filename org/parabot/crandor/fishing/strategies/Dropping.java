package org.parabot.crandor.fishing.strategies;

import org.parabot.crandor.fishing.resources.Constants;
import org.parabot.environment.api.utils.Time;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.wrappers.Item;

/**
 * Created by Eric on 4/29/2016.
 */
public class Dropping implements org.parabot.environment.scripts.framework.Strategy {


    @Override
    public boolean activate() {
        return Inventory.isFull();
    }

    @Override
    public void execute() {
        for (Item x : Inventory.getItems()) {
            if (x != null) {
                if (x.getId() != Constants.getFishingToolId()) {
                    x.drop();
                    Time.sleep(25);
                }
            }
        }
    }
}
