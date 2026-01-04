package marcos.mysticcreationsteam.totemfactory.equipment;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;

public class TumbagaShovel extends ShovelItem {
    public TumbagaShovel() {
        super(TumbagaTier.SHOVEL, new Properties().stacksTo(1).rarity(Rarity.COMMON).attributes(createAttributes(TumbagaTier.SHOVEL, 0f, -3f)));
    }
}
