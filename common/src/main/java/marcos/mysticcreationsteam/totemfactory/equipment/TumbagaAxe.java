package marcos.mysticcreationsteam.totemfactory.equipment;

import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class TumbagaAxe extends AxeItem {
    public TumbagaAxe() {
        super(TumbagaTier.AXE, new Properties().stacksTo(1).rarity(Rarity.COMMON).attributes(createAttributes(TumbagaTier.AXE, -1.0f, -3.1f)));
        //f - Attack Damage Modifier (final_dmg = base_damage + f), sometimes it's weird and you need to make it -1
        //g - Attack Speed Modifier (final_speed = g + 4.0)
    }
}