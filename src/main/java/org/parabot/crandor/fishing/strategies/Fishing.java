package org.parabot.crandor.fishing.strategies;

import org.parabot.crandor.fishing.resources.Fish;
import org.parabot.crandor.fishing.resources.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.Skill;
import org.rev317.min.api.wrappers.Npc;

/**
 * @author EricTurner
 */
public class Fishing implements org.parabot.environment.scripts.framework.Strategy {

    @Override
    public boolean activate() {
        return !Inventory.isFull() && Inventory.contains(Variables.getFish().getToolId());
    }

    @Override
    public void execute() {
        if (Variables.isAutoProgression()) {
            for (Fish fish : Fish.values()) {
                if (Skill.FISHING.getRealLevel() >= fish.getRequiredLevel()) {
                    Variables.setFish(fish);
                }
            }
        }
        if (Variables.getToSpot() != null) {
            if (Variables.getToSpot().getTiles()[Variables.getToSpot().getTiles().length - 1].distanceTo() > 7) {
                Variables.getToSpot().traverse();
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return Variables.getToSpot().hasReached();
                    }
                }, 1500);
            }
        }
        final Npc fishingSpot = Npcs.getClosest(Variables.getFish().getSpotId());
        if (fishingSpot != null) {
            if (fishingSpot.distanceTo() <= 5) {
                if (Players.getMyPlayer().getAnimation() != Variables.getFish().getAnimId()) {
                    fishingSpot.interact(Variables.getFish().getOption());
                    Time.sleep(1000);
                }
            }
        }
    }
}