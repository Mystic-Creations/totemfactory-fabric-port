package marcos.mysticcreationsteam.totemfactory.fabric;

import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.simibubi.create.foundation.fluid.FluidIngredient;
import com.simibubi.create.infrastructure.fabric.transfer.CreateTransferUtil;
import net.fabricmc.fabric.api.entity.FakePlayer;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class ModLoaderHelperImpl {
    public static boolean isFakePlayer(ServerPlayer player) {
        return player instanceof FakePlayer;
    }

    public static StandardProcessingRecipe.Builder<FillingRecipe> createFluidIngredient(StandardProcessingRecipe.Builder<FillingRecipe> builder, Holder<Fluid> fluid, int millibuckets, DataComponentPatch components) {
        return builder.require(new FluidIngredient.FluidStackIngredient(fluid.value(), components, (long) ((millibuckets / 1000.0) * (double) FluidConstants.BLOCK)));
    }

    public static StandardProcessingRecipe.Builder<FillingRecipe> createFluidIngredient(StandardProcessingRecipe.Builder<FillingRecipe> builder, TagKey<Fluid> fluidTag, int millibuckets) {
        return builder.require(new FluidIngredient.FluidTagIngredient(fluidTag, (long) ((millibuckets / 1000.0) * (double) FluidConstants.BLOCK)));
    }
}
