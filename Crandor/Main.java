package Crandor;

import Crandor.Resources.GUI;
import Crandor.Strategies.Banking;
import Crandor.Strategies.Dropping;
import Crandor.Strategies.Fishing;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;

import java.util.ArrayList;

/**
 * Created by Eric on 4/29/2016.
 */
@ScriptManifest(author = "EricTurner", category = Category.FISHING, description = "Fishing Application Script", name = "eFishing", servers = {"Crandor"}, version = 1)
public class Main extends Script {

    public static boolean banking = false;
    public static boolean dropping = false;
    public static boolean running = false;

    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

    @Override
    public boolean onExecute() {
        GUI frame = new GUI();
        frame.setVisible(true);
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return running;
            }
        }, Integer.MAX_VALUE);
        if (banking == true) {
            strategies.add(new Banking());
        }
        if (dropping == true) {
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


