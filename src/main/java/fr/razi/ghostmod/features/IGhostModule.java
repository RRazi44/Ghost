package fr.razi.ghostmod.features;

public interface IGhostModule {
    String getName();
    void toggle();
    boolean isEnabled();
    void onTick();
    void onRender();
}
