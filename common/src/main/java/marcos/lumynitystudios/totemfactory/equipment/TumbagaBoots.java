package marcos.lumynitystudios.totemfactory.equipment;

import marcos.lumynitystudios.totemfactory.init.TfArmorMaterials;
import net.minecraft.world.item.ArmorItem;

public class TumbagaBoots extends ArmorItem {
    public TumbagaBoots() {
        super(TfArmorMaterials.TUMBAGA, Type.BOOTS, new Properties().stacksTo(1).durability(Type.BOOTS.getDurability(TfArmorMaterials.TUMBAGA_DURABILITY)));
    }
}

