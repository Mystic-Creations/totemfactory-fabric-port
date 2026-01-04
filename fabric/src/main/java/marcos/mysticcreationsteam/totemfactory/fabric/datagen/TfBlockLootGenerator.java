package marcos.mysticcreationsteam.totemfactory.fabric.datagen;

import marcos.mysticcreationsteam.totemfactory.datagen.TfLootTableGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class TfBlockLootGenerator extends FabricBlockLootTableProvider {
    protected TfBlockLootGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        TfLootTableGenerator.generateBlockLoot(this);
    }
}
