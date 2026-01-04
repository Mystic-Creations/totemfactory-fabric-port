package marcos.mysticcreationsteam.totemfactory.datagen;

import marcos.mysticcreationsteam.totemfactory.init.TfBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class TfBlockTagGenerator extends IntrinsicHolderTagsProvider<Block> {
    public TfBlockTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packOutput, Registries.BLOCK, completableFuture, block -> BuiltInRegistries.BLOCK.getResourceKey(block).orElseThrow());
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(TfBlocks.TUMBAGA_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
            .add(TfBlocks.TUMBAGA_BLOCK.get());
    }
}
