package marcos.mysticcreationsteam.totemfactory.equipment;

import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class TumbagaHoe extends HoeItem {
    public TumbagaHoe() {
        super(TumbagaTier.HOE, new Properties().stacksTo(1).rarity(Rarity.COMMON).attributes(createAttributes(TumbagaTier.HOE, -1, -1.0f)));
        //i - Attack Damage Modifier (final_dmg = base_damage + f), sometimes it's weird and you need to make it -1
        //f - Attack Speed Modifier (f = desired_speed - 4.0)
    }
}