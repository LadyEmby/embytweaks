package page.embys;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactories;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import page.embys.common.BlockSet;
import page.embys.common.WoodBlockSet;
import page.embys.kiln.KilnMainClient;

import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class EmbyTweaksClient implements ClientModInitializer {
	public static final HashMap<BlockSet, BlockFamily> BLOCK_FAMILY_MAP = new HashMap<>();
	public static final HashMap<WoodBlockSet, EntityModelLayer> BOAT_MODEL_LAYER_MAP = new HashMap<>();
	public static final HashMap<WoodBlockSet, EntityModelLayer> CHEST_BOAT_MODEL_LAYER_MAP = new HashMap<>();

	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.putBlock(Registries.BLOCK.get(Identifier.of(EmbyTweaks.MOD_ID, "charred_door")), BlockRenderLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(Registries.BLOCK.get(Identifier.of(EmbyTweaks.MOD_ID, "charred_trapdoor")), BlockRenderLayer.CUTOUT);

		KilnMainClient.init();

		createModelLayers();
		registerModelLayers((a, b) -> EntityModelLayerRegistry.registerModelLayer(a, b::get));
		registerEntityRenderers(EntityRendererFactories::register);
	}

	public static void createModelLayers() {
		for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
			if (blockSet instanceof WoodBlockSet woodBlockSet) {
				BOAT_MODEL_LAYER_MAP.put(woodBlockSet, new EntityModelLayer(EmbyTweaks.id("boat/" + woodBlockSet.identifier.getPath()), "main"));
				CHEST_BOAT_MODEL_LAYER_MAP.put(woodBlockSet, new EntityModelLayer(EmbyTweaks.id("chest_boat/" + woodBlockSet.identifier.getPath()), "main"));
			}
		}
	}

	public static void registerModelLayers(BiConsumer<EntityModelLayer, Supplier<TexturedModelData>> consumer) {
		for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
			if (blockSet instanceof WoodBlockSet woodBlockSet) {
				consumer.accept(
						BOAT_MODEL_LAYER_MAP.get(woodBlockSet),
						BoatEntityModel::getTexturedModelData
				);
				consumer.accept(
						CHEST_BOAT_MODEL_LAYER_MAP.get(woodBlockSet),
						BoatEntityModel::getChestTexturedModelData
				);
			}
		}
	}

	public static void registerEntityRenderers(BiConsumer<EntityType<? extends Entity>, EntityRendererFactory> consumer) {
		for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
			if (blockSet instanceof WoodBlockSet woodBlockSet) {
				consumer.accept(woodBlockSet.boat.get(), context -> new BoatEntityRenderer(context, BOAT_MODEL_LAYER_MAP.get(blockSet)));
				consumer.accept(woodBlockSet.chestBoat.get(), context -> new BoatEntityRenderer(context, CHEST_BOAT_MODEL_LAYER_MAP.get(blockSet)));
			}
		};
	}
}