# 👻 Ghost Mod

A lightweight and modular Minecraft Forge 1.8.9 mod, designed to be clean, maintainable, and easily extensible.  
It includes a flexible feature management system and customizable keybindings.

---

## ✨ Current Features

- **Custom Key Management (`GhostKey`)**  
  Centralized handling for all key actions with an easy-to-extend system.
- **Open Ghost GUI** via a customizable keybinding (`R` by default).
- **Settings Save/Load** with `ConfigManager` (JSON powered by Gson).
- **Global Settings (`GhostSettings`)**:
  - Ghost Mode
  - Fly Mode
  - Toggle Sprint
  - Full Bright
  - Show FPS
- **Modular Architecture** ready to handle independent features.

---

## 📂 Project Structure

```
src/main/java/fr/razi/ghostmod
│
├── Ghost.java               # Main mod entry point
├── GhostEventHandler.java   # Handles Forge events
├── GhostKey.java            # Custom keybinding system
├── GhostSettings.java       # Stores global mod settings
│
├── config/
│   ├── ConfigManager.java   # Loads and saves configuration
│   └── GhostConfig.java     # Configuration data structure
│
├── gui/
│   └── GhostGUI.java        # Mod GUI screen
│
└── features/
    └── GhostFeatureManager.java  # Feature logic manager (to be replaced by modules)
```

---

## 🛠 Building

1. Clone the repository:
   ```bash
   git clone https://github.com/YOUR_USERNAME/Ghost.git
   cd Ghost
   ```

2. Build the mod with Gradle:
   ```bash
   ./gradlew build
   ```
   The compiled `.jar` will be in `build/libs`.

---

## 📜 License

This project is licensed under the MIT License.  
Feel free to use, modify, and distribute it, as long as you include the original license.

---

## 📌 Notes


- This mod is intended for **educational and personal use**.  
- Some mods can be considered as a cheat, so **check the server rules before using this mod in multiplayer**.  
- It does not include any malicious features.  
- The architecture is designed for adding clean, toggleable modules.
