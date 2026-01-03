package marcos.mysticcreationsteam.totemfactory.init;

import dev.architectury.injectables.annotations.ExpectPlatform;
import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class TfArmorMaterials {
    public static final Holder<ArmorMaterial> TUMBAGA = register("tumbaga", () ->
        new ArmorMaterial(
            Map.of(
                ArmorItem.Type.HELMET, 2,
                ArmorItem.Type.CHESTPLATE, 6,
                ArmorItem.Type.LEGGINGS, 5,
                ArmorItem.Type.BOOTS, 2
            ),
            9, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(TfItems.TUMBAGA_ALLOY.get()),
            List.of(new ArmorMaterial.Layer(TotemFactory.asResource("tumbaga"))),
            0f, 0f
        )
    );

    public static final int TUMBAGA_DURABILITY = 15;

    public static void load() {}

    @ExpectPlatform
    public static Holder<ArmorMaterial> register(String registryName, Supplier<ArmorMaterial> material) {
        throw new IllegalStateException();
    }
}
