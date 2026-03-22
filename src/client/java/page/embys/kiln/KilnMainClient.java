package page.embys.kiln;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class KilnMainClient  {
    public static void init() {
        HandledScreens.register(KilnMain.KILN_SCREEN_HANDLER, KilnScreen::new);
    }
}
