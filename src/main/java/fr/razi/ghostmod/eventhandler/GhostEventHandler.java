package fr.razi.ghostmod.eventhandler;

import fr.razi.ghostmod.Ghost;
import fr.razi.ghostmod.GhostKey;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;


public class GhostEventHandler {

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.isCanceled() || Ghost.mc.theWorld == null || Ghost.mc.thePlayer == null) return;
        Ghost.ghostManager.onTick();
        GhostKey.tickAll();
    }

    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent.Text event){

    }

}
