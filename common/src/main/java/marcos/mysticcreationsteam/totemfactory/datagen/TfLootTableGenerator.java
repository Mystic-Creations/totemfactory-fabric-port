package marcos.mysticcreationsteam.totemfactory.datagen;

import marcos.mysticcreationsteam.totemfactory.init.TfBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;

public class TfLootTableGenerator {
    public static void generateBlockLoot(BlockLootSubProvider provider) {
        provider.map.put(TfBlocks.TUMBAGA_BLOCK.get().getLootTable(), provider.createSingleItemTable(TfBlocks.TUMBAGA_BLOCK.get()));
    }
}
