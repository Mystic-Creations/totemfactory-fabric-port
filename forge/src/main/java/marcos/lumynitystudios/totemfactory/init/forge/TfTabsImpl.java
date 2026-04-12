package marcos.lumynitystudios.totemfactory.init.forge;

import marcos.lumynitystudios.totemfactory.TotemFactory;
import marcos.lumynitystudios.totemfactory.init.TfTabs;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TfTabsImpl {
    public static final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TotemFactory.MODID);
    public static final RegistryObject<CreativeModeTab> TAB_TOTEM_FACTORY = REGISTER.register("totem_factory",
        () -> CreativeModeTab.builder()
            .title(TfTabs.TITLE)
            .icon(() -> new ItemStack(Items.TOTEM_OF_UNDYING))
            .displayItems((parameters, tabData) -> TfTabs.addOutputItems(tabData))
            .build()
    );

    public static void load() {
    }
}
