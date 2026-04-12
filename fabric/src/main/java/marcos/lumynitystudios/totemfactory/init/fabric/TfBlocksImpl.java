package marcos.lumynitystudios.totemfactory.init.fabric;

import marcos.lumynitystudios.totemfactory.TotemFactory;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class TfBlocksImpl {
    public static Supplier<Block> register(String registryName, Supplier<Block> item) {
        Block block = Registry.register(BuiltInRegistries.BLOCK, TotemFactory.asResource(registryName), item.get());
        return () -> block;
    }
}
