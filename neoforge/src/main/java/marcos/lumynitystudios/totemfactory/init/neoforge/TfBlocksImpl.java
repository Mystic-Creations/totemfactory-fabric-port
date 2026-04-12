package marcos.lumynitystudios.totemfactory.init.neoforge;

import marcos.lumynitystudios.totemfactory.TotemFactory;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TfBlocksImpl {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(BuiltInRegistries.BLOCK, TotemFactory.MODID);

    public static Supplier<Block> register(String registryName, Supplier<Block> block) {
        return REGISTER.register(registryName, block);
    }
}
