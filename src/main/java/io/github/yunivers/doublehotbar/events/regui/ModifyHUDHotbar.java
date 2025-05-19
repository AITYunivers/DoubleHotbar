package io.github.yunivers.doublehotbar.events.regui;

import io.github.yunivers.regui.event.HudWidgetRenderEvent;
import io.github.yunivers.regui.gui.hud.widget.HotbarWidget;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import org.lwjgl.opengl.GL11;

@SuppressWarnings("unused")
public class ModifyHUDHotbar extends DrawContext
{
    @EventListener
    public void modifyHud(HudWidgetRenderEvent event)
    {
        if (event.widget instanceof HotbarWidget hotbarWidget)
        {
            switch (event.stage)
            {
                case 0: // Pre-Render
                    event.setInflate(0, 18);
                    break;
                case 1: // Hotbar
                    this.drawTexture(event.scaledWidth / 2 - 91 + event.widgetDockOffsetX, event.scaledHeight - 40 + event.widgetDockOffsetY, 0, 0, 182, 21);
                    this.drawTexture(event.scaledWidth / 2 - 91 + event.widgetDockOffsetX, event.scaledHeight - 19 + event.widgetDockOffsetY, 0, 3, 182, 19);
                    event.cancelNextRender = true;
                    break;
                case 2: // Hotbar Selection
                    event.cancelNextRender = true;
                    break;
                case 5: // Render Hotbar Item
                    int slot = (int)event.args[0];
                    int x = event.scaledWidth / 2 - 90 + (slot % 9) * 20 + 2;
                    int y = event.scaledHeight - 16 - 3 - (slot >= 9 ? 18 : 0);
                    hotbarWidget.renderHotbarItem(event.hud, slot, x + event.widgetDockOffsetX, y + event.widgetDockOffsetY, event.tickDelta);
                    event.cancelNextRender = true;
                    break;
                case 9: // End of Function
                    PlayerInventory inv = event.hud.minecraft.player.inventory;
                    GL11.glEnable(3042);
                    GL11.glBindTexture(3553, event.hud.minecraft.textureManager.getTextureId("/gui/gui.png"));
                    drawTexture(event.scaledWidth / 2 - 91 - 1 + (inv.selectedSlot % 9) * 20 + event.widgetDockOffsetX, event.scaledHeight - 22 - 1 - (inv.selectedSlot >= 9 ? 18 : 0) + event.widgetDockOffsetY, 0, 22, 24, 24);
                    GL11.glDisable(3042);
                    break;
            }
        }
    }
}
