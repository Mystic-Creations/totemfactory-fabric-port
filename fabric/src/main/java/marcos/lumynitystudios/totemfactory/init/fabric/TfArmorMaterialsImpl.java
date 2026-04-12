package marcos.lumynitystudios.totemfactory.init.fabric;

import marcos.lumynitystudios.totemfactory.TotemFactory;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorMaterial;

import java.util.function.Supplier;

public class TfArmorMaterialsImpl {
    public static Holder<ArmorMaterial> register(String registryName, Supplier<ArmorMaterial> material) {
        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, TotemFactory.asResource(registryName), material.get());
    }
}
