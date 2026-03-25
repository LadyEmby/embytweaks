package page.embys;

import net.fabricmc.api.ModInitializer;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.embys.charred_wood.CharredWoodMain;
import page.embys.common.BlockSetRegistry;
import page.embys.glazed_terracotta_blocks.GlazedTerracottaBlockSets;
import page.embys.kiln.KilnMain;
import page.embys.lodestone_compass_clone.CompassClone;
import page.embys.terracotta_blocks.TerracottaBlockSets;
import page.embys.concrete_blocks.ConcreteBlockSets;

import java.util.function.Supplier;

public class EmbyTweaks implements ModInitializer {
	public static final String MOD_ID = "emby_tweaks";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final BlockSetRegistry BLOCK_SET_REGISTRY = new BlockSetRegistry();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ConcreteBlockSets.init();
		TerracottaBlockSets.init();
//        GlazedTerracottaBlockSets.init(); // can't figure out uvlocked stairs :(
		CompassClone.initialize();
		KilnMain.init();
		CharredWoodMain.init();

		LOGGER.info("Initialized Emby's Tweaks! :)");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, path);
	}

	public static <T> Supplier<T> register(Registry<? super T> registry, String name, Supplier<T> value) {
		T value1 = Registry.register(registry, EmbyTweaks.id(name), value.get());
		return () -> value1;
	}
}