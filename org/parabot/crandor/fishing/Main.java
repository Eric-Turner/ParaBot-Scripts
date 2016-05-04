package org.parabot.crandor.fishing;

import org.parabot.crandor.fishing.resources.Constants;
import org.parabot.crandor.fishing.resources.FishingTypes;
import org.parabot.crandor.fishing.resources.GUI;
import org.parabot.crandor.fishing.resources.Methods;
import org.parabot.crandor.fishing.strategies.Banking;
import org.parabot.crandor.fishing.strategies.Dropping;
import org.parabot.crandor.fishing.strategies.Fishing;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Skill;

import java.util.ArrayList;

/**
 * Created by Eric on 4/29/2016.
 */
@ScriptManifest(author = "EricTurner", category = Category.FISHING, description = "Fishing Application Script", name = "eFishing", servers = {"Crandor"}, version = 3)
public class Main extends Script {


    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

    @Override
    public boolean onExecute() {
        GUI frame = new GUI();
        frame.setVisible(true);
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return Constants.isRunning();
            }
        }, Integer.MAX_VALUE);

        if (Constants.AutoProgression()) {

            //Will update to work when the hooks are added to get current skill level

            if (Methods.isBetween(Skill.FISHING.getRealLevel(), 1, 34)) {
                //Net Fishing
                Constants.setNetFishing(true);
                Constants.setFishingSpotId(FishingTypes.SHRIMP.getSpotId());
                Constants.setFishingAnim(FishingTypes.SHRIMP.getAnimId());
                Constants.setInteractOption(FishingTypes.SHRIMP.getOption());
                Constants.setFishingToolId(FishingTypes.SHRIMP.getToolId());
                Constants.setToSpot(Constants.getToDockOne());
            }
            if (Methods.isBetween(Skill.FISHING.getRealLevel(), 35, 40)) {
                //Harpoon fishing

                Constants.setNetFishing(false);
                Constants.setHarpoonFishing(true);
                Constants.setFishingSpotId(FishingTypes.TUNASWORDFISH.getSpotId());
                Constants.setFishingAnim(FishingTypes.TUNASWORDFISH.getAnimId());
                Constants.setInteractOption(FishingTypes.TUNASWORDFISH.getOption());
                Constants.setFishingToolId(FishingTypes.TUNASWORDFISH.getToolId());
                Constants.setToSpot(Constants.getToDockTwo());
            }
            if (Methods.isBetween(Skill.FISHING.getRealLevel(), 40, 98)) {
                //Cage fishing
                Constants.setCageFishing(true);
                Constants.setHarpoonFishing(false);
                Constants.setFishingSpotId(FishingTypes.LOBSTER.getSpotId());
                Constants.setFishingAnim(FishingTypes.LOBSTER.getAnimId());
                Constants.setInteractOption(FishingTypes.LOBSTER.getOption());
                Constants.setFishingToolId(FishingTypes.LOBSTER.getToolId());
                Constants.setToSpot(Constants.getToDockTwo());
            }
            if (Skill.FISHING.getRealLevel() == 99) {
                //Rocktail fishing
                Constants.setCageFishing(false);
                Constants.setRocktailFishing(true);
                Constants.setFishingSpotId(FishingTypes.ROCKTAIL.getSpotId());
                Constants.setFishingAnim(FishingTypes.ROCKTAIL.getAnimId());
                Constants.setInteractOption(FishingTypes.ROCKTAIL.getOption());
                Constants.setFishingToolId(FishingTypes.ROCKTAIL.getToolId());
                Constants.setToSpot(Constants.getToDockTwo());
            }
        }

        if (Constants.isBanking()) {
            strategies.add(new Banking());
        }
        if (Constants.isDropping()) {
            strategies.add(new Dropping());
        }

        strategies.add(new Fishing());
        provide(strategies);
        return true;
    }

    @Override
    public void onFinish() {

    }

}


