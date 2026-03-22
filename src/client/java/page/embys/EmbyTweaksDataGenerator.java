package page.embys;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Util;
import page.embys.common.BlockSet;
import page.embys.common.StoneBlockSet;
import page.embys.common.WoodBlockSet;
import page.embys.kiln.KilnRecipeProvider;

import java.util.concurrent.CompletableFuture;

public class EmbyTweaksDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
			BlockFamily blockFamily;
			if (blockSet instanceof WoodBlockSet woodBlockSet) {
				blockFamily = new BlockFamily.Builder(woodBlockSet.planksBlock)
						.door(woodBlockSet.doorBlock)
						.trapdoor(woodBlockSet.trapdoorBlock)
						.button(woodBlockSet.buttonBlock)
						.fence(woodBlockSet.fenceBlock)
						.fenceGate(woodBlockSet.fenceGateBlock)
						.pressurePlate(woodBlockSet.pressurePlateBlock)
						.slab(woodBlockSet.slabBlock)
						.stairs(woodBlockSet.stairsBlock)
						.sign(woodBlockSet.signBlock, woodBlockSet.wallSignBlock)
						.build();
			} else if (blockSet instanceof StoneBlockSet stoneBlockSet) {
				blockFamily = new BlockFamily.Builder(stoneBlockSet.block)
						.stairs(stoneBlockSet.stairsBlock)
						.slab(stoneBlockSet.slabBlock)
						.wall(stoneBlockSet.wallBlock)
						.build();
			} else {
				throw new IllegalStateException();
			}
			EmbyTweaksClient.BLOCK_FAMILY_MAP.put(blockSet, blockFamily);
		}

		CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture = CompletableFuture.supplyAsync(
				BuiltinRegistries::createWrapperLookup, Util.getMainWorkerExecutor()
		);
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(KilnRecipeProvider::new);

		pack.addProvider(EmbyTweaksRecipeProvider::new);
		pack.addProvider(EmbyTweaksBlocksTagProvider::new);
		pack.addProvider(EmbyTweaksItemTagProvider::new);
		pack.addProvider(EmbyTweaksBlocksModelProvider::new);
		pack.addProvider(EmbyTweaksLootTableProvider::new);
        pack.addProvider(EmbyTweaksEnglishTranslationProvider::new);  // provides translations for all packages within the mod
	}
}
