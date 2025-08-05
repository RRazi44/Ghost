package fr.razi.ghostmod.features;

import fr.razi.ghostmod.GhostSettings;
import net.minecraft.client.Minecraft;

public class FullBright implements IGhostModule {

    private final Minecraft mc = Minecraft.getMinecraft();
    private boolean enabled = false;
    private float previousGamma = -1f;

    @Override
    public String getName() {
        return "FullBright";
    }

    @Override
    public void toggle() {
        enabled = !enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void onTick() {
        if(GhostSettings.fullBright){
            if(previousGamma == -1f) previousGamma = mc.gameSettings.gammaSetting;
            mc.gameSettings.gammaSetting = 1000.0F;
        } else{
            if(previousGamma != 1){
                mc.gameSettings.gammaSetting = previousGamma;
                previousGamma = 1f;
            }
        }
    }

    @Override
    public void onRender() {
        if(!enabled && previousGamma != -1f){
            mc.gameSettings.gammaSetting = previousGamma;
            previousGamma = -1f;
        }
    }
}
