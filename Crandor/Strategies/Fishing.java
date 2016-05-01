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
    public static boolean netFishing = false;
    public static boolean harpoonFishing = false;
    public static boolean cageFishing = false;
    public static boolean autoProgression = false;

    static Tile lastTile;
    static Tile[] WALKING_PATH = {
            new Tile(2586, 3421, 0),
            new Tile(2593, 3415, 0),
            new Tile(2601, 3406, 0),
            new Tile(2604, 3414, 0)};
    public static TilePath toSpot = new TilePath(WALKING_PATH);


    int fishingAnim;
    int fishingSpotId;

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

        if (autoProgression) {

            //Will update to work when the hooks are added to get current skill level

            /*if (Methods.isBetween(Skill.FISHING.getLevel(), 1, 34)) {
                //Net Fishing
                fishingSpotId = 25375;

            }
            if (Methods.isBetween(Skill.FISHING.getLevel(), 35, 40)) {
                //Harpoon fishing
            }
            if (Methods.isBetween(Skill.FISHING.getLevel(), 40, 99)) {
                //Cage fishing
            }*/
        } else {

            if (netFishing) {
                fishingSpotId = 316;
                fishingAnim = 621;
                interactOption = Npcs.Option.NET;
            }
            if (cageFishing) {
                fishingSpotId = 312;
                fishingAnim = 619;
                interactOption = Npcs.Option.CAGE;
            }
            if (harpoonFishing) {
                fishingSpotId = 312;
                fishingAnim = 618;
                interactOption = Npcs.Option.HARPOON;
            }

            final Npc fishingSpot = Npcs.getClosest(fishingSpotId);
            if (fishingSpot != null) {
                if (fishingSpot.distanceTo() <= 5) {
                    //Start fishing
                    if (fishingSpot != null) {
                        if (Players.getMyPlayer().getAnimation() != fishingAnim) {
                            fishingSpot.interact(interactOption);
                            Time.sleep(1000);
                        }
                    }
                }
            }
        }
    }
}
