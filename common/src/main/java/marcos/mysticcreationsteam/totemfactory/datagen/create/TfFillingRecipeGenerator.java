package marcos.mysticcreationsteam.totemfactory.datagen.create;

import com.simibubi.create.api.data.recipe.FillingRecipeGen;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import marcos.mysticcreationsteam.totemfactory.ModLoaderHelper;
import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import marcos.mysticcreationsteam.totemfactory.init.TfFluidTags;
import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class TfFillingRecipeGenerator extends FillingRecipeGen {
    public TfFillingRecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, TotemFactory.MODID);
    }

    GeneratedRecipe
        TOTEM_OF_UNDYING_FROM_EXPERIENCE_FLUID = create("totem_of_undying_from_experience_fluid", b ->
        ModLoaderHelper.createFluidIngredient(
                (ProcessingRecipeBuilder) (Object) b // Create Fabric why are you like this
                    .require(TfItems.INACTIVE_TOTEM.get())
                    .output(Items.TOTEM_OF_UNDYING),

                TfFluidTags.EXPERIENCE_FLUID,
                135
            )
        );
}
