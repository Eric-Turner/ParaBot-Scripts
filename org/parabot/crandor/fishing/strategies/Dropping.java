package org.parabot.crandor.fishing.strategies;

import org.parabot.environment.api.utils.Time;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.wrappers.Item;

/**
 * Created by Eric on 4/29/2016.
 */
public class Dropping implements org.parabot.environment.scripts.framework.Strategy {

    final int[] FISHING_TOOL_IDS = {304, 312, 302};

    @Override
    public boolean activate() {
        return Inventory.isFull();
    }

    @Override
    public void execute() {
        for (Item x : Inventory.getItems()) {
            if (x != null) {
                if (x.getId() != FISHING_TOOL_IDS[0] && x.getId() != FISHING_TOOL_IDS[1] && x.getId() != FISHING_TOOL_IDS[2]) {
                    x.drop();
                    Time.sleep(25);
                }
            }
        }
    }
}
