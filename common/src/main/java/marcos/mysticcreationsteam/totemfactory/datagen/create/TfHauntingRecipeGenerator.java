package marcos.mysticcreationsteam.totemfactory.datagen.create;

import com.simibubi.create.api.data.recipe.HauntingRecipeGen;
import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class TfHauntingRecipeGenerator extends HauntingRecipeGen {
    public TfHauntingRecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, TotemFactory.MODID);
    }

    GeneratedRecipe
        GHAST_TEAR = convert(Items.SNOWBALL, Items.GHAST_TEAR);
}
