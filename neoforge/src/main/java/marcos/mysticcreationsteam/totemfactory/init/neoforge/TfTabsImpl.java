package marcos.mysticcreationsteam.totemfactory.init.neoforge;

import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import marcos.mysticcreationsteam.totemfactory.init.TfTabs;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TfTabsImpl {
    public static final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TotemFactory.MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB_TOTEM_FACTORY = REGISTER.register("totem_factory",
        () -> CreativeModeTab.builder()
            .title(TfTabs.TITLE)
            .icon(() -> new ItemStack(Items.TOTEM_OF_UNDYING))
            .displayItems((parameters, tabData) -> TfTabs.addOutputItems(tabData))
            .build()
    );

    public static void load() {
    }
}
