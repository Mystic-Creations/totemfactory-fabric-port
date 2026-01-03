package marcos.mysticcreationsteam.totemfactory.equipment;

import marcos.mysticcreationsteam.totemfactory.init.TfArmorMaterials;
import net.minecraft.world.item.ArmorItem;

public class TumbagaLeggings extends ArmorItem {
    public TumbagaLeggings() {
        super(TfArmorMaterials.TUMBAGA, Type.LEGGINGS, new Properties().stacksTo(1).durability(Type.LEGGINGS.getDurability(TfArmorMaterials.TUMBAGA_DURABILITY)));
    }
}

