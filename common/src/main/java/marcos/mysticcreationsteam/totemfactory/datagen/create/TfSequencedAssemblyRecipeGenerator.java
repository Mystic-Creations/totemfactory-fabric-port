package marcos.mysticcreationsteam.totemfactory.datagen.create;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllFluids;
import com.simibubi.create.api.data.recipe.SequencedAssemblyRecipeGen;
import com.simibubi.create.content.fluids.potion.PotionFluid;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import com.simibubi.create.content.kinetics.saw.CuttingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingOutput;
import marcos.mysticcreationsteam.totemfactory.ModLoaderHelper;
import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import marcos.mysticcreationsteam.totemfactory.init.TfItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class TfSequencedAssemblyRecipeGenerator extends SequencedAssemblyRecipeGen {
    public TfSequencedAssemblyRecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, TotemFactory.MODID);
    }

    GeneratedRecipe
        TOTEM_BODY = create("totem/totem_body", b ->
            b
                .transitionTo(TfItems.INCOMPLETE_TOTEM_BODY.get())
                .require(TfItems.TOTEM_BODY_CASING.get())
                .loops(1)
                .addStep(DeployerApplicationRecipe::new, rb ->
                    rb.require(Items.GHAST_TEAR)
                )
                .addStep(DeployerApplicationRecipe::new, rb ->
                    rb.require(TfItems.TUMBAGA_ALLOY.get())
                        .withSingleItemOutput(new ItemStack(TfItems.TOTEM_BODY.get()))
                )
                .addOutput(TfItems.TOTEM_BODY.get(), 1f)
        ),

    TOTEM_BODY_CASING = create("totem/totem_body_casing", b ->
        b
            .transitionTo(TfItems.INCOMPLETE_TOTEM_BODY_CASING.get())
            .require(TfItems.TUMBAGA_ALLOY.get())
            .addOutput(TfItems.TOTEM_BODY_CASING.get(), 1f)
            .loops(1)
            .addStep(CuttingRecipe::new, rb -> rb.duration(50)
                .withItemIngredients(Ingredient.of(TfItems.TUMBAGA_ALLOY.get()))
            )
            .addStep(PressingRecipe::new, rb -> rb
                .withSingleItemOutput(new ItemStack(TfItems.TOTEM_BODY_CASING.get()))
            )
    ),

    TOTEM_HEAD = create("totem/totem_head", b ->
        b
            .transitionTo(TfItems.INCOMPLETE_TOTEM_HEAD.get())
            .require(TfItems.TOTEM_HEAD_CASING.get())
            .loops(1)
            .addStep(FillingRecipe::new, rb ->
                ModLoaderHelper.createFluidIngredient(
                    rb,
                    AllFluids.POTION.get(),
                    250,
                    Potions.FIRE_RESISTANCE
                )
            )
            .addStep(FillingRecipe::new, rb ->
                ModLoaderHelper.createFluidIngredient(
                    rb,
                    AllFluids.POTION.get(),
                    250,
                    Potions.REGENERATION
                )
            )
            .addStep(DeployerApplicationRecipe::new, rb ->
                rb.require(TfItems.TUMBAGA_ALLOY.get())
                    .withSingleItemOutput(new ItemStack(TfItems.TOTEM_HEAD.get()))
            )
            .addOutput(TfItems.TOTEM_HEAD.get(), 1f)
    ),

    TOTEM_HEAD_CASING = create("totem/totem_head_casing", b ->
        b
            .transitionTo(TfItems.INCOMPLETE_TOTEM_HEAD_CASING.get())
            .require(TfItems.TUMBAGA_SHEET.get())
            .loops(1)
            .addStep(CuttingRecipe::new, rb -> rb.duration(50)
                .withItemIngredients(Ingredient.of(TfItems.TUMBAGA_SHEET.get()))
            )
            .addStep(PressingRecipe::new, rb -> rb
                .withSingleItemOutput(new ItemStack(TfItems.TOTEM_HEAD_CASING.get()))
            )
            .addOutput(TfItems.TOTEM_HEAD_CASING.get(), 1f)
    ),

    TOTEM_OF_UNDYING_DEPLOY = create("totem/totem_of_undying_deploy", b ->
        b
            .transitionTo(TfItems.INCOMPLETE_TOTEM_OF_UNDYING.get())
            .loops(5)
            .require(TfItems.INACTIVE_TOTEM.get())
            .addStep(DeployerApplicationRecipe::new, rb -> rb
                .withItemIngredients(Ingredient.of(new ItemStack(TfItems.INACTIVE_TOTEM.get())), Ingredient.of(AllBlocks.EXPERIENCE_BLOCK))
                .withSingleItemOutput(new ItemStack(TfItems.INACTIVE_TOTEM.get()))
            )
            .addOutput(Items.TOTEM_OF_UNDYING, 1f)
    );


}
