package marcos.mysticcreationsteam.totemfactory.datagen.create;

import com.simibubi.create.api.data.recipe.MechanicalCraftingRecipeGen;
import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class TfMechanicalCraftingRecipeGenerator extends MechanicalCraftingRecipeGen {
    public TfMechanicalCraftingRecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, TotemFactory.MODID);
    }

    GeneratedRecipe
        INACTIVE_TOTEM = create(TfItems.INACTIVE_TOTEM::get).returns(1)
            .recipe(b ->
                b
                    .key('E', Items.EMERALD)
                    .key('H', TfItems.TOTEM_HEAD.get())
                    .key('B', TfItems.TOTEM_BODY.get())
                    .patternLine("EHE")
                    .patternLine(" B ")
            );
}
