package com.perfectparitypg.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PaleOakBoat extends Boat {
    private static final EntityDataAccessor<Boolean> PALE_OAK = SynchedEntityData.defineId(PaleOakBoat.class, EntityDataSerializers.BOOLEAN);

    public PaleOakBoat(EntityType<? extends Boat> type, Level level) {
        super(type, level);
    }

    public PaleOakBoat(Level level, double x, double y, double z) {
        this(ModEntities.PALE_OAK_BOAT, level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(PALE_OAK, true);
    }

    @Override
    public Item getDropItem() {
        // Replace with your actual Pale Oak Boat item reference
        return com.perfectparitypg.world.item.ModItems.PALE_OAK_BOAT;
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("PaleOak", true);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        // Always true for Pale Oak
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(this.getDropItem());
    }
}
