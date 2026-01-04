package marcos.mysticcreationsteam.totemfactory;

import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class ModLoaderHelper {
    @ExpectPlatform
    public static boolean isFakePlayer(ServerPlayer player) {
        throw new IllegalStateException();
    }

    @ExpectPlatform
    public static StandardProcessingRecipe.Builder<FillingRecipe> createFluidIngredient(StandardProcessingRecipe.Builder<FillingRecipe> builder, Holder<Fluid> fluid, int millibuckets, DataComponentPatch components) {
        throw new IllegalStateException();
    }

    @ExpectPlatform
    public static StandardProcessingRecipe.Builder<FillingRecipe> createFluidIngredient(StandardProcessingRecipe.Builder<FillingRecipe> builder, TagKey<Fluid> fluid, int millibuckets) {
        throw new IllegalStateException();
    }
}
