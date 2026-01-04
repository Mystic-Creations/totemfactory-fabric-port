package marcos.mysticcreationsteam.totemfactory.fabric.datagen;

import marcos.mysticcreationsteam.totemfactory.datagen.TfAdvancementGenerator;
import marcos.mysticcreationsteam.totemfactory.datagen.TfBlockTagGenerator;
import marcos.mysticcreationsteam.totemfactory.datagen.TfFluidTagGenerator;
import marcos.mysticcreationsteam.totemfactory.datagen.TfRecipeGenerator;
import marcos.mysticcreationsteam.totemfactory.datagen.create.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;

import java.util.List;

public class TfDataGeneratorFabric implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        var pack = generator.createPack();

        pack.addProvider(TfFillingRecipeGenerator::new);
        pack.addProvider(TfHauntingRecipeGenerator::new);
        pack.addProvider(TfItemApplicationRecipeGenerator::new);
        pack.addProvider(TfMechanicalCraftingRecipeGenerator::new);
        pack.addProvider(TfMixingRecipeGenerator::new);
        pack.addProvider(TfPressingRecipeGenerator::new);
        pack.addProvider(TfSequencedAssemblyRecipeGenerator::new);

        pack.addProvider((output, future) -> new AdvancementProvider(output, future, List.of(new TfAdvancementGenerator())));
        pack.addProvider(TfBlockLootGenerator::new);
        pack.addProvider(TfRecipeGenerator::new);
        pack.addProvider(TfBlockTagGenerator::new);
        pack.addProvider(TfFluidTagGenerator::new);
    }
}
