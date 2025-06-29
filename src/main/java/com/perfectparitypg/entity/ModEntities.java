package com.perfectparitypg.entity;

import com.perfectparitypg.entity.creaking.Creaking;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;


public class ModEntities {

    private static final ResourceLocation CREAKING_ID = ResourceLocation.withDefaultNamespace("creaking");
    private static final ResourceKey<EntityType<?>> CREAKING_KEY = ResourceKey.create(Registries.ENTITY_TYPE, CREAKING_ID);
    private static final EntityType<Creaking> CREAKING_BUILT = EntityType.Builder.of(Creaking::new, MobCategory.CREATURE).sized(0.9f,2.7f).build();
    public static final EntityType<Creaking> CREAKING = Registry.register(BuiltInRegistries.ENTITY_TYPE, CREAKING_KEY, CREAKING_BUILT);

    public static final EntityType<PaleOakBoat> PALE_OAK_BOAT = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            ResourceLocation.withDefaultNamespace("pale_oak_boat"),
            EntityType.Builder.<PaleOakBoat>of(PaleOakBoat::new, MobCategory.MISC)
                    .sized(1.375F, 0.5625F)
                    .build()
    );

    public static final EntityType<PaleOakChestBoat> PALE_OAK_CHEST_BOAT = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            ResourceLocation.withDefaultNamespace("pale_oak_chest_boat"),
            EntityType.Builder.<PaleOakChestBoat>of(PaleOakChestBoat::new, MobCategory.MISC)
                    .sized(1.375F, 0.5625F)
                    .build()
    );

    public static void registerModEntities() {
        FabricDefaultAttributeRegistry.register(CREAKING, Creaking.createAttributes());
        // No attributes needed for boats
    }
}
