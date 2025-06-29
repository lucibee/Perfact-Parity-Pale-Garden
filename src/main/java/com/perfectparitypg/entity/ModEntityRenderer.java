package com.perfectparitypg.entity;

import com.perfectparitypg.entity.monster.CreakingRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

// Custom renderer for Pale Oak Boat
import com.perfectparitypg.entity.PaleOakBoatRenderer;

public class ModEntityRenderer {
    public static void registerEntityRenderers () {
        EntityRendererRegistry.register(ModEntities.CREAKING, CreakingRenderer::new);
        EntityRendererRegistry.register(ModEntities.PALE_OAK_BOAT, ctx -> new PaleOakBoatRenderer(ctx, false));
        EntityRendererRegistry.register(ModEntities.PALE_OAK_CHEST_BOAT, ctx -> new PaleOakBoatRenderer(ctx, true));
    }
}
