package marcos.lumynitystudios.totemfactory.init.forge;

import marcos.lumynitystudios.totemfactory.TotemFactory;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class TfBlocksImpl {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, TotemFactory.MODID);

    public static Supplier<Block> register(String registryName, Supplier<Block> block) {
        return REGISTER.register(registryName, block);
    }
}
