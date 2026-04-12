package marcos.lumynitystudios.totemfactory.init.forge;

import marcos.lumynitystudios.totemfactory.TotemFactory;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class TfItemsImpl {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, TotemFactory.MODID);

    public static Supplier<Item> register(String registryName, Supplier<Item> item) {
        return REGISTER.register(registryName, item);
    }
}
