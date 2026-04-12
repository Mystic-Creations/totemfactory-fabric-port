package marcos.lumynitystudios.totemfactory.init.fabric;

import marcos.lumynitystudios.totemfactory.TotemFactory;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class TfItemsImpl {
    public static Supplier<Item> register(String registryName, Supplier<Item> itemSupplier) {
        Item item = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(TotemFactory.MODID, registryName), itemSupplier.get());
        return () -> item;
    }
}
