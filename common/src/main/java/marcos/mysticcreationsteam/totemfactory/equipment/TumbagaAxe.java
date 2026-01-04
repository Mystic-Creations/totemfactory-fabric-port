package marcos.mysticcreationsteam.totemfactory.equipment;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Rarity;

public class TumbagaAxe extends AxeItem {
    public TumbagaAxe() {
        super(TumbagaTier.AXE, new Properties().stacksTo(1).rarity(Rarity.COMMON).attributes(createAttributes(TumbagaTier.AXE, -1.0f, -3.1f)));
    }
}