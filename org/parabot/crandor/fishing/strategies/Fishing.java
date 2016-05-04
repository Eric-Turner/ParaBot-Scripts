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
import org.rev317.min.api.wrappers.TilePath;

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

        if (Constants.AutoProgression()) {

            //Will update to work when the hooks are added to get current skill level

            if (Methods.isBetween(Skill.FISHING.getRealLevel(), 1, 34)) {
                //Net Fishing
                Constants.setNetFishing(true);
                Constants.setFishingSpotId(Constants.FishingTypes.SHRIMP.getSpotId());
                Constants.setFishingAnim(Constants.FishingTypes.SHRIMP.getAnimId());
                Constants.setInteractOption(Constants.FishingTypes.SHRIMP.getOption());
                Constants.setFishingToolId(Constants.FishingTypes.SHRIMP.getToolId());
                Constants.setToSpot(Constants.getToDockOne());
            }
            if (Methods.isBetween(Skill.FISHING.getRealLevel(), 35, 40)) {
                //Harpoon fishing

                Constants.setNetFishing(false);
                Constants.setHarpoonFishing(true);
                Constants.setFishingSpotId(Constants.FishingTypes.TUNASWORDFISH.getSpotId());
                Constants.setFishingAnim(Constants.FishingTypes.TUNASWORDFISH.getAnimId());
                Constants.setInteractOption(Constants.FishingTypes.TUNASWORDFISH.getOption());
                Constants.setFishingToolId(Constants.FishingTypes.TUNASWORDFISH.getToolId());
                Constants.setToSpot(Constants.getToDockTwo());
            }
            if (Methods.isBetween(Skill.FISHING.getRealLevel(), 40, 98)) {
                //Cage fishing
                Constants.setCageFishing(true);
                Constants.setHarpoonFishing(false);
                Constants.setFishingSpotId(Constants.FishingTypes.LOBSTER.getSpotId());
                Constants.setFishingAnim(Constants.FishingTypes.LOBSTER.getAnimId());
                Constants.setInteractOption(Constants.FishingTypes.LOBSTER.getOption());
                Constants.setFishingToolId(Constants.FishingTypes.LOBSTER.getToolId());
                Constants.setToSpot(Constants.getToDockTwo());
            }
            if (Skill.FISHING.getRealLevel() == 99) {
                //Rocktail fishing
                Constants.setCageFishing(false);
                Constants.setRocktailFishing(true);
                Constants.setFishingSpotId(Constants.FishingTypes.ROCKTAIL.getSpotId());
                Constants.setFishingAnim(Constants.FishingTypes.ROCKTAIL.getAnimId());
                Constants.setInteractOption(Constants.FishingTypes.ROCKTAIL.getOption());
                Constants.setFishingToolId(Constants.FishingTypes.ROCKTAIL.getToolId());
                Constants.setToSpot(Constants.getToDockTwo());
            }
        }
        if (Constants.getToSpot() != null) {
            if (Constants.getToSpot().getTiles()[Constants.getToSpot().getTiles().length - 1].distanceTo() > 7) {
                Constants.getToSpot().traverse();
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return Constants.getToSpot().hasReached();
                    }
                }, 1500);
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
