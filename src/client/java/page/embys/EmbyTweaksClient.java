package page.embys;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import page.embys.common.BlockSet;
import page.embys.common.WoodBlockSet;
import page.embys.kiln.KilnMainClient;

import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class EmbyTweaksClient implements ClientModInitializer {
	public static final HashMap<BlockSet, BlockFamily> BLOCK_FAMILY_MAP = new HashMap<>();
	public static final HashMap<WoodBlockSet, ModelLayerLocation> BOAT_MODEL_LAYER_MAP = new HashMap<>();
	public static final HashMap<WoodBlockSet, ModelLayerLocation> CHEST_BOAT_MODEL_LAYER_MAP = new HashMap<>();

	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.putBlock(BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "charred_door")), ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "charred_trapdoor")), ChunkSectionLayer.CUTOUT);

		KilnMainClient.init();

		createModelLayers();
		registerModelLayers((a, b) -> EntityModelLayerRegistry.registerModelLayer(a, b::get));
		registerEntityRenderers(EntityRenderers::register);
	}

	public static void createModelLayers() {
		for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
			if (blockSet instanceof WoodBlockSet woodBlockSet) {
				BOAT_MODEL_LAYER_MAP.put(woodBlockSet, new ModelLayerLocation(EmbyTweaks.id("boat/" + woodBlockSet.identifier.getPath()), "main"));
				CHEST_BOAT_MODEL_LAYER_MAP.put(woodBlockSet, new ModelLayerLocation(EmbyTweaks.id("chest_boat/" + woodBlockSet.identifier.getPath()), "main"));
			}
		}
	}

	public static void registerModelLayers(BiConsumer<ModelLayerLocation, Supplier<LayerDefinition>> consumer) {
		for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
			if (blockSet instanceof WoodBlockSet woodBlockSet) {
				consumer.accept(
						BOAT_MODEL_LAYER_MAP.get(woodBlockSet),
						BoatModel::createBoatModel
				);
				consumer.accept(
						CHEST_BOAT_MODEL_LAYER_MAP.get(woodBlockSet),
						BoatModel::createChestBoatModel
				);
			}
		}
	}

	public static void registerEntityRenderers(BiConsumer<EntityType<? extends Entity>, EntityRendererProvider> consumer) {
		for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
			if (blockSet instanceof WoodBlockSet woodBlockSet) {
				consumer.accept(woodBlockSet.boat.get(), context -> new BoatRenderer(context, BOAT_MODEL_LAYER_MAP.get(blockSet)));
				consumer.accept(woodBlockSet.chestBoat.get(), context -> new BoatRenderer(context, CHEST_BOAT_MODEL_LAYER_MAP.get(blockSet)));
			}
		};
	}
}