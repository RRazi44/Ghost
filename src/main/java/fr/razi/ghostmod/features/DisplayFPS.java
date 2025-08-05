package fr.razi.ghostmod.features;

import fr.razi.ghostmod.GhostSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;

public class DisplayFPS implements IGhostModule {

    private boolean toggled = false;
    private final Minecraft minecraft = Minecraft.getMinecraft();

    @Override
    public String getName() {
        return "DisplayFPS";
    }

    @Override
    public void toggle() {
        toggled = !toggled;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void onTick() {

    }

    @Override
    public void onRender() {
        if(!GhostSettings.showFPS) return;
        int fps = Minecraft.getDebugFPS();
        String fpsText = EnumChatFormatting.GREEN + "FPS: " + EnumChatFormatting.WHITE + fps;
        int textWidth = minecraft.fontRendererObj.getStringWidth(fpsText);
        int screenWidth = new ScaledResolution(minecraft).getScaledWidth();
        minecraft.fontRendererObj.drawStringWithShadow(fpsText, (screenWidth - textWidth) >> 1, 5, 0xFFFFFF);
    }
}
