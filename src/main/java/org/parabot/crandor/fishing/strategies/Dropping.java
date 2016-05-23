package org.parabot.crandor.fishing.strategies;

import org.parabot.crandor.fishing.resources.Variables;
import org.parabot.environment.api.utils.Time;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.wrappers.Item;

/**
 * @author EricTurner
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
                if (x.getId() != Variables.getFish().getToolId()) {
                    x.drop();
                    Time.sleep(25);
                }
            }
        }
    }
}