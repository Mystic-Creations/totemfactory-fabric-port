package marcos.lumynitystudios.totemfactory.equipment;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;

public class TumbagaSword extends SwordItem {
    public TumbagaSword() {
        super(TumbagaTier.SWORD, new Properties().stacksTo(1).rarity(Rarity.COMMON).attributes(createAttributes(TumbagaTier.SWORD, 0, -2.4f)));
    }
}
