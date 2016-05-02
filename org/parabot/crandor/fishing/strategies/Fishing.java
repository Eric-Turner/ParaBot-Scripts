package org.parabot.crandor.fishing.strategies;

import org.parabot.crandor.fishing.resources.Constants;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Npc;

/**
 * Created by Eric on 4/29/2016.
 */
public class Fishing implements org.parabot.environment.scripts.framework.Strategy {


    @Override
    public boolean activate() {
        return !Inventory.isFull();
    }

    @Override
    public void execute() {
        if (Constants.getToSpot().getTiles()[3].distanceTo() > 7) {
            Constants.getToSpot().traverse();
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Constants.getToSpot().hasReached();
                }
            }, 1500);
        }

        /*if (Constants.isAutoProgression()) {

            //Will update to work when the hooks are added to get current skill level

            if (Methods.isBetween(Skill.FISHING.getLevel(), 1, 34)) {
                //Net Fishing
                fishingSpotId = 25375;

            }
            if (Methods.isBetween(Skill.FISHING.getLevel(), 35, 40)) {
                //Harpoon fishing
            }
            if (Methods.isBetween(Skill.FISHING.getLevel(), 40, 99)) {
                //Cage fishing
            }
        }else */
        final Npc fishingSpot = Npcs.getClosest(Constants.getFishingSpotId());
        if (fishingSpot != null) {
            if (fishingSpot.distanceTo() <= 5) {
                //Start fishing
                if (fishingSpot != null) {
                    if (Players.getMyPlayer().getAnimation() != Constants.getFishingAnim()) {
                        fishingSpot.interact(Constants.getInteractOption());
                        Time.sleep(1000);
                    }
                }
            }
        }
    }
}
