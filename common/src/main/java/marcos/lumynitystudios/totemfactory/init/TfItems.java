package marcos.lumynitystudios.totemfactory.init;

import dev.architectury.injectables.annotations.ExpectPlatform;
import marcos.lumynitystudios.totemfactory.equipment.*;
import marcos.lumynitystudios.totemfactory.item.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class TfItems {
    //Tumbaga (Resource)
    public static Supplier<Item> TUMBAGA_BLOCK = register("tumbaga_block", () -> new BlockItem(TfBlocks.TUMBAGA_BLOCK.get(), new Item.Properties().stacksTo(64)));
    public static Supplier<Item> TUMBAGA_ALLOY = register("tumbaga_alloy", TumbagaAlloy::new);
    public static Supplier<Item> TUMBAGA_NUGGET = register("tumbaga_nugget", TumbagaNugget::new);
    public static Supplier<Item> TUMBAGA_SHEET = register("tumbaga_sheet", TumbagaSheet::new);
    //Tumbaga (Equipment)
    public static Supplier<Item> TUMBAGA_SWORD = register("tumbaga_sword", TumbagaSword::new);
    public static Supplier<Item> TUMBAGA_AXE = register("tumbaga_axe", TumbagaAxe::new);
    public static Supplier<Item> TUMBAGA_PICKAXE = register("tumbaga_pickaxe", TumbagaPickaxe::new);
    public static Supplier<Item> TUMBAGA_SHOVEL = register("tumbaga_shovel", TumbagaShovel::new);
    public static Supplier<Item> TUMBAGA_HOE = register("tumbaga_hoe", TumbagaHoe::new);
    public static Supplier<Item> TUMBAGA_HELMET = register("tumbaga_helmet", TumbagaHelmet::new);
    public static Supplier<Item> TUMBAGA_CHESTPLATE = register("tumbaga_chestplate", TumbagaChestplate::new);
    public static Supplier<Item> TUMBAGA_LEGGINGS = register("tumbaga_leggings", TumbagaLeggings::new);
    public static Supplier<Item> TUMBAGA_BOOTS = register("tumbaga_boots", TumbagaBoots::new);
    //Totem
    public static Supplier<Item> TOTEM_HEAD = register("totem_head", TotemHead::new);
    public static Supplier<Item> INCOMPLETE_TOTEM_HEAD = register("incomplete_totem_head", IncompleteTotemHead::new);
    public static Supplier<Item> TOTEM_HEAD_CASING = register("totem_head_casing", TotemHeadCasing::new);
    public static Supplier<Item> INCOMPLETE_TOTEM_HEAD_CASING = register("incomplete_totem_head_casing", IncompleteTotemHeadCasing::new);
    public static Supplier<Item> TOTEM_BODY = register("totem_body", TotemBody::new);
    public static Supplier<Item> TOTEM_BODY_CASING = register("totem_body_casing", TotemBodyCasing::new);
    public static Supplier<Item> INCOMPLETE_TOTEM_BODY = register("incomplete_totem_body", IncompleteTotemBody::new);
    public static Supplier<Item> INCOMPLETE_TOTEM_BODY_CASING = register("incomplete_totem_body_casing", IncompleteTotemBodyCasing::new);
    public static Supplier<Item> INACTIVE_TOTEM = register("inactive_totem", InactiveTotem::new);
    public static Supplier<Item> INCOMPLETE_TOTEM_OF_UNDYING = register("incomplete_totem_of_undying", IncompleteTotemOfUndying::new);

    public static void load() {}
    public static void clientLoad() {}

    @ExpectPlatform
    public static Supplier<Item> register(String registryName, Supplier<Item> item) {
        throw new IllegalStateException();
    }
}
