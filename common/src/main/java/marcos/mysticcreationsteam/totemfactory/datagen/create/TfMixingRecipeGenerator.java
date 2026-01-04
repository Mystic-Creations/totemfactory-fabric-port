package marcos.mysticcreationsteam.totemfactory.datagen.create;

import com.simibubi.create.api.data.recipe.MixingRecipeGen;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class TfMixingRecipeGenerator extends MixingRecipeGen {
    public TfMixingRecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, TotemFactory.MODID);
    }

    GeneratedRecipe
        TUMBAGA_ALLOY = create("tumbaga_alloy/tumbaga_alloy_from_mixing", b ->
            b
                .requiresHeat(HeatCondition.HEATED)
                .require(Items.GOLD_INGOT)
                .require(Items.GOLD_INGOT)
                .require(Items.COPPER_INGOT)
                .output(TfItems.TUMBAGA_ALLOY.get(), 3)
        );
}
