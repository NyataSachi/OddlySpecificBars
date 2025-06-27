package net.drakona.oddlyspecificbars.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class StaminaPosConfig {
 public static final ForgeConfigSpec CLIENT_CONFIG;
    public static final ForgeConfigSpec.DoubleValue HUD_SCALE;
    public static final ForgeConfigSpec.IntValue HUD_X_OFFSET;
    public static final ForgeConfigSpec.IntValue HUD_Y_OFFSET;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("HUD Settings");

        HUD_SCALE = builder
                .comment("HUD Scale (1.0 = normal size)")
                .defineInRange("scale", 1.0, 0.1, 5.0);

        HUD_X_OFFSET = builder
                .comment("Horizontal offset (px from left)")
                .defineInRange("xOffset", 43, 0, 1000);

        HUD_Y_OFFSET = builder
                .comment("Vertical offset (px from bottom)")
                .defineInRange("yOffset", 61, 0, 1000);

        builder.pop();

        CLIENT_CONFIG = builder.build();
    }

    public static void register(ModConfig.Type type) {
        // no-op in this class, handled in main mod class
    }
}
