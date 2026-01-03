package marcos.mysticcreationsteam.totemfactory.equipment;

import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class TumbagaPickaxe extends PickaxeItem {
    public TumbagaPickaxe() {
        super(TumbagaTier.PICKAXE, new Properties().stacksTo(1).rarity(Rarity.COMMON).attributes(createAttributes(TumbagaTier.PICKAXE, 0, -2.8f)));
        //i - Attack Damage Modifier (final_dmg = base_damage + f)
        //f - Attack Speed Modifier (f = desired_speed - 4.0)
    }
}