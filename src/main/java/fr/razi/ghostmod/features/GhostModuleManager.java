package fr.razi.ghostmod.features;

import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;

public class GhostModuleManager {

    private final List<IGhostModule> modules = new ArrayList<>();
    private final Minecraft minecraft;

    public GhostModuleManager(Minecraft mc){
        this.minecraft = mc;
    }

    public void onTick(){
        for(IGhostModule modules : modules){
            modules.onTick();
        }
    }

    public void onRender(){
        for(IGhostModule modules : modules){
            modules.onRender();
        }
    }

    public List<IGhostModule> getModules(){
        return modules;
    }

}
