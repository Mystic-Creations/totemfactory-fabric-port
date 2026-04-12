package marcos.lumynitystudios.totemfactory.equipment;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class TumbagaHelmet extends ArmorItem {
    public TumbagaHelmet() {
        super(TumbagaArmorMaterial.INSTANCE, Type.HELMET, new Item.Properties().stacksTo(1));
    }
}

