package marcos.mysticcreationsteam.totemfactory.datagen.create;

import com.simibubi.create.api.data.recipe.ItemApplicationRecipeGen;
import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import marcos.mysticcreationsteam.totemfactory.init.TfBlocks;
import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class TfItemApplicationRecipeGenerator extends ItemApplicationRecipeGen {
    public TfItemApplicationRecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, TotemFactory.MODID);
    }

    GeneratedRecipe
        TUMBAGA_CASING = create("tumbaga_alloy/casing/tumbaga_casing", b ->
            b
                .require(Items.BAMBOO_BLOCK)
                .require(TfItems.TUMBAGA_ALLOY.get())
                .output(TfBlocks.TUMBAGA_CASING.asItem())
        );
}
