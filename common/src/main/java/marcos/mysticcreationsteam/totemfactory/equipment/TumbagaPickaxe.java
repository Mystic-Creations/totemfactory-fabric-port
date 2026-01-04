package marcos.mysticcreationsteam.totemfactory.equipment;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;

public class TumbagaPickaxe extends PickaxeItem {
    public TumbagaPickaxe() {
        super(TumbagaTier.PICKAXE, new Properties().stacksTo(1).rarity(Rarity.COMMON).attributes(createAttributes(TumbagaTier.PICKAXE, 0, -2.8f)));
    }
}