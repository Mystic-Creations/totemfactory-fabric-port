package marcos.lumynitystudios.totemfactory.equipment;

import net.minecraft.world.item.ArmorItem;

public class TumbagaLeggings extends ArmorItem {
    public TumbagaLeggings() {
        super(TumbagaArmorMaterial.INSTANCE, Type.LEGGINGS, new Properties().stacksTo(1));
    }
}

