package io.github.yunivers.doublehotbar.mixin.entity.player;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(PlayerInventory.class)
public class PlayerInventoryMixin
{
    @ModifyConstant(
        method = "getSelectedItem",
        constant = @Constant(intValue = 9)
    )
    public int doublehotbar$getSelectedItem_extendMaxSelectedSlot(int value)
    {
        return value * 2;
    }

    @Environment(EnvType.CLIENT)
    @ModifyConstant(
        method = "setHeldItem",
        constant = @Constant(intValue = 9)
    )
    public int doublehotbar$setHeldItem_extendMaxSelectedSlot(int value)
    {
        return value * 2;
    }

    @Environment(EnvType.CLIENT)
    @ModifyConstant(
        method = "scrollInHotbar",
        constant = @Constant(intValue = 9)
    )
    public int doublehotbar$scrollInHotbar_extendMaxSelectedSlot(int value)
    {
        return value * 2;
    }
}
