package marcos.lumynitystudios.totemfactory.init;

import dev.architectury.injectables.annotations.ExpectPlatform;
import marcos.lumynitystudios.totemfactory.TotemFactory;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TfTabs {
    public static final ResourceKey<CreativeModeTab> RESOURCE_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, TotemFactory.asResource("totem_factory"));
    public static final Component TITLE = Component.translatable("item_group." + TotemFactory.MODID + ".totem_factory");

    @ExpectPlatform
    public static void load() {}

    public static void addOutputItems(CreativeModeTab.Output tabData) {
        //Resource
        tabData.accept(new ItemStack(TfBlocks.TUMBAGA_CASING.get(), 1));
        tabData.accept(TfItems.TUMBAGA_BLOCK.get());
        tabData.accept(TfItems.TUMBAGA_ALLOY.get());
        tabData.accept(TfItems.TUMBAGA_NUGGET.get());
        tabData.accept(TfItems.TUMBAGA_SHEET.get());
        //Tools
        tabData.accept(TfItems.TUMBAGA_SWORD.get());
        tabData.accept(TfItems.TUMBAGA_AXE.get());
        tabData.accept(TfItems.TUMBAGA_PICKAXE.get());
        tabData.accept(TfItems.TUMBAGA_SHOVEL.get());
        tabData.accept(TfItems.TUMBAGA_HOE.get());
        //Armor
        tabData.accept(TfItems.TUMBAGA_HELMET.get());
        tabData.accept(TfItems.TUMBAGA_CHESTPLATE.get());
        tabData.accept(TfItems.TUMBAGA_LEGGINGS.get());
        tabData.accept(TfItems.TUMBAGA_BOOTS.get());
        //Totem
        tabData.accept(TfItems.INACTIVE_TOTEM.get());
        tabData.accept(TfItems.TOTEM_HEAD.get());
        tabData.accept(TfItems.TOTEM_BODY.get());
        tabData.accept(TfItems.TOTEM_HEAD_CASING.get());
        tabData.accept(TfItems.TOTEM_BODY_CASING.get());
    }
}
