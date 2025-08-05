package fr.razi.ghostmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class GhostKey {

    private static final List<GhostKey> ALL = new ArrayList<>();

    private final KeyBinding binding;
    private final Consumer<Minecraft> onPress;
    private boolean wasDown = false;

    public GhostKey(String description, int keyCode, String category, Consumer<Minecraft> onPress) {
        this.binding = new KeyBinding(description, keyCode, category);
        this.onPress = onPress;
        ClientRegistry.registerKeyBinding(this.binding);
        ALL.add(this);
    }

    public void tick(Minecraft mc) {
        boolean isDown = Keyboard.isKeyDown(binding.getKeyCode());
        if(isDown && !wasDown) onPress.accept(mc);
        wasDown = isDown;
    }

    public static void tickAll() {
        for (GhostKey k : ALL) k.tick(Ghost.mc);
    }

    public KeyBinding getBinding() {
        return binding;
    }

}
