package marcos.mysticcreationsteam.totemfactory.forge.datagen;

import marcos.mysticcreationsteam.totemfactory.datagen.TfAdvancementGenerator;
import marcos.mysticcreationsteam.totemfactory.datagen.TfBlockTagGenerator;
import marcos.mysticcreationsteam.totemfactory.datagen.TfFluidTagGenerator;
import marcos.mysticcreationsteam.totemfactory.datagen.TfRecipeGenerator;
import marcos.mysticcreationsteam.totemfactory.datagen.create.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TfDataGeneratorForge {
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new TfFillingRecipeGenerator(output, lookupProvider));
        generator.addProvider(event.includeServer(), new TfHauntingRecipeGenerator(output, lookupProvider));
        generator.addProvider(event.includeServer(), new TfItemApplicationRecipeGenerator(output));
        generator.addProvider(event.includeServer(), new TfMechanicalCraftingRecipeGenerator(output, lookupProvider));
        generator.addProvider(event.includeServer(), new TfMixingRecipeGenerator(output, lookupProvider));
        generator.addProvider(event.includeServer(), new TfPressingRecipeGenerator(output, lookupProvider));
        generator.addProvider(event.includeServer(), new TfSequencedAssemblyRecipeGenerator(output, lookupProvider));

        generator.addProvider(event.includeServer(), new AdvancementProvider(output, lookupProvider, List.of(new TfAdvancementGenerator())));
        generator.addProvider(event.includeServer(), new TfLootGenerator(output));
        generator.addProvider(event.includeServer(), new TfRecipeGenerator(output, lookupProvider));
        generator.addProvider(event.includeServer(), new TfBlockTagGenerator(output, lookupProvider));
        generator.addProvider(event.includeServer(), new TfFluidTagGenerator(output, lookupProvider));
    }
}
