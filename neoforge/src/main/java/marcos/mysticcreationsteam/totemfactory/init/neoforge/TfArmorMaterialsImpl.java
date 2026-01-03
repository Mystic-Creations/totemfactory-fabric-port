package marcos.mysticcreationsteam.totemfactory.init.neoforge;

import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TfArmorMaterialsImpl {
    public static final DeferredRegister<ArmorMaterial> REGISTER = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, TotemFactory.MODID);

    public static Holder<ArmorMaterial> register(String registryName, Supplier<ArmorMaterial> material) {
        return REGISTER.register(registryName, material);
    }
}
