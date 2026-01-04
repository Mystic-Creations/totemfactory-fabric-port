package marcos.mysticcreationsteam.totemfactory.datagen.create;

import com.simibubi.create.api.data.recipe.PressingRecipeGen;
import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class TfPressingRecipeGenerator extends PressingRecipeGen {
    public TfPressingRecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, TotemFactory.MODID);
    }

    GeneratedRecipe
        TUMBAGA_BLOCK = create("tumbaga_alloy/tumbaga_sheet", b ->
            b
                .require(TfItems.TUMBAGA_ALLOY.get())
                .output(TfItems.TUMBAGA_SHEET.get())
        );
}
