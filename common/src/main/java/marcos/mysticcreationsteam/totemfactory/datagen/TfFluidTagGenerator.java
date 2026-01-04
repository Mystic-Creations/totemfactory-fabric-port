package marcos.mysticcreationsteam.totemfactory.datagen;

import marcos.mysticcreationsteam.totemfactory.init.TfBlocks;
import marcos.mysticcreationsteam.totemfactory.init.TfFluidTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import java.util.concurrent.CompletableFuture;

public class TfFluidTagGenerator extends IntrinsicHolderTagsProvider<Fluid> {
    public TfFluidTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packOutput, Registries.FLUID, completableFuture, fluid -> BuiltInRegistries.FLUID.getResourceKey(fluid).orElseThrow());
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(TfFluidTags.EXPERIENCE_FLUID)
            .addOptional(new ResourceLocation("create_enchantment_industry", "experience"));
    }
}
