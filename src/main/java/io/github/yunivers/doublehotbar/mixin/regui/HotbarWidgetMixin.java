package io.github.yunivers.doublehotbar.mixin.regui;

import io.github.yunivers.regui.gui.hud.widget.HotbarWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = HotbarWidget.class, remap = false)
public class HotbarWidgetMixin
{
    @ModifyConstant(
        method = "render",
        constant = @Constant(intValue = 9, ordinal = 0)
    )
    private int doublehotbar$render_doubleSlotCount(int original)
    {
        return original * 2;
    }
}
