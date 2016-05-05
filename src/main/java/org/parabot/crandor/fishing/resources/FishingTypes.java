package org.parabot.crandor.fishing.resources;

import org.rev317.min.api.methods.Npcs;

/**
 * Created by Eric on 5/4/2016.
 */
public enum FishingTypes {
    SHRIMP(304, 621, 316, Npcs.Option.NET), LOBSTER(302, 619, 312, Npcs.Option.CAGE), TUNASWORDFISH(312, 618, 312, Npcs.Option.HARPOON), ROCKTAIL(304, 621, 313, Npcs.Option.NET);

    private final int toolId;
    private final int animId;
    private final int spotId;
    private final Npcs.Option option;

    FishingTypes(int toolId, int animId, int spotId, Npcs.Option option) {
        this.toolId = toolId;
        this.animId = animId;
        this.spotId = spotId;
        this.option = option;
    }

    public int getToolId() {
        return toolId;
    }

    public int getAnimId() {
        return animId;
    }

    public int getSpotId() {
        return spotId;
    }

    public Npcs.Option getOption() {
        return option;
    }
}
