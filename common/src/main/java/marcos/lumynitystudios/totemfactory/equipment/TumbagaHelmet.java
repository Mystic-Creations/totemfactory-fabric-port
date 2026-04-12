package marcos.lumynitystudios.totemfactory.equipment;

import marcos.lumynitystudios.totemfactory.init.TfArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class TumbagaHelmet extends ArmorItem {
    public TumbagaHelmet() {
        super(TfArmorMaterials.TUMBAGA, Type.HELMET, new Item.Properties().stacksTo(1).durability(Type.HELMET.getDurability(TfArmorMaterials.TUMBAGA_DURABILITY)));
    }
}

