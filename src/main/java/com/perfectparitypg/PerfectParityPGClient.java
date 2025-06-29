package com.perfectparitypg;

import com.perfectparitypg.entity.ModEntityRenderer;
import com.perfectparitypg.entity.ModModelLayers;
import com.perfectparitypg.entity.monster.CreakingModel;
import com.perfectparitypg.particle.ModParticles;
import com.perfectparitypg.particle.PaleOakParticle;
import com.perfectparitypg.particle.TrailParticle;
import com.perfectparitypg.world.biome.ModBiomes;
import com.perfectparitypg.world.level.block.ModBlocks;
import com.perfectparitypg.world.level.block.ModWoodTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import com.perfectparitypg.entity.PaleOakBoatRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.biome.Biome;

public class PerfectParityPGClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ModEntityRenderer.registerEntityRenderers();

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(), ModBlocks.RESIN_CLUMP, ModBlocks.POTTED_PALE_OAK_SAPLING,
                ModBlocks.PALE_OAK_SAPLING, ModBlocks.PALE_OAK_LEAVES, ModBlocks.PALE_HANGING_MOSS, ModBlocks.PALE_MOSS_CARPET,
                ModBlocks.OPEN_EYEBLOSSOM, ModBlocks.CLOSED_EYEBLOSSOM, ModBlocks.POTTED_CLOSED_EYEBLOSSOM, ModBlocks.POTTED_OPEN_EYEBLOSSOM);


        // Removed TerraformBoatClientHelper registration (no longer needed)

        Sheets.getHangingSignMaterial(ModWoodTypes.PALE_OAK);

        EntityModelLayerRegistry.registerModelLayer(
                ModModelLayers.CREAKING,
                CreakingModel::createBodyLayer
        );
        EntityModelLayerRegistry.registerModelLayer(
                PaleOakBoatRenderer.BOAT_LAYER,
                BoatModel::createBodyModel
        );
        EntityModelLayerRegistry.registerModelLayer(
                PaleOakBoatRenderer.CHEST_BOAT_LAYER,
                ChestBoatModel::createBodyModel
        );

        ParticleFactoryRegistry.getInstance().register(ModParticles.TRAIL, TrailParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.PALE_OAK_LEAVES, PaleOakParticle.PaleOakProvider::new);


        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            Biome biome = client.player.level().getBiome(client.player.blockPosition()).value();
            if (biome == client.player.level().registryAccess()
                    .registryOrThrow(net.minecraft.core.registries.Registries.BIOME)
                    .get(ModBiomes.PALE_GARDEN)) {
                client.getSoundManager().stop(null, SoundSource.MUSIC);
            }
        });
    }
}