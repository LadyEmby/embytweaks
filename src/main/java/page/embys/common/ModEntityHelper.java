package page.embys.common;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import page.embys.EmbyTweaks;

import java.util.function.Supplier;

public class ModEntityHelper {
    public static <E extends Entity> Supplier<EntityType<E>> registerBoat(String name, EntityType.EntityFactory<E> factory) {
        ResourceKey<EntityType<?>> entityTypeRegistryKey = ResourceKey.create(Registries.ENTITY_TYPE, EmbyTweaks.id(name));
        return EmbyTweaks.register(BuiltInRegistries.ENTITY_TYPE, name, () -> EntityType.Builder.of(factory, MobCategory.MISC).sized(EntityType.OAK_BOAT.getWidth(), EntityType.OAK_BOAT.getHeight()).eyeHeight(0.5625F).clientTrackingRange(10).build(entityTypeRegistryKey));
    }
}