package marcos.mysticcreationsteam.totemfactory.equipment;

import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class TumbagaSword extends SwordItem {
    public TumbagaSword() {
        super(TumbagaTier.SWORD, new Properties().stacksTo(1).rarity(Rarity.COMMON).attributes(createAttributes(TumbagaTier.SWORD, 0, -2.4f)));
        //i - Attack Damage Modifier (final_dmg = base_damage + f)
        //f - Attack Speed Modifier (f = desired_speed - 4.0)
    }
}
