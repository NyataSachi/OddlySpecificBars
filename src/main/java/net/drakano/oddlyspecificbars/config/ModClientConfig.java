package net.drakano.oddlyspecificbars.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModClientConfig {
    public static final ForgeConfigSpec CLIENT_CONFIG;
    public static final ForgeConfigSpec.DoubleValue HUD_SCALE;
    public static final ForgeConfigSpec.IntValue HUD_X_OFFSET;
    public static final ForgeConfigSpec.IntValue HUD_Y_OFFSET;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("HUD Settings");

        HUD_SCALE = builder
            .comment("HUD scale (1.0 = normal)")
            .defineInRange("scale", 1.0, 0.1, 5.0);

        HUD_X_OFFSET = builder
            .comment("X offset from left (px)")
            .defineInRange("xOffset", 21, 0, 2000);

        HUD_Y_OFFSET = builder
            .comment("Y offset from bottom (px)")
            .defineInRange("yOffset", 32, 0, 2000);

        builder.pop();
        CLIENT_CONFIG = builder.build();
    }
}