package marcos.lumynitystudios.totemfactory.init.fabric;

import marcos.lumynitystudios.totemfactory.init.TfTabs;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TfTabsImpl {
	public static void load() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TfTabs.RESOURCE_KEY,
			FabricItemGroup.builder()
                .title(TfTabs.TITLE)
                .icon(() -> new ItemStack(Items.TOTEM_OF_UNDYING))
                .displayItems((params, tabData) -> TfTabs.addOutputItems(tabData))
				.build()
		);
	}
}
