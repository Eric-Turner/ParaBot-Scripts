package org.parabot.crandor.fishing.resources;

import org.rev317.min.api.wrappers.Tile;
import org.rev317.min.api.wrappers.TilePath;

/**
 * @author EricTurner
 */
public class Constants {


    public final static int BANK_BOOTH_ID = 2213;
    public final static int BANK_INTERFACE_ID = 5292;
    public final static TilePath toBank = new TilePath(new Tile[] {
            new Tile(2601, 3406, 0),
            new Tile(2593, 3415, 0),
            new Tile(2586, 3421, 0)
    });
    public final static TilePath toDockOne = new TilePath(new Tile[] {
            new Tile(2586, 3421, 0),
            new Tile(2593, 3415, 0),
            new Tile(2601, 3406, 0),
            new Tile(2604, 3414, 0)
    });
    public final static TilePath toDockTwo = new TilePath(new Tile[] {
            new Tile(2594, 3418, 0),
            new Tile(2600, 3422, 0)
    });
}