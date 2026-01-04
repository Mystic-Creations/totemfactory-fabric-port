package marcos.mysticcreationsteam.totemfactory.neoforge.datagen;

import marcos.mysticcreationsteam.totemfactory.datagen.TfLootTableGenerator;
import marcos.mysticcreationsteam.totemfactory.init.neoforge.TfBlocksImpl;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class TfLootGenerator extends LootTableProvider {
    public TfLootGenerator(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(arg, Set.of(), List.of(
            new LootTableProvider.SubProviderEntry(BlockLootGenerator::new, LootContextParamSets.BLOCK)
        ), completableFuture);
    }

    public static class BlockLootGenerator extends BlockLootSubProvider {
        protected BlockLootGenerator(HolderLookup.Provider provider) {
            super(Set.of(), FeatureFlags.VANILLA_SET, provider);
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return TfBlocksImpl.REGISTER.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toSet());
        }

        @Override
        protected void generate() {
            TfLootTableGenerator.generateBlockLoot(this);
        }
    }
}
