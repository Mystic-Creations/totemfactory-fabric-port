package marcos.mysticcreationsteam.totemfactory.equipment;

import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class TumbagaShovel extends ShovelItem {
    public TumbagaShovel() {
        super(TumbagaTier.SHOVEL, new Properties().stacksTo(1).rarity(Rarity.COMMON).attributes(createAttributes(TumbagaTier.SHOVEL, 0f, -3f)));
        //f - Attack Damage Modifier (final_dmg = base_damage + f)
        //g - Attack Speed Modifier (final_speed = g + 4.0)
    }
}
