package marcos.mysticcreationsteam.totemfactory.forge;

import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.foundation.fluid.FluidIngredient;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Container;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fluids.FluidStack;

public class ModLoaderHelperImpl {
    public static boolean isFakePlayer(ServerPlayer player) {
        return player instanceof FakePlayer;
    }

    public static <U extends Container, T extends ProcessingRecipe<U>> ProcessingRecipeBuilder<T> createFluidIngredient(ProcessingRecipeBuilder<T> builder, Fluid fluid, int millibuckets, Potion potion) {
        return builder.require(FluidIngredient.fromFluidStack(new FluidStack(fluid, millibuckets,
            Util.make(new CompoundTag(), tag ->
                tag.putString("Potion", BuiltInRegistries.POTION.getKey(potion).toString())
            )
        )));
    }

    public static <U extends Container, T extends ProcessingRecipe<U>> ProcessingRecipeBuilder<T> createFluidIngredient(ProcessingRecipeBuilder<T> builder, TagKey<Fluid> fluidTag, int millibuckets) {
        return builder.require(FluidIngredient.fromTag(fluidTag, millibuckets));
    }
}
