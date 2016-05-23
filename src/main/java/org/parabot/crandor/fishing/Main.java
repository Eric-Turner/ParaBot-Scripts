package org.parabot.crandor.fishing;

import org.parabot.crandor.fishing.resources.GUI;
import org.parabot.crandor.fishing.resources.Variables;
import org.parabot.crandor.fishing.strategies.Banking;
import org.parabot.crandor.fishing.strategies.Dropping;
import org.parabot.crandor.fishing.strategies.Fishing;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

import java.util.ArrayList;

/**
 * @author EricTurner
 */
@ScriptManifest(
        author = "EricTurner",
        category = Category.FISHING,
        description = "Fishing Application Script",
        name = "eFishing",
        servers = {"Crandor"},
        version = 3)
public class Main extends Script {
    private final ArrayList<Strategy> strategies = new ArrayList<>();

    @Override
    public boolean onExecute() {
        GUI frame = new GUI();
        frame.setVisible(true);
        while (frame.isVisible())
            sleep(100);
        if (Variables.isBanking()) {
            strategies.add(new Banking());
        }
        if (Variables.isDropping()) {
            strategies.add(new Dropping());
        }
        strategies.add(new Fishing());
        provide(strategies);
        return true;
    }
}