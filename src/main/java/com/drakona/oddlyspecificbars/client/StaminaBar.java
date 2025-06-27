package com.drakona.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.drakona.oddlyspecificbars.config.StaminaPosConfig.*;

@Mod.EventBusSubscriber(modid = "oddlyspecificbars", value = Dist.CLIENT)

public class StaminaBar {
	private static final ResourceLocation BAR_BACKGROUND = new ResourceLocation("oddly_specific_bars", "textures/bars/stamina_background.png");
    private static final ResourceLocation BAR_FILL = new ResourceLocation("oddly_specific_bars", "textures/bars/stamina_fil.png");

    // 💡 Dynamic control variables
    private static final int baseWidth = 80;  // original bar width in pixels
    private static final int baseHeight = 10;

    private static final float scale = HUD_SCALE.get().floatValue();      // change this to scale bar (1.0 = 100%, 2.0 = 200%, etc.)
    private static final int barXOffset = HUD_X_OFFSET.get();      // X offset from left
    private static final int barYOffset = HUD_Y_OFFSET.get();      // Y offset from bottom

    @SubscribeEvent
    public static void onRenderOverlay(RenderGuiEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        GuiGraphics guiGraphics = event.getGuiGraphics();

        int screenWidth = mc.getWindow().getGuiScaledWidth();
        int screenHeight = mc.getWindow().getGuiScaledHeight();

        // Apply scaling
        int scaledWidth = (int)(baseWidth * scale);
        int scaledHeight = (int)(baseHeight * scale);

        // Final position
        int barX = barXOffset;
        int barY = screenHeight - barYOffset;

        // Example current value
        int current = 60;
        int max = 100;
        int filledWidth = (int)((current / (float) max) * scaledWidth);

        // Draw background
        guiGraphics.blit(BAR_BACKGROUND, barX, barY, 0, 0, scaledWidth, scaledHeight);

        // Draw fill
        guiGraphics.blit(BAR_FILL, barX, barY, 0, 0, filledWidth, scaledHeight);
    }
}