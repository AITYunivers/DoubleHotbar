package io.github.yunivers.doublehotbar.events.init;

import io.github.yunivers.doublehotbar.client.gui.hud.widget.DoubleHotbarWidget;
import io.github.yunivers.regui.event.InGameHudWidgetInitEvent;
import io.github.yunivers.regui.gui.hud.widget.HotbarWidget;
import net.mine_diver.unsafeevents.listener.EventListener;

import javax.annotation.Nullable;

@SuppressWarnings("unused")
public class InitHudWidgets
{
    @EventListener()
    public void initHudWidgets(InGameHudWidgetInitEvent event)
    {
        @Nullable Integer index = null;
        for (int i = 0; i < event.hudWidgets.size(); i++)
            if (event.hudWidgets.get(i) instanceof HotbarWidget)
                index = i;

        if (index != null)
        {
            event.hudWidgets.add(index, new DoubleHotbarWidget());
            event.hudWidgets.removeIf(x -> x instanceof HotbarWidget);
        }
    }
}
