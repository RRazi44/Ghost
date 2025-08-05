package fr.razi.ghostmod;

import fr.razi.ghostmod.config.ConfigManager;
import fr.razi.ghostmod.eventhandler.GhostEventHandler;
import fr.razi.ghostmod.features.GhostModuleManager;
import fr.razi.ghostmod.gui.GhostGUI;
import net.minecraft.client.Minecraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

import org.apache.logging.log4j.LogManager;

@Mod(modid= "Ghost", name= "Ghost", version = "1.1")
public class Ghost {

    public static final Minecraft mc = Minecraft.getMinecraft();
    public static final GhostModuleManager ghostManager = new GhostModuleManager(mc);
    public static final Logger LOGGER = LogManager.getLogger("GhostMod");

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(new GhostEventHandler());

        new GhostKey("Open Ghost GUI", Keyboard.KEY_J, "GhostMod",minecraft -> mc.displayGuiScreen(new GhostGUI())
        );
        ConfigManager.load();
    }
}