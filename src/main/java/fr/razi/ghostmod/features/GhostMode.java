package fr.razi.ghostmod.features;

import fr.razi.ghostmod.GhostSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import org.lwjgl.input.Mouse;

public class GhostMode implements IGhostModule {

    private boolean toggled = false;
    private final Minecraft minecraft = Minecraft.getMinecraft();
    private boolean leftClickLast = false;

    @Override
    public String getName() {
        return "GhostMode";
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
        if (GhostSettings.ghostMode) {
            boolean leftClick = Mouse.isButtonDown(0);
            if (leftClick && !leftClickLast && minecraft.objectMouseOver != null && minecraft.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                BlockPos pos = minecraft.objectMouseOver.getBlockPos();
                minecraft.theWorld.setBlockToAir(pos);
            }
            leftClickLast = Mouse.isButtonDown(0);
        }
    }

    @Override
    public void onRender() {

    }
}
