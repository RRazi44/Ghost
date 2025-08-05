package fr.razi.ghostmod.features;

import fr.razi.ghostmod.GhostSettings;
import net.minecraft.client.Minecraft;

public class ToggleSprint implements IGhostModule {

    private boolean toggled = false;
    private final Minecraft minecraft = Minecraft.getMinecraft();

    @Override
    public String getName() {
        return "ToggleSprint";
    }

    @Override
    public void toggle() {
        toggled = !toggled;
    }

    @Override
    public boolean isEnabled() {
        return toggled;
    }

    @Override
    public void onTick() {
        if(GhostSettings.toggleSprint){
            if(!minecraft.thePlayer.isSprinting() && minecraft.thePlayer.moveForward > 0){
                minecraft.thePlayer.setSprinting(true);
            }
        }
    }

    @Override
    public void onRender() {

    }

}
