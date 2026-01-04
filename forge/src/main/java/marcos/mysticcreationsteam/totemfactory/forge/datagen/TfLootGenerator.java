package marcos.mysticcreationsteam.totemfactory.forge.datagen;

import marcos.mysticcreationsteam.totemfactory.datagen.TfLootTableGenerator;
import marcos.mysticcreationsteam.totemfactory.init.forge.TfBlocksImpl;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class TfLootGenerator extends LootTableProvider {
    public TfLootGenerator(PackOutput arg) {
        super(arg, Set.of(), List.of(
            new LootTableProvider.SubProviderEntry(BlockLootGenerator::new, LootContextParamSets.BLOCK)
        ));
    }

    public static class BlockLootGenerator extends BlockLootSubProvider {
        protected BlockLootGenerator() {
            super(Set.of(), FeatureFlags.VANILLA_SET, new HashMap<>());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return TfBlocksImpl.REGISTER.getEntries().stream().map(RegistryObject::get).collect(Collectors.toSet());
        }

        @Override
        protected void generate() {
            TfLootTableGenerator.generateBlockLoot(this);
        }
    }
}
