package marcos.mysticcreationsteam.totemfactory.datagen;

import marcos.mysticcreationsteam.totemfactory.init.TfBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;

public class TfLootTableGenerator {
    public static void generateBlockLoot(BlockLootSubProvider provider) {
        provider.dropSelf(TfBlocks.TUMBAGA_BLOCK.get());
    }
}
