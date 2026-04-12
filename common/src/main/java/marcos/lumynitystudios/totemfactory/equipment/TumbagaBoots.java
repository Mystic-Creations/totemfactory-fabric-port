package marcos.lumynitystudios.totemfactory.equipment;

import net.minecraft.world.item.ArmorItem;

public class TumbagaBoots extends ArmorItem {
    public TumbagaBoots() {
        super(TumbagaArmorMaterial.INSTANCE, Type.BOOTS, new Properties().stacksTo(1));
    }
}

