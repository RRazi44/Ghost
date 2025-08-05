package fr.razi.ghostmod.gui;

import fr.razi.ghostmod.GhostSettings;
import fr.razi.ghostmod.config.ConfigManager;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;

public class GhostGUI extends GuiScreen {

    private final EnumChatFormatting green = EnumChatFormatting.GREEN;
    private final EnumChatFormatting red = EnumChatFormatting.RED;

    @Override
    public void initGui(){
        int centerX = width/2;
        int startY = 200;
        int spacing = 30;

        this.buttonList.clear();
        this.buttonList.add(new GuiButton(1, centerX-100, startY, 200, 20, getGhostLabel()));
        this.buttonList.add(new GuiButton(2, centerX-100, startY+spacing, 200, 20, getFlyLabel()));
        this.buttonList.add(new GuiButton(3, centerX-100, startY+spacing*2, 200, 20, getSprintLabel()));
        this.buttonList.add(new GuiButton(4, centerX-100, startY+spacing*3, 200, 20, getFullBrightLabel()));
        this.buttonList.add(new GuiButton(5, centerX-100, startY+spacing*4, 200, 20, getFpsLabel()));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        switch (button.id){
            case 1:
                GhostSettings.ghostMode = !GhostSettings.ghostMode;
                button.displayString = getGhostLabel();
                ConfigManager.save();
                break;
            case 2:
                GhostSettings.keepFly = !GhostSettings.keepFly;
                button.displayString = getFlyLabel();
                ConfigManager.save();
                break;
            case 3:
                GhostSettings.toggleSprint = !GhostSettings.toggleSprint;
                button.displayString = getSprintLabel();
                ConfigManager.save();
                break;
            case 4:
                GhostSettings.fullBright = !GhostSettings.fullBright;
                button.displayString = getFullBrightLabel();
                ConfigManager.save();
                break;
            case 5:
                GhostSettings.showFPS = !GhostSettings.showFPS;
                button.displayString = getFpsLabel();
                ConfigManager.save();
                break;
        }

    }

    private String getGhostLabel(){
        return "GhostBlocks: " + (GhostSettings.ghostMode ? green + "ON" : red + "OFF");
    }

    private String getFlyLabel(){
        return "KeepFly: " + (GhostSettings.keepFly ? green + "ON" : red + "OFF");
    }

    private String getSprintLabel(){
        return "ToggleSprint: " + (GhostSettings.toggleSprint ? green + "ON" : red + "OFF");
    }

    private String getFullBrightLabel(){
        return "FullBright: " + (GhostSettings.fullBright ? green + "ON" : red + "OFF");
    }

    private String getFpsLabel(){
        return "Display FPS: " + (GhostSettings.showFPS ? green + "ON" : red + "OFF");
    }


    @Override
    public boolean doesGuiPauseGame(){
        return false;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawGradientRect(0, 0, width, height, 0xCC121212, 0xCC1E1E1E);
        drawCenteredString(fontRendererObj, EnumChatFormatting.BOLD + "GhostMod GUI", width / 2, 100, 0xFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

}
