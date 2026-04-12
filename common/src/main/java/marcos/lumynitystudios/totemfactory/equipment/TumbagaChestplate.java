package marcos.lumynitystudios.totemfactory.equipment;

import net.minecraft.world.item.ArmorItem;

public class TumbagaChestplate extends ArmorItem {
    public TumbagaChestplate() {
        super(TumbagaArmorMaterial.INSTANCE, Type.CHESTPLATE, new Properties().stacksTo(1));
    }
}

