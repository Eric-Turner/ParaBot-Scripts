package Crandor.Strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Npc;
import org.rev317.min.api.wrappers.Tile;
import org.rev317.min.api.wrappers.TilePath;

/**
 * Created by Eric on 4/29/2016.
 */
public class Fishing implements org.parabot.environment.scripts.framework.Strategy {
    public static boolean net_fishing = false;
    public static boolean harpoon_fishing = false;
    public static boolean cage_fishing = false;
    public static boolean auto_progression = false;

    static Tile lastTile;
    static Tile[] WALKING_PATH = {
            new Tile(2586, 3421, 0),
            new Tile(2593, 3415, 0),
            new Tile(2601, 3406, 0),
            new Tile(2604, 3414, 0)};
    public static TilePath toSpot = new TilePath(WALKING_PATH);


    int fishing_animation_id;
    int fishing_spot_id;

    Npcs.Option interactOption;


    @Override
    public boolean activate() {
        return !Inventory.isFull();
    }

    @Override
    public void execute() {
        if (toSpot.getTiles()[3].distanceTo() > 7) {
            toSpot.traverse();
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return toSpot.hasReached();
                }
            }, 1500);
        }

        if (auto_progression) {

            //Will update to work when the hooks are added to get current skill level

            /*if (Methods.isBetween(Skill.FISHING.getLevel(), 1, 34)) {
                //Net Fishing
                fishing_spot_id = 25375;

            }
            if (Methods.isBetween(Skill.FISHING.getLevel(), 35, 40)) {
                //Harpoon fishing
            }
            if (Methods.isBetween(Skill.FISHING.getLevel(), 40, 99)) {
                //Cage fishing
            }*/
        } else {

            if (net_fishing) {
                fishing_spot_id = 316;
                fishing_animation_id = 621;
                interactOption = Npcs.Option.NET;
            }
            if (cage_fishing) {
                fishing_spot_id = 312;
                fishing_animation_id = 619;
                interactOption = Npcs.Option.CAGE;
            }
            if (harpoon_fishing) {
                fishing_spot_id = 312;
                fishing_animation_id = 618;
                interactOption = Npcs.Option.HARPOON;
            }

            final Npc fishSpot = Npcs.getClosest(fishing_spot_id);
            if (fishSpot != null) {
                if (fishSpot.distanceTo() <= 5) {
                    //Start fishing
                    if (fishSpot != null) {
                        if (Players.getMyPlayer().getAnimation() != fishing_animation_id) {
                            fishSpot.interact(interactOption);
                            Time.sleep(1000);
                        }
                    }
                }
            }
        }
    }
}
