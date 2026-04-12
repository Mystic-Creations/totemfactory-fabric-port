package marcos.lumynitystudios.totemfactory.equipment;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Rarity;

public class TumbagaHoe extends HoeItem {
    public TumbagaHoe() {
        super(TumbagaTier.HOE, new Properties().stacksTo(1).rarity(Rarity.COMMON).attributes(createAttributes(TumbagaTier.HOE, -1, -1.0f)));
    }
}