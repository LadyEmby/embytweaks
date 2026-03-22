package page.embys.common;

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
    private static EntityType.EntityFactory<BoatEntity> boatFactory(Supplier<Item> itemSupplier) {
        return (type, world) -> new BoatEntity(type, world, itemSupplier);
    };

    public static Supplier<EntityType<BoatEntity>> registerBoat(String name, EntityType.EntityFactory<BoatEntity> factory) {
        RegistryKey<EntityType<?>> entityTypeRegistryKey = RegistryKey.of(RegistryKeys.ENTITY_TYPE, EmbyTweaks.id(name));
        return EmbyTweaks.register(Registries.ENTITY_TYPE, name, () -> EntityType.Builder.create(factory, SpawnGroup.MISC).build(entityTypeRegistryKey));
    }
}
