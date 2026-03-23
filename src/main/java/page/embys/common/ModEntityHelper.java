package page.embys.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import page.embys.EmbyTweaks;

import java.util.function.Supplier;

public class ModEntityHelper {
    public static <E extends Entity> Supplier<EntityType<E>> registerBoat(String name, EntityType.EntityFactory<E> factory) {
        RegistryKey<EntityType<?>> entityTypeRegistryKey = RegistryKey.of(RegistryKeys.ENTITY_TYPE, EmbyTweaks.id(name));
        return EmbyTweaks.register(Registries.ENTITY_TYPE, name, () -> EntityType.Builder.create(factory, SpawnGroup.MISC).dimensions(EntityType.OAK_BOAT.getWidth(), EntityType.OAK_BOAT.getHeight()).eyeHeight(0.5625F).maxTrackingRange(10).build(entityTypeRegistryKey));
    }
}