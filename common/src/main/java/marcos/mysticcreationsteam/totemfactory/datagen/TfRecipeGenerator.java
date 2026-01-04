package marcos.mysticcreationsteam.totemfactory.datagen;

import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import marcos.mysticcreationsteam.totemfactory.init.TfBlocks;
import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class TfRecipeGenerator extends RecipeProvider {
    public TfRecipeGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packOutput, completableFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput output) {
        // Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, TfItems.TUMBAGA_HELMET.get())
            .define('#', TfItems.TUMBAGA_ALLOY.get())
            .pattern("###")
            .pattern("# #")
            .unlockedBy("has_alloy", has(TfItems.TUMBAGA_ALLOY.get()))
            .save(output, TotemFactory.asResource("tumbaga_alloy/armor/tumbaga_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, TfItems.TUMBAGA_CHESTPLATE.get())
            .define('#', TfItems.TUMBAGA_ALLOY.get())
            .pattern("# #")
            .pattern("###")
            .pattern("###")
            .unlockedBy("has_alloy", has(TfItems.TUMBAGA_ALLOY.get()))
            .save(output, TotemFactory.asResource("tumbaga_alloy/armor/tumbaga_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, TfItems.TUMBAGA_LEGGINGS.get())
            .define('#', TfItems.TUMBAGA_ALLOY.get())
            .pattern("###")
            .pattern("# #")
            .pattern("# #")
            .unlockedBy("has_alloy", has(TfItems.TUMBAGA_ALLOY.get()))
            .save(output, TotemFactory.asResource("tumbaga_alloy/armor/tumbaga_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, TfItems.TUMBAGA_BOOTS.get())
            .define('#', TfItems.TUMBAGA_ALLOY.get())
            .pattern("# #")
            .pattern("# #")
            .unlockedBy("has_alloy", has(TfItems.TUMBAGA_ALLOY.get()))
            .save(output, TotemFactory.asResource("tumbaga_alloy/armor/tumbaga_boots"));

        // Base
        threeByThreePacker(output, RecipeCategory.MISC, TfBlocks.TUMBAGA_BLOCK.get(), TfItems.TUMBAGA_ALLOY.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TfItems.TUMBAGA_ALLOY.get(), 9)
            .requires(TfBlocks.TUMBAGA_BLOCK.get())
            .unlockedBy("has_block", has(TfItems.TUMBAGA_BLOCK.get()))
            .save(output, TotemFactory.asResource("tumbaga_alloy/tumbaga_alloy_from_block"));

        threeByThreePacker(output, RecipeCategory.MISC, TfItems.TUMBAGA_ALLOY.get(), TfItems.TUMBAGA_NUGGET.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TfItems.TUMBAGA_NUGGET.get(), 9)
            .requires(TfItems.TUMBAGA_ALLOY.get())
            .unlockedBy("has_nugget", has(TfItems.TUMBAGA_NUGGET.get()))
            .save(output, TotemFactory.asResource("tumbaga_alloy/tumbaga_nugget"));

        // Tools
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, TfItems.TUMBAGA_AXE.get())
            .define('#', TfItems.TUMBAGA_ALLOY.get())
            .define('/', Items.STICK)
            .pattern("##")
            .pattern("#/")
            .pattern(" /")
            .unlockedBy("has_tumbaga", has(TfItems.TUMBAGA_ALLOY.get()))
            .save(output, TotemFactory.asResource("tumbaga_alloy/tools/tumbaga_axe_left"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, TfItems.TUMBAGA_AXE.get())
            .define('#', TfItems.TUMBAGA_ALLOY.get())
            .define('/', Items.STICK)
            .pattern("##")
            .pattern("/#")
            .pattern("/ ")
            .unlockedBy("has_tumbaga", has(TfItems.TUMBAGA_ALLOY.get()))
            .save(output, TotemFactory.asResource("tumbaga_alloy/tools/tumbaga_axe_right"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, TfItems.TUMBAGA_HOE.get())
            .define('#', TfItems.TUMBAGA_ALLOY.get())
            .define('/', Items.STICK)
            .pattern("##")
            .pattern(" /")
            .pattern(" /")
            .unlockedBy("has_tumbaga", has(TfItems.TUMBAGA_ALLOY.get()))
            .save(output, TotemFactory.asResource("tumbaga_alloy/tools/tumbaga_hoe_left"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, TfItems.TUMBAGA_HOE.get())
            .define('#', TfItems.TUMBAGA_ALLOY.get())
            .define('/', Items.STICK)
            .pattern("##")
            .pattern("/ ")
            .pattern("/ ")
            .unlockedBy("has_tumbaga", has(TfItems.TUMBAGA_ALLOY.get()))
            .save(output, TotemFactory.asResource("tumbaga_alloy/tools/tumbaga_hoe_right"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, TfItems.TUMBAGA_PICKAXE.get())
            .define('#', TfItems.TUMBAGA_ALLOY.get())
            .define('/', Items.STICK)
            .pattern("###")
            .pattern(" / ")
            .pattern(" / ")
            .unlockedBy("has_tumbaga", has(TfItems.TUMBAGA_ALLOY.get()))
            .save(output, TotemFactory.asResource("tumbaga_alloy/tools/tumbaga_pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, TfItems.TUMBAGA_SHOVEL.get())
            .define('#', TfItems.TUMBAGA_ALLOY.get())
            .define('/', Items.STICK)
            .pattern("#")
            .pattern("/")
            .pattern("/")
            .unlockedBy("has_tumbaga", has(TfItems.TUMBAGA_ALLOY.get()))
            .save(output, TotemFactory.asResource("tumbaga_alloy/tools/tumbaga_shovel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, TfItems.TUMBAGA_SWORD.get())
            .define('#', TfItems.TUMBAGA_ALLOY.get())
            .define('/', Items.STICK)
            .pattern("#")
            .pattern("#")
            .pattern("/")
            .unlockedBy("has_tumbaga", has(TfItems.TUMBAGA_ALLOY.get()))
            .save(output, TotemFactory.asResource("tumbaga_alloy/tools/tumbaga_sword"));
    }
}
