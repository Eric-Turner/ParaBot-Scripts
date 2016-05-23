package org.parabot.crandor.fishing.resources;

import org.rev317.min.api.methods.Npcs;

/**
 * @author EricTurner
 */
public enum Fish {
    SHRIMP(304, 621, 316, Npcs.Option.NET, 0),
    TUNASWORDFISH(312, 618, 312, Npcs.Option.HARPOON, 35),
    LOBSTER(302, 619, 312, Npcs.Option.CAGE, 40),
    ROCKTAIL(304, 621, 313, Npcs.Option.NET, 99);

    private final int toolId;
    private final int animId;
    private final int spotId;
    private final Npcs.Option option;
    private final int requiredLevel;

    Fish(int toolId, int animId, int spotId, Npcs.Option option, int requiredLevel) {
        this.toolId = toolId;
        this.animId = animId;
        this.spotId = spotId;
        this.option = option;
        this.requiredLevel = requiredLevel;
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

    public int getRequiredLevel() {
        return requiredLevel;
    }
}