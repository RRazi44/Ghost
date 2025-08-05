package fr.razi.ghostmod.features;

import fr.razi.ghostmod.GhostSettings;
import net.minecraft.client.Minecraft;

public class KeepFly implements IGhostModule {

    private final Minecraft minecraft = Minecraft.getMinecraft();

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void toggle() {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void onTick() {
        if (GhostSettings.keepFly) {
            if(minecraft.thePlayer.capabilities.allowFlying){
                minecraft.thePlayer.capabilities.isFlying = true;
            }
        } else {
            minecraft.thePlayer.capabilities.isFlying = false;
        }
    }

    @Override
    public void onRender() {

    }

}
