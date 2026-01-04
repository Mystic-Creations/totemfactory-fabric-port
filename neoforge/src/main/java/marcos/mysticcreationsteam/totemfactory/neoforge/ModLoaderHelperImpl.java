package marcos.mysticcreationsteam.totemfactory.neoforge;

import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.util.FakePlayer;
import net.neoforged.neoforge.fluids.crafting.SingleFluidIngredient;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import net.neoforged.neoforge.fluids.crafting.TagFluidIngredient;

public class ModLoaderHelperImpl {
    public static boolean isFakePlayer(ServerPlayer player) {
        return player instanceof FakePlayer;
    }

    public static StandardProcessingRecipe.Builder<FillingRecipe> createFluidIngredient(StandardProcessingRecipe.Builder<FillingRecipe> builder, Holder<Fluid> fluid, int millibuckets, DataComponentPatch components) {
        return builder.require(new SizedFluidIngredient(new SingleFluidIngredient(fluid), millibuckets));
    }

    public static StandardProcessingRecipe.Builder<FillingRecipe> createFluidIngredient(StandardProcessingRecipe.Builder<FillingRecipe> builder, TagKey<Fluid> fluidTag, int millibuckets) {
        return builder.require(new SizedFluidIngredient(new TagFluidIngredient(fluidTag), millibuckets));
    }
}
