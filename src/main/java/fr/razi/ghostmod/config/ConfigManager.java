package fr.razi.ghostmod.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.razi.ghostmod.Ghost;
import fr.razi.ghostmod.GhostSettings;
import net.minecraft.client.Minecraft;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ConfigManager {

    private static final File CFG_DIR =
            new File(Minecraft.getMinecraft().mcDataDir, "config");
    private static final File CONFIG_FILE = new File(CFG_DIR, "ghostmod.json");

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .create();

    private static GhostConfig config = new GhostConfig();

    private static void applyFromConfigToSettings(GhostConfig c) {
        GhostSettings.ghostMode    = c.ghostMode;
        GhostSettings.keepFly      = c.flyMode;
        GhostSettings.toggleSprint = c.toggleSprint;
        GhostSettings.fullBright   = c.fullBright;
        GhostSettings.showFPS      = c.displayFPS;
    }

    private static GhostConfig snapshotFromSettings() {
        GhostConfig c = new GhostConfig();
        c.ghostMode   = GhostSettings.ghostMode;
        c.flyMode     = GhostSettings.keepFly;
        c.toggleSprint= GhostSettings.toggleSprint;
        c.fullBright  = GhostSettings.fullBright;
        c.displayFPS  = GhostSettings.showFPS;
        return c;
    }

    public static void load() {
        try {
            if (!CONFIG_FILE.exists()) {
                save();
                return;
            }

            try (Reader reader = Files.newBufferedReader(CONFIG_FILE.toPath(), StandardCharsets.UTF_8)) {
                GhostConfig loaded = GSON.fromJson(reader, GhostConfig.class);
                if (loaded == null) {
                    save();
                    return;
                }
                config = loaded;
                applyFromConfigToSettings(config);
            }

        } catch (Exception e) {
            Ghost.LOGGER.error("Failed to load GhostMod config", e);
        }
    }

    public static void save() {
        try {
            if (!CFG_DIR.exists() && !CFG_DIR.mkdirs()) {
                return;
            }
            config = snapshotFromSettings();

            Path tmp = Files.createTempFile("ghostmod", ".json.tmp");
            try (Writer w = Files.newBufferedWriter(tmp, StandardCharsets.UTF_8)) {
                GSON.toJson(config, w);
            }

            try {
                Files.move(tmp, CONFIG_FILE.toPath(), REPLACE_EXISTING, ATOMIC_MOVE);
            } catch (AtomicMoveNotSupportedException ex) {
                Files.move(tmp, CONFIG_FILE.toPath(), REPLACE_EXISTING);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}