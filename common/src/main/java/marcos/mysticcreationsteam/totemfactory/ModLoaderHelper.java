package marcos.mysticcreationsteam.totemfactory;

import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Container;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.material.Fluid;

public class ModLoaderHelper {
    @ExpectPlatform
    public static boolean isFakePlayer(ServerPlayer player) {
        throw new IllegalStateException();
    }

    @ExpectPlatform
    public static <U extends Container, T extends ProcessingRecipe<U>> ProcessingRecipeBuilder<T> createFluidIngredient(ProcessingRecipeBuilder<T> builder, Fluid fluid, int millibuckets, Potion potion) {
        throw new IllegalStateException();
    }

    @ExpectPlatform
    public static <U extends Container, T extends ProcessingRecipe<U>> ProcessingRecipeBuilder<T> createFluidIngredient(ProcessingRecipeBuilder<T> builder, TagKey<Fluid> fluid, int millibuckets) {
        throw new IllegalStateException();
    }
}
