package marcos.lumynitystudios.totemfactory.init.neoforge;

import marcos.lumynitystudios.totemfactory.TotemFactory;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TfItemsImpl {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(BuiltInRegistries.ITEM, TotemFactory.MODID);

    public static Supplier<Item> register(String registryName, Supplier<Item> item) {
        return REGISTER.register(registryName, item);
    }
}
