package org.parabot.crandor.fishing.strategies;

import org.parabot.crandor.fishing.resources.Constants;
import org.parabot.crandor.fishing.resources.Methods;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.Skill;
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

        if (Constants.AutoProgression()) {

            //Will update to work when the hooks are added to get current skill level

            if (Methods.isBetween(Skill.FISHING.getRealLevel(), 1, 34)) {
                //Net Fishing
                Constants.setNetFishing(true);
                Constants.setCageFishing(false);
                Constants.setHarpoonFishing(false);
                Constants.setFishingSpotId(Constants.FishingTypes.NET.getSpotId());
                Constants.setFishingAnim(Constants.FishingTypes.NET.getAnimId());
                Constants.setInteractOption(Constants.FishingTypes.NET.getOption());
                Constants.setFishingToolId(Constants.FishingTypes.NET.getToolId());
            }
            if (Methods.isBetween(Skill.FISHING.getRealLevel(), 35, 40)) {
                //Harpoon fishing

                Constants.setNetFishing(false);
                Constants.setCageFishing(false);
                Constants.setHarpoonFishing(true);
                Constants.setFishingSpotId(Constants.FishingTypes.HARPOON.getSpotId());
                Constants.setFishingAnim(Constants.FishingTypes.HARPOON.getAnimId());
                Constants.setInteractOption(Constants.FishingTypes.HARPOON.getOption());
                Constants.setFishingToolId(Constants.FishingTypes.HARPOON.getToolId());

            }
            if (Methods.isBetween(Skill.FISHING.getRealLevel(), 40, 99)) {
                //Cage fishing
                Constants.setNetFishing(false);
                Constants.setCageFishing(true);
                Constants.setHarpoonFishing(false);
                Constants.setFishingSpotId(Constants.FishingTypes.CAGE.getSpotId());
                Constants.setFishingAnim(Constants.FishingTypes.CAGE.getAnimId());
                Constants.setInteractOption(Constants.FishingTypes.CAGE.getOption());
                Constants.setFishingToolId(Constants.FishingTypes.CAGE.getToolId());
            }
        }
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
