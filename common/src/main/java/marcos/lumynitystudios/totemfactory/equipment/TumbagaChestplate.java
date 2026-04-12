package marcos.lumynitystudios.totemfactory.equipment;

import marcos.lumynitystudios.totemfactory.init.TfArmorMaterials;
import net.minecraft.world.item.ArmorItem;

public class TumbagaChestplate extends ArmorItem {
    public TumbagaChestplate() {
        super(TfArmorMaterials.TUMBAGA, Type.CHESTPLATE, new Properties().stacksTo(1).durability(Type.CHESTPLATE.getDurability(TfArmorMaterials.TUMBAGA_DURABILITY)));
    }
}

